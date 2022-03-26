<template>
<TheNavBar></TheNavBar>
<div class="container">
<div class="row">
<div class="panel panel-primary filterable">
<div class="panel-heading">
                <h3 class="panel-title">Contactos</h3>
                <div class="float-right">
                    <button class="btn btn-default btn-xs btn-filter" @click="cambiarEstado"><img src="../assets/filter.svg" /> Filtrar</button>
                </div>
            </div>
           <Filter disabled></Filter> 
  <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col"># Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Correo</th>
      <th scope="col">Celular</th>
      <th scope="col">Ciudad</th>
      <th scope="col">País</th>
    </tr>
  </thead>
  <tbody>
 <tr v-for="valor in servidorDatos" :key="valor.items">
          <td>{{ valor[0] }}</td>
          <td>{{ valor[1] }}</td>
          <td>{{ valor[2] }}</td>
          <td>{{ valor[5] }}</td>
          <td>{{ valor[6] }}</td>
          <td>{{ valor[3] }}</td>
          <td>{{ valor[4] }}</td>
        </tr>
  </tbody>
</table>
</div>
  </div>
  </div>

<Footer></Footer>

</template>


<script>
import Consultar from "@/servicios/ConsultarContactos";
import TheNavBar from "@/components/TheNavBar";
import Footer from '@/components/Footer.vue'
import Filter from '@/components/FilterForm.vue'

export default {
    data() {
    return {
      servidorDatos: "",
    };
  },
    components: {
    TheNavBar,
    Footer,
    Filter,
  },
  methods: {
    enviarForma() {
      this.ConsultarUsuarios();
    },
    ConsultarUsuarios() {
      Consultar.ConsultarUsuario()
        .then((respuesta) => {
          if (respuesta.status === 200) {
            console.log("Respuesta" + JSON.stringify(respuesta.data.items[0].rows));
            this.servidorDatos = respuesta.data.items[0].rows;
          } else {
            console.log("Error");
          }
        })
        .catch((error) => {
          if (error.response.status === 400) {
            console.log("Error:" + error.response.message);
          }
        });
    },
  },
  beforeMount(){
    this.ConsultarUsuarios()
 },
  name: "ConsultarUsuarios",
  mounted() {
    console.log("Componente Consultar Todos los usuarios");
  },
};
</script>

<style scoped>
.container{
background: #ffffff;
 opacity: 0.6;
height: 26vw;
margin-top: 3%;
 border-radius: 5px;
  background-position: left top;
  background-repeat: repeat;
  padding: 20px;
  border: solid ;
}



</style>