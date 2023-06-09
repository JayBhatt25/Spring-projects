
import {Navigate, Route, BrowserRouter as Router, Routes} from 'react-router-dom'
import './todoapp.css'
import HeaderComponent from './Header';
import ListTodosComponent from './Todos';
import LoginComponent from './Login';
import WelcomeComponent from './Welcome';
import ErrorComponent from './Error';
import AuthProvider, { useAuth } from './security/AuthContext';
import TodoComponent from './TodoComponent';

function AuthenticatedRoute({children}){
    const authContext = useAuth();
    return (
        authContext.isAuthenticated? children : <Navigate to='/login' />
    )
}

export default function TodoApp(){
    return (
        
        <div className="todoapp">
           <AuthProvider>
                <Router>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/login" element={<LoginComponent />} />
                        <Route path="/welcome/:username" element={
                        <AuthenticatedRoute>
                            <WelcomeComponent />
                        </AuthenticatedRoute>
                        
                        } />
                        <Route path="/todos" element={
                            <AuthenticatedRoute>
                                <ListTodosComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path="/todos/:id" element={
                            <AuthenticatedRoute>
                                <TodoComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path="/" element={<LoginComponent />} />
                        <Route path="*" element={<ErrorComponent />} />
                    </Routes>
                </Router>
            </AuthProvider>
        </div>

    )
}








