<template>
  <TheNavBar></TheNavBar>
  <div class="container register">
    <div class="row">
      <div class="col-md-3 register-left">
        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
        <h3>Bienvenido</h3>
        <p>Llena los siguientes campos para crear un contacto en el sistema !</p>
        <form action="https://imaginecx.co/">
          <input type="submit" name="" value="Más sobre nosotros" /><br />
        </form>
      </div>
      <div class="col-md-9 register-right">
        <div class="tab-content" id="myTabContent">
          <div
            class="tab-pane fade show active"
            id="home"
            role="tabpanel"
            aria-labelledby="home-tab"
          >
            <h3 class="register-heading">Crear Contacto</h3>
            <div class="row register-form">
              <div class="col-md-6">
                <div class="form-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Nombre *"
                    id="nombre"
                    v-model="nombre"
                    required="true"
                    maxlength="15"
                    pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}"
                  />
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Apellido *"
                    id="apellido"
                    v-model="apellido"
                    required="true"
                    maxlength="15"
                    pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}"
                  />
                </div>
                <div class="form-group">
                  <input
                    type="email"
                    class="form-control"
                    placeholder="Correo *"
                    id="correo"
                    v-model="correo"
                    required="true"
                    maxlength="40"
                    pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}"
                  />
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    maxlength="10"
                    name="txtEmpPhone"
                    class="form-control"
                    placeholder="Celular *"
                    id="celular"
                    v-model="celular"
                    pattern="[0-9]+"
                  />
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <select class="form-control"  id="pais" v-model="pais">
                    <option class="hidden" selected disabled>País</option>
                    <option>Colombia</option>
                    <option>USA</option>
                  </select>
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Ciudad *"
                    v-model="ciudad"
                    id="ciudad"
                    required="true"
                    maxlength="15"
                    pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}"
                  />
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Dirección "
                    id="direccion"
                    v-model="direccion"
                  />
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    maxlength="6"
                    class="form-control"
                    placeholder="Código Postal "
                    v-model="codigo"
                    id="codigo"
                    pattern="[0-9]+"
                  />
                </div>
                <input type="button" class="btnRegister" @click="formaEnviar" value="Crear" />
              </div>
            </div>
          </div>
          <div
            class="tab-pane fade show"
            id="profile"
            role="tabpanel"
            aria-labelledby="profile-tab"
          >
            <h3 class="register-heading">Apply as a Hirer</h3>
            <div class="row register-form">
              <div class="col-md-6">
                <div class="form-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="First Name *"
                    value=""
                  />
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Last Name *"
                    value=""
                  />
                </div>
                <div class="form-group">
                  <input
                    type="email"
                    class="form-control"
                    placeholder="Email *"
                    value=""
                  />
                </div>
                <div class="form-group">
                  <input
                    type="text"
                    maxlength="10"
                    minlength="10"
                    class="form-control"
                    placeholder="Phone *"
                    value=""
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <Footer></Footer>
</template>

<script>
import TheNavBar from "@/components/TheNavBar";
import Footer from "@/components/Footer.vue";
import CrearContacto from "@/servicios/CrearUsuario";
import swal from "sweetalert2";

export default {
  name: "CreateForm",
  data() {
    return {
      nombre: "",
      apellido: "",
      correo: "",
      celular: "",
      pais: "",
      ciudad: "",
      direccion: "",
      codigo: "",
    };
  },
  components: {
    TheNavBar,
    Footer,
  },

 methods: {
   formaEnviar(e) {
      e.preventDefault();
      let objectoActual = this;
      let info = {
        nombre: this.nombre,
        apellido: this.apellido,
        correo: this.correo,
        celular: this.celular,
        pais: this.pais,
        ciudad: this.ciudad,
        direccion: this.direccion,
        codigo: this.codigo,
      };
      //console.log(info);
      this.crear(objectoActual, info);
    },
    crear(objetoActual, info) {
      CrearContacto.registrarContacto(info).then((respuesta) => {
        objetoActual.probar = respuesta.data;
        //console.log(respuesta.data);
        if (respuesta.status === 201) {
       swal.fire( "Contacto creado!", "Tu contacto " + this.nombre + " " + this.apellido +  " fue creado exitosamente", "success");
              this.nombre = '';
              this.apellido = '';
              this.correo = '';
              this.celular = '';
              this.pais = '';
              this.ciudad = '';
              this.direccion = '';
              this.codigo = '';
        }
      });
    },
  },

    mounted() {
    //console.log("Componente Crear Contacto OK.");
  },

};

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.register {
  background: -webkit-linear-gradient(left, #3931af, #00c6ff);
  margin-top: 3%;
  padding: 3%;
}

.register-left {
  text-align: center;
  color: #fff;
  margin-top: 4%;
}

.register-left input {
  border: none;
  border-radius: 1.5rem;
  padding: 2%;
  width: 60%;
  background: #f8f9fa;
  font-weight: bold;
  color: #383d41;
  margin-top: 30%;
  margin-bottom: 3%;
  cursor: pointer;
}

.register-right {
  background: #f8f9fa;
  border-top-left-radius: 10% 50%;
  border-bottom-left-radius: 10% 50%;
}

.register-left img {
  margin-top: 15%;
  margin-bottom: 5%;
  width: 25%;
  -webkit-animation: mover 2s infinite alternate;
  animation: mover 1s infinite alternate;
}

@-webkit-keyframes mover {
  0% {
    transform: translateY(0);
  }

  100% {
    transform: translateY(-20px);
  }
}

@keyframes mover {
  0% {
    transform: translateY(0);
  }

  100% {
    transform: translateY(-20px);
  }
}

.register-left p {
  font-weight: lighter;
  padding: 12%;
  margin-top: -9%;
}

.register .register-form {
  padding: 10%;
  margin-top: 10%;
}

.btnRegister {
  float: right;
  margin-top: 10%;
  border: none;
  border-radius: 1.5rem;
  padding: 2%;
  background: #0062cc;
  color: #fff;
  font-weight: 600;
  width: 50%;
  cursor: pointer;
}

.register .nav-tabs {
  margin-top: 3%;
  border: none;
  background: #0062cc;
  border-radius: 1.5rem;
  width: 28%;
  float: right;
}

.register .nav-tabs .nav-link {
  padding: 2%;
  height: 34px;
  font-weight: 600;
  color: #fff;
  border-top-right-radius: 1.5rem;
  border-bottom-right-radius: 1.5rem;
}

.register .nav-tabs .nav-link:hover {
  border: none;
}

.register .nav-tabs .nav-link.active {
  width: 100px;
  color: #0062cc;
  border: 2px solid #0062cc;
  border-top-left-radius: 1.5rem;
  border-bottom-left-radius: 1.5rem;
}

.register-heading {
  text-align: center;
  margin-top: 8%;
  margin-bottom: -15%;
  color: #495057;
}
</style>
