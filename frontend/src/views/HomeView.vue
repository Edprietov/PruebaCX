<template>
  <div class="home">
    <Navbar msg="Welcome to Your Vue.js App"/>
  </div>
  <Footer></Footer>
</template>

<script>
// @ is an alias to /src
import Navbar from '@/components/TheNavBar.vue'
import Footer from '@/components/Footer.vue'


export default {
  name: 'HomeView',
  components: {
    Navbar,
    Footer,
  }
}
</script>

<style scoped>
.home{background: rgb(105, 105, 105);
};

</style>

