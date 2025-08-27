import axios from "axios";


const serverUrl = "http://localhost:8081"

export const getAllBuildings = () => {

    return axios({url :  `${serverUrl}/api/building`, method: "GET"})
}

export const getLocationsForBuilding = (id) => {
    return axios({url :  `${serverUrl}/api/building/${id}/location`, method: "GET"})
}

export const updateBuildingName = (id, name) => {
    return axios({url : `${serverUrl}/api/building/${id}`, method: "PUT",  data: {name: name}})
}

export const updateLocationDescription = (id, description) => {
    return axios({url : `${serverUrl}/api/location/${id}`, method: "PUT",  data: {description: description}})
}

export const saveNewLocation = (data) => {
    return axios({url : `${serverUrl}/api/location/`, method: "POST", data: data})
    return axios({url : `${serverUrl}/api/location/`, method: "POST", data: data})
}

export const getAllLocations = () => {
    return axios({url : `${serverUrl}/api/location`, method: "GET"})
}

