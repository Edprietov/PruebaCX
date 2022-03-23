<template>
   <footer >
        <div class="container" style="padding: 80px 0;" align="center">
            <a href="#">
                <i class="fa fa-facebook fa-lg white-text mr-md-5 mr-3 fa-2x"></i>
            </a>
            <a href="#">
                    <i class="fa fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"></i>
                </a>
                <a href="#">
                        <i class="fa fa-google-plus fa-lg white-text mr-md-5 mr-3 fa-2x"></i>
                    </a>
                    <a href="#">
                            <i class="fa fa-linkedin fa-lg white-text mr-md-5 mr-3 fa-2x"></i>
                        </a>
                        <a href="#">
                                <i class="fa fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"></i>
                            </a>
                            <a href="#">
                                    <i class="fa fa-pinterest fa-lg white-text"></i>
                                </a>
        </div>
        <div class="intro">
            <p style="color: black; padding: 15px 0;" align="center">
                &copy; 2022 Copyright: <a href="https://github.com/Edprietov" style="color: black;"> Created By: Edisson Prieto </a>
            </p>
        </div>
    </footer>

</template>

<script>
export default {
  name: 'TheFooter',
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.footer {
   position: fixed;
   left: 0;
   bottom: 305;
   width: 100%;
   background-color: red;
   color: white;
   text-align: center;
}
.intro{
background: -webkit-linear-gradient(left, #3931af, #00c6ff);;
}
</style>
