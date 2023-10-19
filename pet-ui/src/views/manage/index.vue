<template>
  <div>

    <van-nav-bar
        title="举报管理"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />

    <div style="display: flex;flex-wrap: wrap;justify-content: center;">
      <div style="box-shadow: 2px 2px 5px #cccccc;background-color: #ffffff;border-radius: 10px;
                height: 70px;width: 90%;margin-top: 10px;display: flex;flex-wrap: wrap;align-items: center;"
            v-for="item in dataList" :key="item.id">
        <div style="margin-left: 10px;">
          <div>
            被举报人: {{item.name}}
          </div>
          <div>
            举报秒速: {{item.description}}
          </div>
        </div>
        <div style="position: absolute;right: 40px;">
          <van-button :type="item.isHandle === 1 ? 'info' : 'danger'"
                      :disabled="item.isHandle === 1"
                        @click="clickHandle(item)">
            {{item.isHandle === 1 ? '已处理' : '未处理'}}
          </van-button>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Manage",
  data() {
    return {
      dataList: []
    }
  },
  methods: {
    getList() {
      this.$axios.get('/manage/list').then(({data: res}) => {
        console.log(res)
        this.dataList = res.data
      })
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    clickHandle(item) {
      console.log(item)
      this.$axios.put(`/manage?id=${item.id}&name=${item.name}`).then(({data: res}) => {
        Toast(res.message)
        this.getList()
      })
    }
  },
  mounted() {
    this.getList()
  }
}
</script>

<style scoped>

</style>