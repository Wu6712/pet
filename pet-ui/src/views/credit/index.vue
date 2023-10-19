<template>
  <div>

    <van-nav-bar
        title="信誉分"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />

    <div style="display: flex;justify-content: center;margin-top: 50px">
      <van-circle
          v-model="credit"
          :clockwise="false"
          :speed="100"
          :text="credit + '分'"
          size="230px"
      />
    </div>
    <div>

    </div>

  </div>
</template>

<script>
export default {
  name: "Credit",
  data() {
    return {
      credit: 0
    }
  },
  methods: {
    getInfo() {
      this.$axios.get(`/user/getInfo?username=${this.$store.state.username}`).then(({data: res}) => {
        console.log(res);
        this.credit = res.data.credit
      })
    },
    onClickLeft() {
      this.$router.go(-1)
    }
  },
  mounted() {
    this.getInfo()
  }
}
</script>

<style scoped>

</style>