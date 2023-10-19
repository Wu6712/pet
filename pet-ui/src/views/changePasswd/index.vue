<template>
  <div>

    <van-nav-bar
        title="修改密码"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />

    <van-form @submit="onSubmit">
      <van-field
          v-model="oldPassword"
          type="password"
          name="旧密码"
          label="旧密码"
          placeholder="旧密码"
          :rules="[{ required: true, message: '请填写旧密码' }]"
      />
      <van-field
          v-model="newPassword"
          type="password"
          name="新密码"
          label="新密码"
          placeholder="新密码"
          :rules="[{ required: true, message: '请填写新密码' }]"
      />
      <van-field
          v-model="confirmPassword"
          type="password"
          name="确认密码"
          label="确认密码"
          placeholder="新密码"
          :rules="[{ required: true, message: '请填写新密码' }]"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">提交修改</van-button>
      </div>
    </van-form>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "ChangePasswd",
  data() {
    return {
      oldPassword: '',
      newPassword: '',
      confirmPassword: ''
    }
  },
  methods: {
    infoInit() {
      this.oldPassword = ''
      this.newPassword = ''
      this.confirmPassword = ''
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    onSubmit() {
      if (this.oldPassword === this.newPassword) {
        Toast('旧密码和新密码不能一样')
        return
      } else if (this.newPassword !== this.confirmPassword) {
        Toast('2次密码不相同')
        return
      }
      this.$axios.put('/user', {
        oldPassword: this.oldPassword,
        newPassword: this.newPassword,
        username: this.$store.state.username
      },{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
          .then(({data: res}) => {
            console.log(res)
            if (res.code !== 200) return Toast(res.message)
            this.$axios.get(`/user/${this.$store.state.username}`).then(({data: res}) => {
              console.log(res)
              sessionStorage.setItem('token', res.data)
              this.$store.dispatch('SET_TOKEN', res.data)
              Toast('修改成功')
              setTimeout(() => {
                this.$router.go(-1)
              }, 1000)
            })
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