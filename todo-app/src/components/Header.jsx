import { Link } from "react-router-dom";
import { useAuth } from "./security/AuthContext"
import { useEffect } from "react";

export default function HeaderComponent(){

    const authContext = useAuth();
    const isLoggedin = authContext.isAuthenticated;

    const handleLogout = () => {
        authContext.logout()
        isLoggedin = authContext.isAuthenticated
    }
    return (
        <header className="border-bottom border-light border-5 mb-5 p-2">
        <div className="container">
            <div className="row">
                <nav className="navbar navbar-expand-lg">
                    <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="#">TODO APP</a>
                    <div className="collapse navbar-collapse">
                        <ul className="navbar-nav">
                            {isLoggedin && <li className="nav-item fs-5"><Link className="nav-link" to="/welcome/Jay">Home</Link></li> }
                            {isLoggedin && <li className="nav-item fs-5"><Link className="nav-link" to="/todos">Todos</Link></li>}
                        </ul>
                    </div>
                    <ul className="navbar-nav">
                        {isLoggedin ? (<li className="nav-item fs-5"><Link className="nav-link" to="/logout" onClick={handleLogout}>Logout</Link></li>)
                        :(<li className="nav-item fs-5"><Link className="nav-link" to="/login">Login</Link></li>)}
                    </ul>
                </nav>
            </div>
        </div>
    </header>
    )
}