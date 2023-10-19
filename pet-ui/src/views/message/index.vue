<template>
  <div>

    <van-nav-bar
        title="宠物领养"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />

    <van-image :src="petMessage.imageURL" width="100%" height="270px"/>

    <div style="margin-top: 10px;height: 170px;width: 100%;font-size: 18px;">
      <div style="margin-top: 5px;">
        名字: {{petMessage.petName}}
      </div>
      <div style="margin-top: 5px;">
        品种: {{petMessage.petType}}
      </div>
      <div style="margin-top: 5px;">
        疫苗情况: {{petMessage.vaccine === 1 ? '已接种' : '未接种'}}
      </div>
    </div>

    <div style="position: absolute;bottom: 0;width: 100%;margin: 0 auto;">
      <van-button block :type="petMessage.vaccine === 0 ? 'info' : 'primary'" @click="submit"
                  :disabled="petMessage.vaccine !== 0">
        {{petMessage.vaccine === 0 ? '提交申请' : '已被领养'}}
      </van-button>
    </div>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Details",
  data() {
    return {
      id: 0,
      petMessage: {}
    }
  },
  methods: {
    onClickLeft() {
      this.$router.go(-1)
    },
    getInfo() {
      this.$axios.get(`/adopt/${this.id}`).then(({data: res}) => {
        this.petMessage = res.data
        console.log(this.petMessage)
      })
    },
    submit() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      this.$axios.put('/adopt/filed',{
        id: this.petMessage.id,
        username: this.$store.state.username
      },{headers: {'Content-Type': 'application/x-www-form-urlencoded',}})
          .then(({data: res}) => {
            console.log(res)
            Toast(res.message)
            this.getInfo()
      })
    }
  },
  mounted() {
    this.id = this.$route.query.id
    this.getInfo()
  }
}
</script>

<style scoped>

</style>