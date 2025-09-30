import {useState} from "react";

const LocationRow = ({location, updateLocationDescription, buildingId}) => {

    const [mode, setMode] = useState("view");
    const [newDescription, setNewDescription] = useState(location.description);

    const editOnClick = () => {
        setMode("edit");
    }

    const saveOnClick = () => {
        console.log("setting " + location.id + " to " + newDescription)
        updateLocationDescription(location.id, newDescription);
        setMode("view");
    }

    const onDescriptionChange = (event) => {
        setNewDescription(event.target.value);
    }

    const viewMode = <td>{location.description}&nbsp;
        {location.id !== -1 && <button className="btn btn-sm btn-warning" onClick={editOnClick}>edit</button>}
        {location.id === -1 && <button className="btn btn-sm btn-success" onClick={editOnClick}>add</button>}

    </td>
    const editMode = <td><input value={newDescription} onChange={onDescriptionChange} />
        <button className="btn btn-sm btn-success" onClick={saveOnClick}>save</button>
    </td>

    return <tr key={location.id}><td>{location.id !== -1  && location.id}</td>
        {mode === "view" && viewMode}
        {mode === "edit" && editMode}
       </tr>
}

export default LocationRow;