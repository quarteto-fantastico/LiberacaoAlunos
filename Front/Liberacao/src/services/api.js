import axios from 'axios';
import { getToken } from './auth';
import { urlServidor } from '../Variaveis.json';

const api = axios.create({
  baseURL:`${urlServidor}`
});

api.interceptors.request.use(async config =>{
  const token = getToken();
  if (token){
    config.headers.Authorization = `${token}`;
  }
  return config;
})

export default api;