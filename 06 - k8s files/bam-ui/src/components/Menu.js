import {useNavigate} from "react-router-dom";


const Menu = () => {

    const navigate = useNavigate();





    return <>
        <h1>Building access management system</h1>
        <button className="btn btn-sm btn-success me-2" onClick={ () => navigate("/")}>home</button>
        <button className="btn btn-sm btn-success me-2" onClick={ () => navigate("/buildings")}>buildings</button>
        <button className="btn btn-sm btn-success me-2" onClick={ () => navigate("/accessgroups")}>access groups</button>
        <button className="btn btn-sm btn-success me-2" onClick={ () => navigate("/users")}>users</button>
    </>
}

export default Menu;