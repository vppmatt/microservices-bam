import {useEffect, useState} from "react";
import {getAllBuildings, getLocationsForBuilding, updateBuildingName} from "../../data/buildingRestFunctions";
import Locations from "./Locations";
import BuildingRow from "./BuildingRow";

const Buildings = () => {

    const [buildings, setBuildings] = useState([]);
    const [locations, setLocations] = useState([]);
    const [dataChanged, setDataChanged] = useState(true);

    useEffect(
        () => {
            if (dataChanged) {
                setDataChanged(false);
                getAllBuildings()
                    .then(result => {
                        console.log(result.data);
                        setBuildings(result.data);
                    })
            }

        }
        , [dataChanged]);

    const showLocations = (id) => {
        getLocationsForBuilding(id).then (
            result => {
                setLocations(result.data)
            }
        )
    }

    const setBuildingName = (id, name) => {
        updateBuildingName(id,name).then (
            result => {
                if (result.status === 200) {
                    setDataChanged(true);
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
        <h1>Manage Buildings</h1>

        <table className="table">
            <thead>
            <tr>
                <th>Id</th><th>Name</th><th>locations</th>
            </tr>
            </thead>
            <tbody>
            {buildings.map(building => <BuildingRow key={building.id} building={building} showLocations={ () => showLocations(building.id) } updateBuildingName={setBuildingName} /> )}
            </tbody>
        </table>
        {locations.length > 0 && <Locations locations={locations} dataChanged={showLocations} />}
    </>
}

export default Buildings;