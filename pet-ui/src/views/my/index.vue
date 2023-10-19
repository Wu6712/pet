<template>
  <div>

    <van-nav-bar
        title="我的"
        style="background-color: #4fc08d;color: white"
    />

    <div v-if="isLogin" style="width: 100%;height: 120px;display: flex;align-items: center;" @click="clickLogin">
      <van-image width="90px" height="90px" style="margin-left: 20px" round :src="require('@/assets/111.jpg')"></van-image>
      <div style="margin-left: 30px;color: darkgray">
        <h2>{{ username }}</h2>
      </div>
    </div>
    <div v-else style="width: 100%;height: 120px;display: flex;align-items: center;" @click="clickLogin">
      <van-image width="90px" height="90px" style="margin-left: 20px" round :src="require('@/assets/login.png')"></van-image>
      <div style="margin-left: 30px;color: darkgray">
        <h2>请登录</h2>
      </div>
    </div>

    <!--单元格-->
    <van-cell-group>
      <van-cell
          is-link size="large"
          title="修改密码"
          @click="clickChangePasswd" />
      <van-cell
          is-link size="large"
          title="信用分"
          @click="clickChangeCredit" />
      <van-cell
          is-link size="large"
          title="举报"
          @click="clickReport" />
      <van-cell
          v-if="$store.state.username === 'admin'"
          is-link size="large"
          title="举报管理"
          @click="clickPermissions" />
      <van-cell
          v-if="$store.state.username === 'admin'"
          is-link size="large"
          title="领养管理"
          @click="clickAdopt" />
      <van-cell
          v-if="$store.state.username === 'admin'"
          is-link size="large"
          title="寄养管理"
          @click="clickFoster" />
    </van-cell-group>

    <!--退出登录-->
    <div style="margin: 30px;">
      <van-button round block type="info" @click="logout">退出登录</van-button>
    </div>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "My",
  data() {
    return {
      isLogin: false,
      username: ''
    }
  },
  methods: {
    clickLogin() {
      this.$router.push('/login')
    },
    clickChangePasswd() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      this.$router.push('/change')
    },
    clickReport() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      this.$router.push('/report')
    },
    getInfo() {
      if (sessionStorage.getItem('token')) {
        this.isLogin = true
        this.username = this.$store.state.username
        return
      }
      this.isLogin = false
    },
    logout() {
      sessionStorage.removeItem('token')
      this.$store.state.token = ''
      this.$store.state.username = ''
      this.isLogin = false
    },
    clickPermissions() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      this.$router.push('/manage')
    },
    clickAdopt() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      this.$router.push('/adoptmanage')
    },
    clickFoster() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      this.$router.push('/fostermanage')
    },
    clickChangeCredit() {
      if (this.$store.state.token === '') return Toast('先登录一下')
      this.$router.push('/credit')
    }
  },
  mounted() {
    this.getInfo()
  }
}
</script>

<style scoped>

</style>