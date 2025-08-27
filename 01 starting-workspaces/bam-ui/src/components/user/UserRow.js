import {useNavigate} from "react-router-dom";

const UserRow = (props) => {
    const user = props.user;

    const navigate = useNavigate();

    const viewUser = () => {
        navigate("/user/" + props.user.id)
    }

    return <tr key={user.id}><td>{user.id}</td>
        <td>{user.name}</td><td>{user.email}</td>
        <td><button className="btn btn-sm btn-primary" onClick = {viewUser}>manage</button></td>
    </tr>
}

export default UserRow;