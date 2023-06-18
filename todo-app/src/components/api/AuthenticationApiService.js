import { apiClient } from "./TodoApiService"


export const executeBasicAuth = (token) => apiClient.get(`/basicAuth`,{headers: {'Authorization':token}})

export const executeJwtAuth = (username,password) => apiClient.post('/authenticate',{username:username,password:password})
