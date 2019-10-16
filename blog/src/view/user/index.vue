<template>
  <div>
      <!-- <div class="box" :style="{width:offsetwidth,height:offsetheight,background:offsetbackground}"></div> -->
  </div>
</template>

<script>
export default {
  data(){
    return{
      
    }
  },
  computed:{
    offsetHeight: () => {
      // return window.innerHeight + 'px'
    }
  }
}
</script>

<style>
.box{
  border-radius: 50%;
}
</style>