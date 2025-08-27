import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Buildings from "./components/building/Buildings";
import Home from "./components/Home";
import Menu from "./components/Menu";
import Users from "./components/user/Users";
import AccessGroups from "./components/accessgroups/AccessGroups";
import ManageUser from "./components/user/ManageUser";

function App() {

    return (
        <div className="container">
                <BrowserRouter>
                    <Menu/>
                    <Routes>
                        <Route path="/buildings" element={<Buildings/>} />
                        <Route path="/users" element={<Users/>} />
                        <Route path="/user/:id" element={<ManageUser/>} />
                        <Route path="/accessgroups" element={<AccessGroups/>} />

                        <Route path="" element={<Home/>}/>
                        <Route path="*" element={<p>404</p>}/>
                    </Routes>
                </BrowserRouter>
        </div>

    );
}

export default App;
