<template>
  <div>
    <!-- <navtop /> -->
    <div class="homes">
      <div class="homes_left">
        <el-tree
          :data="data"
          show-checkbox
          node-key="id"
          ref="tree"
          @check-change="currentchange()"
          :default-expanded-keys="[2, 3]"
          :default-checked-keys="[5]"
          :props="defaultProps"
        ></el-tree>
      </div>
      <div class="homes_centre">
        <router-view></router-view>
        <!-- <div
          v-for="(item,index) in acticletHort"
          :key="index"
          class="hortList"
          @click="yulan(item,index)"
        >
          <div class="article_top">
            <p style="font-size:16px;color:#34b28a;font-weight:bold">{{item.articleName}}</p>
            <div>
              <i class="el-icon-date"></i>
              <p>{{item.creatTime}}</p>
            </div>
          </div>
          <div class="article_bottom">
            <img src="../../../static/image/blog.png" alt />
            <div>{{item.briefIntroduction}}</div>
          </div>
        </div> -->
      </div>
      <div class="homes_right">
        <div class="article_search">
          <div class="search_top">
            <el-input placeholder="输入关键字搜索" v-model="searchName" @keyup.enter.native="searcharticle"></el-input>
          </div>
          <div class="search_bottom">
            <ul>
              <li v-for="(item,index) in searchHort" :key="index" @click="search()">{{item.articleName}}</li>
            </ul>
          </div>
        </div>
        <div class="article_hot">
          <div class="search_top">热门文章</div>
          <div class="search_bottom">
            <ul>
              <li v-for="(item,index) in acticletHorts" :key="index">{{item.articleName}}</li>
            </ul>
          </div>
        </div>
        <div class="article_top">
          <div class="search_top">文章置顶</div>
          <div class="search_bottom">
            <ul>
              <li v-for="(item,index) in articletopList" :key="index">{{item.articleName}}</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import navtop from "../../components/navtop";
import articles from '../home/article'
import {
  acticletree,
  acticletHort,
  acticletTop,
  searchacticletree,
  acticletyulan,
  searchacticle
} from "../../api/home";
export default {
  components: {
    // navtop,
    articles
  },
  data() {
    return {
      data: [],
      acticletHort: [],
      acticletHorts: [],
      searchHort: [],
      articletopList: [],
      searchName: "",
      artilce: "",
      defaultProps: {
        children: "children",
        label: "title"
      }
    };
  },
  created() {
    this.getaricletree();
    this.getacticletHort();
    this.getacticletTop();
  },
  methods: {
    //左侧树型
    getaricletree() {
      acticletree().then(res => {
        this.data = res.data;
      });
    },
    //查看发布的文章
    search(item, index) {
      this.$router.push({
        // path:"/article"
      })
      // let params = {
      //   articleId: item.articleId
      // };
      // acticletyulan(params).then(res => {
      //     this.acticletHort = res.data;
      //     console.log(res);
      // });
    },
    //树型当前选中的数值
    currentchange() {
      let arr = this.$refs.tree.getCheckedKeys();
      arr.forEach(v => {
        this.artilce = v;
      });
          let params = {
            artilceid: this.artilce,
            pageNum: 5,
            pageStart: 1,
            state: 0
          };
          searchacticletree(params).then(res => {
            this.acticletHort=res.data
          });
    },
    //文章首页排序
    getacticletHort() {
      acticletHort().then(res => {
        this.acticletHort = res.data;
        this.acticletHorts=res.data
        this.searchHort=res.data
        this.acticletHort.forEach(v => {
          v.creatTime = this.$moment(v.creatTime).format("YYYY-MM-DD");
        });
      });
    },
    //关键字搜索
    searcharticle(){
      let params={
        searchname:this.searchName,
        state:0
      }
      searchacticle(params).then(res=>{
        // this.acticletHort=res.data
        this.searchHort=res.data
      })
    },
    //文章置顶列表
    async getacticletTop() {
      let res = await acticletTop();
      this.articletopList = res.data;
    }
  }
};
</script>

<style lang="scss" scoped>
.homes {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
  .homes_left {
    width: 250px;
    margin-left: 50px;
    border: 1px solid #eee;
    .el-tree /deep/ {
      .el-tree-node__label {
        margin-left: 10px;
      }
    }
  }
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
      img {
      }
      div {
        width: 70%;
      }
    }
  }
  .homes_right {
    margin-right: 50px;
    .article_search,
    .article_hot,
    .article_top {
      margin-bottom: 20px;
      width: 250px;
      border: 1px solid #eee;
      .search_top {
        color: #fff;
        height: 40px;
        background: #333;
        line-height: 40px;
        .el-input /deep/ {
          border-radius: 20px;
          outline: none;
          .el-input__inner {
            width: 200px;
            height: 30px;
            border-radius: 20px;
          }
        }
      }
      .search_bottom {
        display: flex;
        justify-content: center;
        ul {
          li {
            width: 200px;
            height: 40px;
            line-height: 40px;
            cursor: pointer;
            font-size: 14px;
            border-bottom: 1px dashed #eee;
          }
        }
      }
    }
  }
}
</style>