<template>
  <div class="message">
    <div class="message_write">
      <div class="write_top">
        <p>留言板</p>
        <p>拉近你我之间的距离</p>
      </div>
      <div class="write_bottom">
        <el-input type="textarea" :rows="7" placeholder="请输入留言内容" v-model="textarea" />
      </div>
      <el-button class="btn" @click="submit">提交</el-button>
    </div>
    <div class="message_list">
      <p v-if="messageList.length===0">还没有人开始留言,我先留一篇</p>
      <div class="messagelist" v-for="(item,index) in messageList" :key="index" v-show="index<num">
        <div class="header">
          <img :src="item.accountImg" alt />
        </div>
        <div class="message_content">
          <div class="message_top">
            <span class="name">{{item.hfname}}</span>
            <p class="times">{{item.time}}</p>
          </div>
          <div class="message_bottom">
            <div class="content">{{item.message}}</div>
            <p v-show="item.countReMsg===0?false:true" @click="watchhf(item)">查看回复({{item.countReMsg}})</p>
          </div>
          <div class="hflist" v-show="item.countReMsg===0?false:true"  v-for="(items,index) in hfList" :key="index">
            <span>{{items.hfname}}</span>
            <p>{{items.message}}({{items.time}})</p>
          </div>
          <!-- <p class="packup" @click="packup" v-if="hfList.length===0?false:true">收起当前所有回复</p> -->
          <div class="message_center">
            <el-rate v-model="value3" show-text></el-rate>
            <i class="el-icon-edit-outline" @click="reply(item)">回复</i>
          </div>
          <div class="hfcontent" v-show="item.isShow">
            <el-input type="text" v-model="hfcontent" class="texts"></el-input>
            <el-button class="btn" @click="published">发表</el-button>
          </div>
        </div>
      </div>
      <span @click="showMore" class="folding">{{txt}}</span>
    </div>
  </div>
</template>

<script>
import { messageList, submitMessage,replyMessage,seereplyMessage} from "@/api/message";
export default {
  data() {
    return {
      textarea: "",
      messageList: [], //当前所有一级留言
      hfList:[], //当前一级下面的二级留言
      value3: null,
      hfcontent:'',
      replayid:'',
      hfcontents:false,
      isShhowhflist:false,
      txt: '显示全部',
      isShow: true,
      num: 3,
    };
  },
  created() {
    this.getmessageList();
  },
  methods: {
    //发表留言
    submit() {
      let params = {
        leavingMsg: this.textarea
      };
      submitMessage(params).then(res => {
        if(res.code===200){
          this.getmessageList()
          this.$notify({
            message: '留言成功',
            type: 'success'
        });
        this.textarea =''
        }else if(res.code===301){
          this.$notify({
            message: '当前未登录,登录信息失效,请重新登录',
            type: 'warning'
        });
        }
      });
    },
    //留言列表
    getmessageList() {
      messageList().then(res => {
        this.messageList = res.data.list;
        this.messageList.forEach(v => {
          v.time = this.$moment(v.time).format("YYYY-MM-DD HH:mm:ss");
        });
      });
    },
    //点击回复（回复框出现）
    reply(item){
      this.replayid=item.messageId
      if(!item.isShow){
        this.$set(item,'isShow',false)
        item.isShow =!item.isShow
      }else{
        item.isShow =!item.isShow
      }
    },
    //查看更多
    showMore(){
      this.isShow = !this.isShow;
      this.num = this.isShow? 3: this.messageList.length;
      this.txt = this.isShow?  '显示全部':'收起'
    },
    //根据一级countRemsg判断该留言是否有回复并点击
    watchhf(item){
      let params={
        replymsgid:item.messageId
      }
      seereplyMessage(params).then(res=>{
        this.hfList=res.data.list
        this.hfList.forEach(t=>{
          t.time = this.$moment(t.time).format("YYYY-MM-DD HH:mm:ss");;
        })
      })
      this.isShhowhflist = true
    },
    //收起当前展开的所有回复
    packup(){
      this.isShhowhflist = false
    },
    //发表回复（一级）留言
    published(){
      let params={
        leavingMsg:this.hfcontent,
        replymsgid:this.replayid
      }
      replyMessage(params).then(res=>{
        this.hfcontent=''
        let params={
          replymsgid:this.replayid
      }
      seereplyMessage(params).then(res=>{
        this.hfList=res.data.list
      })
      })
    }
  }
};
</script>

<style lang="scss" scoped>
.message {
  display: flex;
  justify-content: center;
  flex-direction: column;
  .message_write {
    margin: 20px auto 0;
    width: 80%;
    height: 300px;
    border: 1px solid #eee;
    .write_top {
      p {
        line-height: 35px;
        &:nth-child(1) {
          font-size: 20px;
          font-weight: bold;
        }
        &:nth-child(2) {
          font-size: 16px;
        }
      }
    }
    .write_bottom {
      width: 95%;
      height: 160px;
      margin: 0 auto;
    }
    .btn {
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
  .message_list {
    margin: 20px auto 0;
    width: 80%;
    // height: 300px;
    border: 1px solid #eee;
    .messagelist {
      display: flex;
      margin: 20px;
      // height: 70px;
      .header {
        img {
          width: 50px;
          height: 50px;
        }
      }
      .message_content {
        width: 100%;
        text-align: left;
        margin-left: 20px;
        border-bottom: 1px solid #eee;
        // margin-bottom: 5px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        .message_top {
          font-size: 16px;
          display: flex;
          align-items: center;
          height: 30px;
          .name {
            color: #34b28a;
            margin-right: 20px;
          }
        }
        .message_bottom{
          display: flex;
          justify-content: space-between;
          align-items: center;
          height: 20px;
          font-size: 14px;
          p{
            cursor: pointer;
          }
        }
        .hflist{
          display: flex;
          align-items: center; 
          height: 20px;
          span{
            margin-right: 30px;
            color: #34b28a;
          }
        }
        .message_center{
          display: flex;
          align-items: center;
          margin-bottom: 5px;
          i{
            font-size: 14px;
            margin-left: 50px;
            cursor: pointer;
          }
        }
        .hfcontent{
          display: flex;
          align-items: center;
          .texts{
            width: 520px;
            height: 30px;
          }
          .el-input /deep/{
            .el-input__inner{
              height: 30px;
            }
          }
          .btn {
              width: 80px;
              height: 30px;
              line-height: 0;
              float: left;
              background: #34b28a;
              color: #fff;
              margin-left: 10px;
          }
        }
      }
    }
    .folding{
      cursor: pointer;
    }
  }
}
</style>