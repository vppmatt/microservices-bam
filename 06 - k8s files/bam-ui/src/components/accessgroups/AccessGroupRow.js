import {useState} from "react";
import {saveNewAccessGroup, updateAccessGroupName} from "../../data/accessRestFunctions";

const AccessGroupRow = ({accessGroup, dataChanged, viewLocations, viewUsers}) => {

    const [mode, setMode] = useState("view");
    const [newName, setNewName] = useState(accessGroup.name);

    const editOnClick = () => {
        setMode("edit");
    }

    const saveOnClick = () => {
        if (accessGroup.id === -1) {
            saveNewAccessGroup(newName)
                .then(result => {
                    if (result.status === 200) {
                        dataChanged();
                        setMode("view");
                    } else {
                        console.log("error saving ", result);
                    }
                })
            .catch(
                error => console.log("error ", error)
            );
        }
        else {
            updateAccessGroupName(accessGroup.id, newName)
                .then(result => {
                    if (result.status === 200) {
                        dataChanged();
                        setMode("view");
                    } else {
                        console.log("error saving ", result);
                    }
                })
                .catch(
                    error => console.log("error ", error)
        );
        }

    }

    const onNameChange = (event) => {
        setNewName(event.target.value);
    }

    const viewMode = <><td>{accessGroup.name}&nbsp;
        {accessGroup.id !== -1 && <button className="btn btn-sm btn-warning" onClick={editOnClick}>edit</button>}
        {accessGroup.id === -1 && <button className="btn btn-sm btn-success" onClick={editOnClick}>add</button>}
    </td><td>{accessGroup.id !== -1 && <>
        <button className="btn btn-sm btn-primary me-2" onClick={viewLocations}>locations</button>
        <button className="btn btn-sm btn-primary me-2" onClick={viewUsers}>users</button> </>}</td></>

    const editMode = <><td><input value={newName} onChange={onNameChange} />
        <button className="btn btn-sm btn-success" onClick={saveOnClick}>save</button>
    </td><td></td></>

    return <tr key={accessGroup.id}><td>{accessGroup.id !== -1  && accessGroup.id}</td>
        {mode === "view" && viewMode}
        {mode === "edit" && editMode}
    </tr>
}

export default AccessGroupRow;