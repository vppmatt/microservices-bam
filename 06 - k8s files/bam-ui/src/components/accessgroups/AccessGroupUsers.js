import AccessGroupUserRow from "./AccessGroupUserRow";

const AccessGroupUsers = (props) => {

    return <>
        <h2>Manage Users for access group: {props.accessGroup.name}</h2>
        <table className="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {props.accessGroup.users.map(user => <AccessGroupUserRow key={user.id}
                                                                                 accessGroupId={props.accessGroup.id}
                                                                                 user={user} dataChanged={props.dataChanged}
            />)}
            </tbody>
        </table>

        {/*<AddLocationToAccessGroup accessGroup={props.accessGroup} dataChanged={props.dataChanged} />*/}
    </>
}

export default AccessGroupUsers;