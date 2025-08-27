import {useEffect, useState} from "react";
import {getAccessGroup, getAllAccessGroups} from "../../data/accessRestFunctions";
import AccessGroupRow from "./AccessGroupRow";
import AccessGroupLocations from "./AccessGroupLocations";
import AccessGroupUsers from "./AccessGroupUsers";



const AccessGroups = () => {

    const [accessGroups, setAccessGroups] = useState([]);
    const [dataChanged, setDataChanged] = useState(true);
    const [mode, setMode] = useState("");
    const [selectedAccessGroup, setSelectedAccessGroup] = useState({});

    useEffect( () => {
        if (dataChanged) {
            setDataChanged(false);
            getAllAccessGroups()
                .then(
                    result => {
                        if (result.status === 200) {
                            setAccessGroups(result.data);
                        } else {
                            console.log("load error ", result);
                        }
                    }
                )
                .catch(error => {
                    console.log("caught error ", error);
                });
        }
    }, [dataChanged])


    const getLocations = (id) => {
        getAccessGroup(id).then (result => {
            setSelectedAccessGroup(result.data);
            setMode("locations");
        }
        )
    }


    const getUsers = (id) => {
        getAccessGroup(id).then (result => {
                setSelectedAccessGroup(result.data);
                setMode("users");
            }
        )
    }

    return <>
        <h1>Manage AccessGroups</h1>

        <table className="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {accessGroups.map(accessGroup => <AccessGroupRow key={accessGroup.id}
                                                             accessGroup={accessGroup}
                                                             dataChanged = { () => setDataChanged(true)}
                                                             viewLocations={ () => getLocations(accessGroup.id)}
                                                             viewUsers={ () => getUsers(accessGroup.id)}
                />)}
            <AccessGroupRow key={-1} accessGroup={{id:-1, name: ""}} dataChanged = { () => setDataChanged(true)} viewLocations={ () => getLocations(-1)} />
            </tbody>
        </table>
        {mode === "locations" && <AccessGroupLocations accessGroup={selectedAccessGroup} dataChanged={ () => getLocations(selectedAccessGroup.id)} ></AccessGroupLocations>}
        {mode === "users" && <AccessGroupUsers accessGroup={selectedAccessGroup} dataChanged={ () => getUsers(selectedAccessGroup.id)} ></AccessGroupUsers>}

    </>
}

export default AccessGroups;