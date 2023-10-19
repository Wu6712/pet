<template>
  <div class="login">
    <van-nav-bar
        title="登录"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />


    <van-form @submit="onSubmit" style="margin-top: 20px;">
      <van-field
          v-model="username"
          name="用户名"
          label="用户名"
          placeholder="用户名"
          :rules="[{ required: true, message: '请填写用户名' }]"
      />
      <van-field
          v-model="password"
          type="password"
          name="密码"
          label="密码"
          placeholder="密码"
          :rules="[{ required: true, message: '请填写密码' }]"
      />
      <div style="font-size: 14px;margin: 10px 0 0 10px;">
        <a href="/register" style="border-bottom: 1px solid">去注册</a>
      </div>
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">提交</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Login",
  data() {
    return {
      username: '',
      password: ''
    }
  },
  mounted() {
    this.formInit()
  },
  methods: {
    formInit() {
      this.username = ''
      this.password = ''
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    // 登录
    onSubmit() {
      this.$axios.post('/user/login', {
        username: this.username,
        password: this.password
      },{headers: {'Content-Type': 'application/x-www-form-urlencoded'}}
      ).then(({data: res}) => {
        if (res.code !== 200)return Toast(res.message)
        Toast(res.message)
        sessionStorage.setItem('token', res.data)
        this.$store.dispatch('SET_TOKEN', res.data)
        this.$store.dispatch('SET_USERNAME', this.username)
        setTimeout(() => {
          this.$router.go(-1)
        }, 1000)
      })
    }
  }
}
</script>

<style scoped>

</style>