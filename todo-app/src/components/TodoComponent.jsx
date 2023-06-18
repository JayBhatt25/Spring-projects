import { useNavigate, useParams } from "react-router-dom"
import { retrieveTodoApi, updateTodoApi, createTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import {ErrorMessage, Field, Form,Formik} from 'formik'
import moment from 'moment'
export default function TodoComponent(){
    const {id} = useParams();
    const authContext = useAuth();
    const [description, setDescription] = useState("")
    const [targetDate, setTargetDate] = useState("")
    const username = authContext.username;
    const navigate = useNavigate()
    function retrieveTodo() {
        
        retrieveTodoApi(authContext.username, id,authContext.token)
        .then(response => {
            setDescription(response.data.description)
            setTargetDate(response.data.targetDate)
        })
        .catch(error => {})
        
        
    }

    useEffect(
        () => retrieveTodo(),[id]
    )

    const onSubmit = (values) => {
        const todo = {
            id:id,
            username:authContext.username,
            description:values.description,
            targetDate:values.targetDate,
            done:false
        }
        if(id != -1){
            updateTodoApi(username,id,todo,authContext.token)
            .then(response => {
                navigate(`/todos`)
                
            })
            .catch(error => {})
        } else {
            createTodoApi(username,todo,authContext.token)
            .then(response => {
                navigate(`/todos`)
            })
            .catch(error => {})
        }
       

    }
    const validate = (values) => {
        let errors = {}
        if(values.description == null || values?.description?.length < 5){
            errors.description = "Enter atleast 5 characters"
        }

        if(values?.targetDate == null || values?.targetDate === '' || !moment(values.targetDate).isValid()){
            errors.targetDate = "Please choose a target date"
        }
        return errors
    }
    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <Formik 
            initialValues={{description,targetDate}} 
            enableReinitialize={true}
            onSubmit={onSubmit} 
            validate={validate} 
            validateOnChange={false} validateOnBlur={false}>
                {
                    (props) => (
                        <Form>
                            <ErrorMessage name="description" component="div" className="alert alert-warning" />
                            <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />
                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field className="form-control" type="text" name="description"/>
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field className="form-control" type="date" name="targetDate"  />
                            </fieldset>
                            <button type="submit" className="btn btn-success m-5">Save</button>
                        </Form>
                    )
                }
            </Formik>
        </div>
    )
}