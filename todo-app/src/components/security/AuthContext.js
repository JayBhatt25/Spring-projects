import { createContext, useContext, useState} from "react";
import  {apiClient}  from "../api/TodoApiService";
import { executeBasicAuth, executeJwtAuth } from "../api/AuthenticationApiService";


export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)
export default function AuthProvider({ children }) {

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUsername] = useState("")
    const [token, setToken] = useState(null)
    // function login(username, password){
    //     if(username === 'Jay' && password === 'Jay123'){
    //         setIsAuthenticated(true)
    //         return true
    //     } else {
    //         setIsAuthenticated(false)
    //         return false
    //     }
    // }

    async function login(username, password){
        const baToken = 'Basic ' + window.btoa(username + ":" + password)

        try {
             //const response = await executeBasicAuth(baToken)
            const response = await executeJwtAuth(username,password)
            if(response.status == 200){
                
                const jwtToken = 'Bearer '+response.data.token
                setIsAuthenticated(true)
                setUsername(username)
                setToken(jwtToken)

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('Setting auth token in axios')
                        config.headers.Authorization=jwtToken
                        return config
                    }
                )
                return true
            } else {
                
                logout()
                return false
            }
        } catch (err) {
            console.log(err)
            logout()
            return false
        }
        
    }

    function logout(){
        setIsAuthenticated(false)
        setToken(null)
        setUsername("")
    }
    return (
        <AuthContext.Provider value = {{isAuthenticated, login, logout, username, setUsername,setIsAuthenticated, token}} >
            {children}
        </AuthContext.Provider>
    )
}