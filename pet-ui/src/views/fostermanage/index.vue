<template>
  <div>

    <van-nav-bar
        title="寄养管理"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />

    <div style="display: flex;flex-wrap: wrap;justify-content: center;">
      <div style="box-shadow: 2px 2px 5px #cccccc;background-color: #ffffff;border-radius: 10px;
                  height: 70px;width: 90%;margin-top: 10px;display: flex;align-items: center;"
           v-for="item in dataList" :key="item.id">
        <div style="margin-left: 5px">
          <div>
            寄养人: {{item.username}}
          </div>
          <div>
            寄养时间: {{item.fosterTime}}
          </div>
        </div>
        <div style="margin-left: 10px;">
          <div>
            宠物名: {{item.petName}}
          </div>
          <div>
            联系方式: {{item.phone}}
          </div>
        </div>
        <van-button :type="item.vaccine === 1 ? 'info' : 'danger'"
                    :disabled="item.vaccine === 1"
                    @click="clickHandle(item)"
                    style="position: absolute;right: 25px">
          {{item.vaccine === 1 ? '已处理' : '未处理'}}
        </van-button>
      </div>
    </div>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "FosterManage",
  data() {
    return {
      dataList: []
    }
  },
  methods: {
    getList() {
      this.$axios.get('/foster/list').then(({data: res}) => {
        console.log(res)
        this.dataList = res.data
      })
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    clickHandle(item) {
      this.$axios.put(`/foster/${item.id}`).then(({data: res}) => {
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