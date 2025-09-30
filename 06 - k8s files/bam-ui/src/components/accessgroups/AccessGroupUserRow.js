import {removeUserFromAccessGroup} from "../../data/accessRestFunctions";
import {useNavigate} from 'react-router-dom';

const AccessGroupUserRow = (props) => {

    const navigate=useNavigate();

    const viewUser = () => {
        navigate("/user/"+props.user.id);
    }

    const removeUser = () => {
        removeUserFromAccessGroup(props.user.id, props.accessGroupId)
            .then ( result => {
                props.dataChanged();
            })


    }

    return <tr key={props.user.id}><td>{props.user.name}</td>
        <td>{props.user.email}</td>
        <td><button onClick={viewUser} className="btn btn-sm btn-primary">view</button><button onClick={removeUser} className="btn btn-sm btn-danger">remove</button></td>
    </tr>
}

export default AccessGroupUserRow;