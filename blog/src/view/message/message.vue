<template>
  <div class="message">
      <div class="message_write">
        <div class="write_top">
          <p>留言板</p>
          <p>拉近你我之间的距离</p>
        </div>
        <div class="write_bottom">
          <el-input type="textarea" :rows="7" placeholder="请输入留言内容" v-model="textarea"/>
        </div>
        <el-button class="btn">提交</el-button>
      </div>
      <div class="message_list">
        <div class="messagelist" v-for="(item,index) in messageList" :key="index">
          <div class="header">
            <img src="../../../static/image/img.jpg" alt="">
          </div>
          <div class="message_content">
            <p class="name">{{item.hfname}}</p>
            <div class="content">{{item.message}}</div>
            <p class="times">{{item.time}}</p>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import {messageList} from '@/api/message'
export default {
  data(){
    return{
      textarea:"",
      messageList:[]
    }
  },
  created(){
    this.getmessageList()
  },
  methods:{
    getmessageList(){
      messageList().then(res=>{
        this.messageList=res.data.list
        this.messageList.forEach(v=>{
          v.time=this.$moment(v.time).format("YYYY-MM-DD HH:mm:ss");
        })
        console.log(res);
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.message{
  display: flex;
  justify-content: center;
  flex-direction: column;
  .message_write{
    margin: 20px auto 0;
    width: 80%;
    height: 300px;
    border: 1px solid #eee;
    .write_top{
      p{
        line-height: 35px;
        &:nth-child(1){
          font-size: 20px;
          font-weight: bold;
        }
        &:nth-child(2){
          font-size: 16px;
        }
      }
    }
    .write_bottom{
      width: 95%;
      height: 160px;
      margin: 0 auto;
    }
    .btn{
      width: 100px;
      height: 35px;
      line-height: 0;
      float: left;
      margin-top: 30px;
      margin-left: 30px;
      background: #34b28a;
      color: #fff;
    }
  }
  .message_list{
    margin: 20px auto 0;
    width: 80%;
    height: 300px;
    border: 1px solid #eee;
    .messagelist{
      display: flex;
      margin: 20px;
      .header{
        img{
          width: 50px;
          height: 50px;
        }
      }
      .message_content{
        text-align: left;
        margin-left: 20px;
        .name{
          font-size: 14px;
          color: #34b28a;
        }
      }
    }
  }
}
</style>