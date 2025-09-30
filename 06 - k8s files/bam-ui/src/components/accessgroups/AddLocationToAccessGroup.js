import {useEffect, useState} from "react";
import {getAllLocations} from "../../data/buildingRestFunctions";
import {addLocationToAccessGroup} from "../../data/accessRestFunctions";

const AddLocationToAccessGroup = (props) => {

    const [locations, setLocations]= useState([]);
    const [selectedLocation, setSelectedLocation]= useState(-1);

    useEffect( () => {
        getAllLocations().then ( (result) => {
            setLocations(result.data);
        })

    } , [])

    const setLocation = (event) => {
        setSelectedLocation(event.target.value);
    }

    const save = () => {
        console.log(`adding location ${selectedLocation} to access group ${props.accessGroup.id}` );
        addLocationToAccessGroup(selectedLocation,props.accessGroup.id).then (
            result => props.dataChanged()
        )
    }
return <>
    <label htmlFor="groupselector">Add location to access group: </label>
    <select id="groupselector" onChange={setLocation} value={selectedLocation}>
        <option value ="-1" disabled={true} >--choose--</option>
        {locations.map(location => <option value={location.id} key={location.id}>{location.building} {location.description}</option>)}
    </select>
    <button disabled={selectedLocation === -1} className="btn btn-sm btn-success" onClick={save}>add</button>
</>
}

export default AddLocationToAccessGroup;