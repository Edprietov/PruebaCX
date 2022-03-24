import axios from "axios";

const API_URL = "http://localhost:8080";
const CONTROLADOR = "/consultar";

class ConsultarUsuarioServicio {
    ConsultarUsuario() {
        return axios.get(API_URL + CONTROLADOR);

    }
    ConsultarUsuarioporId(id) {
        return axios.get(API_URL + CONTROLADOR + "/"+ id);

    }
}

export default new ConsultarUsuarioServicio();
