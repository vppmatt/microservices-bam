import {useState} from "react";

const BuildingRow = ({building, showLocations, updateBuildingName}) => {

    const [mode, setMode] = useState("view");
    const [newName, setNewName] = useState(building.name);

    const editOnClick = () => {
        setMode("edit");
    }

    const saveOnClick = () => {
        updateBuildingName(building.id, newName);
               setMode("view");
    }

    const onNameChange = (event) => {
        setNewName(event.target.value);
    }

    const viewMode = <td>{building.name} <button className="btn btn-sm btn-warning" onClick={editOnClick}>edit</button></td>
    const editMode = <td><input value={newName} onChange={onNameChange} /> <button className="btn btn-sm btn-success" onClick={saveOnClick}>save</button></td>

    return <tr key={building.id}><td>{building.id}</td>
        {mode === "view" && viewMode}
        {mode === "edit" && editMode}
        <td><button onClick={ showLocations} className="btn btn-sm btn-primary">view</button> </td></tr>
}

export default BuildingRow;