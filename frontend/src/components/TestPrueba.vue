<template>
  <div card>
    <div class="form-row">
      <label class="control-label col-sm-2" for="nombreUsuario"
        ><strong>Nombre Usuario a Consultar:</strong></label
      >
      <div class="col-sm-2">
        <input
          required
          type="text"
          id="nombreUsuario"
          class="form-control"
          v-model="nombreUsuario"
        />
      </div>
      <strong class="control-label col-sm-2"> Id de la mascota:</strong>
      <label class="control-label col-sm-2">
        <input
          type="number"
          d="idMascota"
          class="control-label col-sm-8"
          v-model="idMascota"
      /></label>
      <label class="control-label col-sm-2" for="fecha"
        ><strong>Fecha:</strong></label
      >
      <div class="col-sm-1">
        <input type="date" id="fecha" class="form-control" v-model="fecha" />
      </div>

      <button class="btn btn-success" @click="enviarForma">Consultar</button>
    </div>
    <table class="table" aria-describedby="consultarM">
      <thead>
        <th scope="col">#Denuncia</th>
        <th scope="col">Id Mascota</th>
        <th scope="col">Fecha</th>
        <th scope="col">Tipo</th>
        <th scope="col">Descripción</th>
        <th scope="col">Detalles</th>
      </thead>
      <tbody>
        <tr v-for="valor in servidorDatos" :key="valor.id">
          <td>{{ valor.denunId }}</td>
          <td>{{ valor.animalId }}</td>
          <td>{{ valor.denunFecha }}</td>
          <td>{{ valor.denunTipo }}</td>
          <td>{{ valor.denunDescrip }}</td>
          <td>{{ valor.detalles }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>


<script>
export default {
  name: 'ConsultarUsuarios',
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
