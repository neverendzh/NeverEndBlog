<template>
<div class="bg">
  <div class="login">
    <el-form
      ref="AccountFrom"
      :model="account"
      :rules="rules"
      label-position="left"
      label-width="0px"
      class="demo-ruleForm login-container"
    >
      <p class="title">注册</p>
      <el-form-item prop="username">
        <el-input type="text" v-model="account.username" auto-complete="off" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="pwd">
        <el-input type="password" v-model="account.pwd" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <div class="forget">
        <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
        <p style="display: inline-block;color:#5163FF;cursor: pointer;">忘记密码</p>
      </div>
      <el-form-item style="width:100%;margin:22px 0">
        <el-button type="primary" @click="login">登录</el-button>
      </el-form-item>
      <div class="news">
        <p>注册新用户</p>
      </div>
    </el-form>
  </div>
</div>
</template>

<script>
import { login_In } from "@/api/login";
export default {
  data() {
    return {
      logining: false,
        account: {
          username: '',
          pwd: ''
        },
        rules: {
          username: [
            {required: true, message: '请输入账号', trigger: 'blur'},
          ],
          pwd: [
            {required: true, message: '请输入密码', trigger: 'blur'},
          ]
        },
        checked: true
    };
  },
  methods: {
    login() {
      let params = {
        accountMobile: this.account.username,
        password: this.account.pwd
      };
      login_In(params).then(res => {
        // console.log(res);
        if(res.msg='正常'){
            this.$router.push({
                path:"/user/index"
            })
        }
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.bg{
    position: fixed;
    width: 100%;
    height: 100%;
    background-image: url('../../../static/image/background.png');
    background-size:cover;
    background-repeat: no-repeat;
    .login{
      width: 410px;
      height: 406px;
      background: #fff;
      border-radius:8px;
      // margin: 0 auto;
      position: relative;
      left: 60%;
      top: 50%;
      margin-top: -203px;
    }
    .el-form{
      width: 300px;
      margin: 0 auto;
    }
    .title{
      font-size: 24px;
      color: #707070;
      padding: 25px 0;
    }
    .el-input /deep/{
      .el-input__inner{
        width: 300px;
        height: 60px;
      }
    }
    .forget{
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 300px;
      margin: 0 auto;
    }
    .el-button{
      width: 300px;
      height: 60px;
    }
    .news{
      p{
        text-align: left;
        font-size: 14px;
        color: #5163FF;
        cursor: pointer;
      }
    }
}
</style>