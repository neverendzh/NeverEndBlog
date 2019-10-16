<template>
  <div class="dairys">
    <div class="times">
        <i class="el-icon-time"></i>
        <span>日记</span>
    </div>
    <light-timeline :items="items">
      <template slot="tag" slot-scope="{ item }">{{item.creatTime}}</template>
      <template slot="content" slot-scope="{ item }">{{item.textContext}}</template>
    </light-timeline>
    <div class="end">
        <i class="el-icon-thumb"></i>
        <span>THE END</span>
    </div>
  </div>
</template>

<script>
import { diaryList } from "@/api/dairy";
export default {
  data() {
    return {
      items: []
    };
  },
  created() {
    this.getdiaryList();
  },
  methods: {
    getdiaryList() {
      diaryList().then(res => {
        this.items = res.data.list;
        this.items.forEach((v, i) => {
          v.creatTime = this.$moment(v.creatTime).format("YYYY-MM-DD");
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
.dairys{
    margin: 0 auto;
}
.line-container /deep/ {
  text-align: left;
  .item-circle {
    border-color: #34b28a;
  }
}
.dairy {
  text-align: center;
  font-size: 16px;
}
.times, .end{
    text-align: left;
    i{
        font-size: 20px;
    }
    span{
        font-size: 16px;
    }
}
</style>