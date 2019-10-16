<template>
  <div class="bgcontent">
    <div class="content-left">
      <div class="left-top">
        
      </div>
    </div>
    <div class="content-right"></div>
    <!-- <p class="title">{{obj.articleName}}</p>
    <p>{{obj.briefIntroduction}}</p>
    <p>{{obj.creatTime}}</p>
    <div class="content">{{obj.context}}</div> -->
  </div>
</template>

<script>
import {acticletyulan} from '@/api/home'
export default {
 data(){
   return{
     obj:{}
   }
 },
 created(){
   this.getyulan()
 },
 methods:{
   getyulan(){
     let params={
       articleId:this.$route.query.id
     }
     acticletyulan(params).then(res=>{
       this.obj=res.data
       this.obj.creatTime=this.$moment(this.obj.creatTime).format("YYYY-MM-DD")
     })
   }
 }
}
</script>

<style lang="scss" scoped>
.bgcontent{
  width: 80%;
  height: 100%;
  margin: 0 auto;
  border-left: 1px solid #eee;
  border-right: 1px solid #eee;
  background: #eee;
  // background: url('../../../../static/image/bg.png') repeat;
  // width: 100%;
  // height: 100%;
  .content-left{
    width: 700px;
    height: 100%;
    background: #fff;
  }
}
</style>