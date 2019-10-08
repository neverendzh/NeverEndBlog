<template>
  <div>
    <div
          v-for="(item,index) in acticletHort"
          :key="index"
          class="hortList"
          @click="yulan(item,index)"
        >
          <div class="article_top">
            <p>{{item.articleName}}</p>
            <div>
              <i class="el-icon-date"></i>
              <p>{{item.creatTime}}</p>
            </div>
          </div>
          <div class="article_bottom">
            <img src="../../../static/image/blog.png" alt />
            <div>{{item.briefIntroduction}}</div>
          </div>
        </div>
  </div>
</template>

<script>
import {acticletHort} from '@/api/home'
export default {
    // props:{
    //   acticletHort:{
    //     type:Array,
    //     default:[]
    //   },
    //   yulan:{
    //     type:Function,
    //     default:()=>{}
    //   }
    // },
    data(){
        return{
            acticletHort:[]
        }
    },
    created(){
      this.getacticletHort()
    },
    methods:{
    //文章首页排序
      getacticletHort() {
        acticletHort().then(res => {
          this.acticletHort = res.data;
          this.acticletHort.forEach(v => {
            v.creatTime = this.$moment(v.creatTime).format("YYYY-MM-DD");
          });
        });
      },
      //预览文章
      yulan(item){
        this.$router.push({
          path:"articledetails",
          query:{
            id:item.articleId
          }
        })
      }
    }
}
</script>

<style scoped lang="scss">
.homes_centre {
    display: flex;
    flex-direction: column;
    width: 50%;
    cursor: pointer;
    .hortList {
      height: 250px;
      border-top: 1px solid #eee;
      border-bottom: 1px solid #eee;
    }
    .article_top {
      height: 50px;
      line-height: 50px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      div {
        display: flex;
        align-items: center;
      }
    }
    .article_bottom {
      display: flex;
      justify-content: space-between;
      align-items: center;
      div {
        width: 70%;
      }
    }
  }
</style>