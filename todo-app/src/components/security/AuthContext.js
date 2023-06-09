import { createContext, useContext, useMemo, useState } from "react";


export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)
export default function AuthProvider({ children }) {

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUsername] = useState("");
    function login(username, password){
        if(username === 'Jay' && password === 'Jay123'){
            setIsAuthenticated(true)
            return true
        } else {
            setIsAuthenticated(false)
            return false
        }
    }

    function logout(){
        setIsAuthenticated(false)
    }
    return (
        <AuthContext.Provider value = {{isAuthenticated, login, logout, username, setUsername}} >
            {children}
        </AuthContext.Provider>
    )
}