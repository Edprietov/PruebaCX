import axios from "axios";

const API_URL = "http://localhost:8080";
const CONTROLADOR = "/crear";

class CrearUsuarioServicio{
    registrarContacto(info){
        return axios.post(API_URL + CONTROLADOR, {
            nombreContacto: info.nombre,
            apellidoContacto: info.apellido,
            correoContacto: info.correo,
            celularContacto: info.celular,
            paisContacto: info.pais,
            ciudadContacto: info.ciudad,
            direccionContacto: info.direccion,
            codigoContacto: info.codigo,
        });
    }
}

export default new CrearUsuarioServicio();