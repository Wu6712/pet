<template>
  <div class="login">
    <van-nav-bar
        title="注册"
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
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">注册</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Register",
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    infoInit() {
      this.username = ''
      this.password = ''
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    onSubmit() {
      this.$axios.post('/user/register', JSON.stringify({
        username: this.username,
        password: this.password
      }),
          {headers: {'Content-Type': 'application/json'}}).then(({data: res}) => {
        console.log(res)
        Toast(res.message)
        setTimeout(() => {
          this.$router.go(-1)
        }, 1000)
      })
    }
  },
  mounted() {
    this.infoInit()
  }
}
</script>

<style scoped>

</style>