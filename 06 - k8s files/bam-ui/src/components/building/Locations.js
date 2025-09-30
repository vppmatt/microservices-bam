import BuildingRow from "./BuildingRow";
import {saveNewLocation, updateLocationDescription} from "../../data/buildingRestFunctions";
import LocationRow from "./LocationRow";

const Locations = (props) => {

    const locations= props.locations;

    const setLocationDescription = (id, description) => {
        updateLocationDescription(id,description).then (
            result => {
                if (result.status === 200) {
                    console.log(result.data);
                    props.dataChanged(result.data.building.id);
                }
                else {
                    console.log("save error " , result);
                }
            }
        )
            .catch(error => {
                console.log("caught error " , error);
            })

    }

    const setupNewLocation = (id, description) => {

        saveNewLocation({id : null, description: description, building: ""+props.locations[0].building.id})
            .then (
                result => {
                    if (result.status === 200) {
                        console.log(result.data);
                        props.dataChanged(result.data.building.id);
                    }
                    else {
                        console.log("save error " , result);
                    }
                }
            )
            .catch(error => {
                console.log("caught error " , error);
            })
    }

    return <>
    <h2>Locations for {props.locations[0].building.name}</h2>
        <table className="table">
            <thead>
            <tr>
                <th>Id</th><th>Description</th>
            </tr>
            </thead>
            <tbody>
            {locations.map(location =>  <LocationRow key={location.id} location={location} updateLocationDescription={setLocationDescription} />)}
            <LocationRow key={-1} location={{id: -1, description:""}} updateLocationDescription={setupNewLocation} />
            </tbody>
        </table>
    </>
}

export default Locations