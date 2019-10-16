<template>
  <div>
      <navtop/>
      <router-view></router-view>
  </div>
</template>

<script>
import navtop from "../../components/navtop";
export default {
   components:{
     navtop
   }
}
</script>

<style lang="scss" scoped>

</style>