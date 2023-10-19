<template>
  <div>

    <van-nav-bar
        title="领养管理"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
        style="background-color: #4fc08d;color: white"
    />

    <div style="display: flex;flex-wrap: wrap;justify-content: center;">
      <div style="box-shadow: 2px 2px 5px #cccccc;background-color: #ffffff;border-radius: 10px;
                  height: 70px;width: 90%;margin-top: 10px;display: flex;align-items: center"
            v-for="item in dataList" :key="item.id">
        <van-image width="70px" height="70px" :src="item.imageURL" />
        <div style="margin-left: 10px">
          <div>
            申请人: {{item.user.username}}
          </div>
          <div>
            宠物名: {{item.petName}}
          </div>
        </div>
        <van-button :type="item.vaccine === 1 ? 'info' : 'danger'"
                    :disabled="item.vaccine === 1"
                    @click="clickHandle(item)"
                    style="position: absolute;right: 30px">
          {{item.vaccine === 1 ? '已处理' : '未处理'}}
        </van-button>
      </div>
    </div>

  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "AdoptManage",
  data() {
    return {
      dataList: []
    }
  },
  methods: {
    getList() {
      this.$axios.get("/adopt/lists").then(({data: res}) => {
        console.log(res)
        this.dataList = res.data
      })
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    clickHandle(item) {
      console.log(item)
      this.$axios.put(`/adopt/${item.id}`).then(({data: res}) => {
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