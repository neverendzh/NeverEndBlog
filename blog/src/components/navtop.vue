<template>
  <div class="navtop">
    <img src="../../static/image/blog.png" alt="">
    <ul>
      <li v-for="(item,index) in titleList"  :key="index">
        <router-link :to="item.lookUrl">{{item.lanMu}}</router-link>
      </li>
    </ul>
    <span class="login" @click="goto()">登录</span>
  </div>
</template>

<script>
import {titleList} from '../api/home'
export default {
data(){
  return{
    titleList:[]
  }
},
  created(){
    this.gettitlelist()
  },
  methods:{
    gettitlelist(){
      titleList().then(res=>{
        this.titleList=res.data
      })
    },
    goto(){
      this.$router.push({
        path:'/login/login_in'
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.navtop{
    width: 100%;
    height: 60px;
    line-height: 60px;
    background: #333;
    display: flex;
    justify-content: space-around;
    align-items: center;
    img{
      height: 40px;
    }
    ul{
      display: flex;
      color: #fff;
      justify-content: center;
      align-items: center;
      li{
        font-size: 14px;
        margin: 0 40px;
        &:hover{
          cursor: pointer;
        }
      }
    }
    .login{
      color: #fff;
      margin-left: 30px;
      cursor: pointer;
    }
} 
</style>