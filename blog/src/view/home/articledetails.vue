<template>
  <div>
    <div class="hortList">
          <div class="article_top">
            <p>{{obj.articleName}}</p>
            <div>
              <i class="el-icon-date"></i>
              <p>{{obj.creatTime}}</p>
            </div>
          </div>
          <div class="article_bottom">
            <img src="../../../static/image/blog.png" alt />
            <div>{{obj.context}}</div>
          </div>
        </div>
  </div>
</template>

<script>
import {acticletyulan} from '@/api/home'
export default {
  data() {
    return {
        obj:{}
    };
  },
  created(){
      this.yulan()
  },
  methods: {
    //查看发布的文章
    yulan() {
      let params = {
        articleId: this.$route.query.id
      };
      acticletyulan(params).then(res => {
        this.obj = res.data;
        this.obj.creatTime=this.$moment(this.obj.creatTime).format("YYYY-MM-DD")
      });
    }
  }
};
</script>

<style scoped lang="scss">
.homes_centre {
    display: flex;
    flex-direction: column;
    width: 50%;
    cursor: pointer;
    .hortList {
    //   height: 250px;
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