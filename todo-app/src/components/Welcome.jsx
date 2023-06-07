import { Link, useParams } from "react-router-dom";

export default function WelcomeComponent(){

    const {username} = useParams();
    return (
        <div className="welcome_component">
            <h1>Welcome {username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Click here</Link>
            </div>
        </div>
    )
}