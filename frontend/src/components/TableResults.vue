<template>
<TheNavBar></TheNavBar>
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
  <button class="btn btn-success" @click="enviarForma">Consultar</button>
<Footer></Footer>
</template>


<script>
import Consultar from "@/servicios/ConsultarContactos";
import TheNavBar from "@/components/TheNavBar";
import Footer from '@/components/Footer.vue'

export default {
    data() {
    return {
      servidorDatos: "",
    };
  },
    components: {
    TheNavBar,
    Footer,
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
  /* beforeMount(){
    this.ConsultarUsuarios()
 },*/
  name: "ConsultarUsuarios",
  mounted() {
    console.log("Componente Consultar Todos los usuarios");
  },
};
</script>
