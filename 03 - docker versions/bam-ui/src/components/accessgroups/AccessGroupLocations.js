import AccessGroupLocationRow from "./AccessGroupLocationRow";
import AddLocationToAccessGroup from "./AddLocationToAccessGroup";


const AccessGroupLocations = (props) => {
    console.log(props.accessGroup);
    return <>
        <h2>Manage Locations for access group: {props.accessGroup.name}</h2>
        <table className="table">
            <thead>
            <tr>
                <th>Building</th>
                <th>Location</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {props.accessGroup.locations.map(location => <AccessGroupLocationRow key={location.id}
                                                                                 accessGroupId={props.accessGroup.id}
                                                             location={location} dataChanged={props.dataChanged}
            />)}
            </tbody>
        </table>

        <AddLocationToAccessGroup accessGroup={props.accessGroup} dataChanged={props.dataChanged} />
    </>
}

export default AccessGroupLocations;