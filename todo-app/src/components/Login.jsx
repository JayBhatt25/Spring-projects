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

    function handleSubmit(){
        if(authContext.login(username,password)){
            authContext.setUsername(username)
            navigate(`/welcome/${username}`)
        } else {
            authContext.setUsername("")
            setAuthMessage("Authentication failed. Please check your credentials")
        }
    }
    return (
        <div className="login">
            <div className='notification'>{authMessage}</div>
            {/* <div className='errorMessage'>Authentication failed. Please check your credentials</div> */}
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
            </form>
            
        </div>
    )
}
