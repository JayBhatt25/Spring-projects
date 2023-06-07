export default function TodosComponent(){
    const todosList = [
        {
            id: 1,
            description:"Learn AWS",
            target_date:"06-07-2023",
            username: "Jay",
            done: "false"
        },
        {
            id: 2,
            description:"Learn Azure",
            target_date:"06-07-2023",
            username: "Jay",
            done: "false"
        },
        {
            id: 3,
            description:"Learn GCP",
            target_date:"06-07-2023",
            username: "Jay",
            done: "false"
        }
    ]
    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            <div>
                <table className='table'>
                    <thead>
                        <th scope='col'>Id</th>
                        <th scope='col'>Description</th>
                        <th scope='col'>TargetDate</th>
                        <th scope='col'>Username</th>
                        <th scope='col'>isDone?</th>
                    </thead>
                    <tbody>
                        {todosList.map((todo, i) => {
                           return (
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.description}</td>
                                <td>{todo.target_date}</td>
                                <td>{todo.username}</td>
                                <td>{todo.done}</td>
                            </tr>
                           )
        
                        })}
                    </tbody>
                </table>
            </div>
        </div>
    )
}