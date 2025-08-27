import axios from "axios";


const serverUrl = "http://localhost:8082"

export const searchUsers = (searchTerm) => {
    return axios({url : `${serverUrl}/api/user?format=short&search=` + searchTerm, method: "GET"})
}

export const getHighestUserId  = () => {
    return axios({url : `${serverUrl}/api/user/highestId`, method: "GET"})
}

export const getNextUserFromHR = () => {
    return axios({url : `${serverUrl}/api/user`, method: "POST", data : {"ignore":"ignore"}})
}

