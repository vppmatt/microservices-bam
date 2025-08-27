import {useEffect, useState} from "react";
import UserRow from "./UserRow";
import {getHighestUserId, getNextUserFromHR, searchUsers} from "../../data/userRestFunctions";
import {useNavigate} from "react-router-dom";


const Users = () => {

    const [users, setUsers] = useState([]);
    const [searchTerm, setSearchTerm] = useState("");
    const [highestId, setHighestId] = useState(0);


    const navigate = useNavigate();
    const updateSearchTerm = (event) => {
        setSearchTerm(event.target.value);
    }

    useEffect( () => {
        getHighestUserId().then(
            result => {
                if (result.status === 200) {
                    setHighestId(result.data.id);
                }
                else {
                    console.log("load error " , result);
                }
            }
        )
    } , [])

    const importNewUser = () => {
        getNextUserFromHR().then(
            result => {
                console.log("got back", result)
                if (result.status === 200) {
                    console.log(result.data)
                    navigate("/user/" + result.data.id)
                }
                else {
                    console.log("load error " , result);
                }
            }
        ).catch(error => {
            console.log("caught error " , error);
        })
    }

    const doSearch = () => {
        searchUsers(searchTerm).then (
            result => {
                if (result.status === 200) {
                    setUsers(result.data);
                }
                else {
                    console.log("load error " , result);
                }
            }
        )
            .catch( error => {
                console.log("caught error " , error);
            })
    }

    return <>
        <h1>Manage Users</h1>
        {highestId === -99 && <h2>Sorry - the user management system is currently unavailable</h2>}
        {highestId !== -99 && <>
        <div className="my-2">Latest user ID is {highestId} <button onClick={importNewUser} className="btn btn-sm btn-warning">import new user from HR</button></div>
        <div>
            <label htmlFor="search" className="me-2">Search: </label>
            <input id="search" className="me-2" value={searchTerm} onChange={updateSearchTerm}/>
            <button className="btn btn-sm btn-primary" onClick={doSearch}>Search</button>
        </div>
        <table className="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>email</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {users.map(user => <UserRow key={user.id} user={user}/>)}
            </tbody>
        </table>
        </>}
    </>
}

export default Users;