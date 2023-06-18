import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent(){

    const[username, setUsername] = useState(null);
    const[password, setPassword] = useState("");
    const[authMessage, setAuthMessage] = useState("");
    const navigate = useNavigate();
    const authContext = useAuth();
    function handleUsernameChange(e){
        setUsername(e.target.value)
    }

    function handlePasswordChange(e){
        setPassword(e.target.value)
    }

    async function handleSubmit(){
        if( await authContext.login(username,password)){
            navigate(`/welcome/${username}`)
        } else {
            authContext.setUsername("")
            setAuthMessage("Only admin can log in at the moment. Please log in as guest to try out this application")
        }
    }

    function handleGuestLogin(){
            authContext.setUsername("Guest")
            authContext.setIsAuthenticated(true)
            navigate(`/welcome/Guest`)
        }
    return (
        <div className="login">
            {authMessage?(<div className='alert alert-warning'>{authMessage}</div>):(<div></div>)}
            <form className="loginForm">
                <h2>Login</h2>
                <hr/>
                <div className="login_username mb-3">
                    <label className="form-label" for="username">Name</label>
                    <input type="text" name="username" id="username" className="form-control" value={username} onChange={handleUsernameChange} />
                </div>
                <div className="login_password mb-3">
                    <label className="form-label" for="password">Password</label>
                    <input type="password" name="password" id="password" className="form-control" value={password} onChange={handlePasswordChange} />
                </div>
                <button type="button" className="btn-login btn btn-primary" name="login" onClick={handleSubmit}>login</button>
                OR
                <button type="button" className="btn btn-secondary" onClick={handleGuestLogin}>login as guest</button>
            </form>
            
        </div>
    )
}
