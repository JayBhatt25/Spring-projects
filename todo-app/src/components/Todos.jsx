import { useEffect, useState } from "react"
import { toggleDoneApi, deleteTodoById, retrieveAllTodosForUsername } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"
import { redirect, useNavigate } from "react-router-dom";

export default function TodosComponent(){
    
    const authContext = useAuth();
    const [todosList, setTodosList] = useState([])
    const [message, setMessage] = useState("")
    const navigate = useNavigate()
    function refreshTodos(){
      retrieveAllTodosForUsername(authContext.username,authContext.token)
     .then(response => {
        setTodosList(response.data)
     })
     .catch(error => {
        redirect('*',{error: error})
    })
    }
     
    useEffect(
        () => refreshTodos(),[]
    )

    const handleDelete = (id) => {
        deleteTodoById(authContext.username,id,authContext.token)
        .then(response => {
            setMessage(`Todo item deleted successfully`)
            refreshTodos()
        })
        .catch(error => {
            redirect('*',{error: error})
        })
    }

    const handleUpdate = (id) => {
        navigate(`/todos/${id}`)
    }

    const addNewTodo = () => {
        navigate('/todos/-1')
    }

    const handleDone = (id) => {
        toggleDoneApi(authContext.username,id,authContext.token)
        .then(response => {
            if(response.data){
                refreshTodos()
            }
        })
        .catch(error => {})
    }
    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            {message.length > 0 && <div className="alert alert-warning">{message}</div>}
            <div className="table-container">
                {todosList.length > 0? (
                     <table className='table'>
                        <thead>
                            <th scope='col'>Description</th>
                            <th scope='col'>TargetDate</th>
                            <th scope='col'>isDone?</th>
                            <th scope='col'>Actions</th>
                        </thead>
                        <tbody>
                            {todosList.map((todo, i) => {
                                return (
                                <tr key={todo.id}>
                                    <td>{todo.description}</td>
                                    <td>{todo.targetDate}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>
                                        <div className="action_btn_grp">
                                            <button type="button" className="btn btn-warning update-btn" onClick={() => handleUpdate(todo.id)}>UPDATE</button>
                                            <button type="button" className="btn btn-danger" onClick={() => handleDelete(todo.id)}>DELETE</button>
                                            {!todo.done ? (<button type="button" className="btn btn-primary" onClick={() => handleDone(todo.id)}>MARK AS DONE</button>)
                                            : (<button type="button" className="btn btn-primary" onClick={() => handleDone(todo.id)}>UNDO</button>)}
                                        </div>
                                    </td>
                                </tr>
                                )
            
                            })}
                        </tbody>
                    </table>
                ):(
                    <h5>Nothing to show. Please add a todo item to get started</h5>
                )}
               <button type="button" className="btn btn-success m-5" onClick={addNewTodo}>ADD TODO</button>
            </div>
        </div>
    )
}