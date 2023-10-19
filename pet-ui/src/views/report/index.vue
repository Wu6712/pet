<template>
  <div>

    <van-nav-bar
        title="举报"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />

    <van-form @submit="onSubmit">
      <van-field
          v-model="name"
          name="被举报人"
          label="被举报人"
          placeholder="被举报人"
          :rules="[{ required: true, message: '请填写被举报人' }]"
      />
      <van-field
          v-model="context"
          name="描述信息"
          label="描述信息"
          placeholder="描述信息"
          :rules="[{ required: true, message: '请填写描述信息' }]"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">确认举报</van-button>
      </div>
    </van-form>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Report",
  data() {
    return {
      name: '',
      context: ''
    }
  },
  methods: {
    onClickLeft() {
      this.$router.go(-1)
    },
    infoInit() {
      this.name = ''
      this.context = ''
    },
    onSubmit() {
      this.$axios.post('/manage', JSON.stringify({
        name: this.name,
        description: this.context
      }), {headers: {'Content-Type': 'application/json'}}).then(({data: res}) => {
        Toast(res.message)
      }).catch(err => {
        Toast(err)
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