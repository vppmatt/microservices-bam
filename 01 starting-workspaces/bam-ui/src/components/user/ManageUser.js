import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {
    addUserToAccessGroup,
    getAllAccessGroups,
    getUser,
    removeUserFromAccessGroup
} from "../../data/accessRestFunctions";


const ManageUser = () => {

    const [user, setUser]  = useState({});
    const [loading, setLoading] = useState(true);
    const {id} = useParams();
    const [accessGroups, setAccessGroups] = useState([]);
    const [selectedAccessGroup, setSelectedAccessGroup] = useState(-1);
    const [dataChanged, setDataChanged] = useState(true);

    useEffect(
        () => {
            if (dataChanged) {
                setDataChanged(false)
                getUser(id).then(result => {
                    setUser(result.data);
                    setLoading(false);
                })
            }

            if (accessGroups.length === 0)
            getAllAccessGroups().then (result => {
                setAccessGroups(result.data);
            })
        }
        , [id, dataChanged])


    const setupAccessGroup = (event) => {
        setSelectedAccessGroup(event.target.value)
    }
    const addAccessGroup = () => {
        addUserToAccessGroup(user.id, selectedAccessGroup)
            .then (result => {
                setDataChanged(true);
            })
    }

    const removeAccessGroup = (id) => {
        removeUserFromAccessGroup(user.id, id)
            .then (result => {
                setDataChanged(true);
            })
    }

    console.log(user);

    return <>
    <h2 className="mt-4 mb-4">Manage user : {user.name} ({user.email})</h2>
        <h3>Access Groups</h3>
        {!loading && <table className="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {user.accessGroups.map(accessGroup => <tr key={accessGroup.id}>
                <td>{accessGroup.id}</td>
                <td>{accessGroup.name}</td>
                <td><button className="btn btn-sm btn-danger"  onClick={ () => removeAccessGroup(accessGroup.id)}   >remove</button></td>
            </tr>)}

            </tbody>
        </table>}

            <div>
            <label htmlFor="groupselector">Add access group: </label>
            <select id="groupselector" onChange={ setupAccessGroup} value={selectedAccessGroup}>
            <option value ="-1" disabled={true}>--choose--</option>
        {accessGroups.map(accessGroup => <option value={accessGroup.id} key={accessGroup.id}>{accessGroup.name}</option>)}
            </select>
            <button disabled={selectedAccessGroup === -1} className="btn btn-sm btn-success" onClick={addAccessGroup}>add</button>
            </div>

        <h3>Locations</h3>
        <p>The user has access to these locations (determined by the access groups)</p>
        <ul>
            {!loading && user.locations.map(location => <li key={location} >{location}</li>)}
        </ul>
    </>
}

export default ManageUser;