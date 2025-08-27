import {removeLocationFromAccessGroup} from "../../data/accessRestFunctions";

const AccessGroupLocationRow = (props) => {

    const removeLocation = () => {
        removeLocationFromAccessGroup(props.location.id, props.accessGroupId)
            .then ( result => {
                props.dataChanged();
            })


    }

    return <tr key={props.location.id}><td>{props.location.building}</td>
        <td>{props.location.description}</td>
        <td><button onClick={removeLocation} className="btn btn-sm btn-danger">remove</button></td>
       </tr>
}

export default AccessGroupLocationRow;