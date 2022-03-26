<template>
<div>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Imagine CX</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/">Todos los contactos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="crear">Crear contacto</a>
      </li>
    </ul>
  </div>
</nav>
</div>
</template>

<script>

export default {
  name: 'TheNavbar',
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.navbar {
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
    margin-top: 1%;
    padding: 1%;
    
}
</style>
