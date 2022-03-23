import axios from "axios";

const API_URL = "http://localhost:8080/consultar";

class ConsultarUsuarioServicio {
    ConsultarUsuario() {
        return axios.get(API_URL);

    }
    ConsultarUsuarioporId(id) {
        return axios.get(API_URL + "/"+ id);

    }
}

export default new ConsultarUsuarioServicio();
