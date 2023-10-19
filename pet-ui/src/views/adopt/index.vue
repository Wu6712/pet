<template>
  <div>

    <van-nav-bar
        title="领养"
        style="background-color: #4fc08d;color: white"
    />

    <van-search
        v-model="value"
        placeholder="请输入宠物品种"
        shape="round"
        background="#4fc08d"
        @search="onSearch" />

    <van-notice-bar
        left-icon="volume-o"
        :text="text"
        @click="clickBar"
    />

    <div style="display: flex;justify-content: center;flex-wrap: wrap;">
      <div v-for="item in adoptList" :key="item.id" @click="onClick(item.id)"
          style="width: 90%;height: 100px;background-color: floralwhite;margin-top: 10px;border-radius: 10px;
                display: flex;align-items: center;">
        <!--照片-->
        <van-image :src="item.imageURL" width="90px" height="90px" style="margin-left: 10px;" />
        <!--名字描述-->
        <div style="margin-left: 20px">
          <div style="font-size: 30px">
            {{item.petName}}
          </div>
          <div>
            {{item.petType}}
          </div>
        </div>
        <!--领养情况-->
        <div style="margin-left: 50px">
          <van-button type="primary" v-if="item.vaccine === 1">
            {{'已被领养'}}
          </van-button>
          <van-button type="info" v-if="item.vaccine === 0">
            {{'未领养'}}
          </van-button>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import {Dialog, Toast} from "vant";

export default {
  name: "Adopt",
  data() {
    return {
      value: '',
      adoptList: [],
      text: '我们非常高兴地通知您，我们正在进行一项领养计划。如果您一直在考虑为家庭增添一位毛茸茸的伙伴，现在正是寻找您的爱心伙伴的绝佳时机。\n' +
          '\n' +
          '我们的领养中心目前有许多可爱的动物等待着他们的永久家庭。狗狗、猫咪、兔子和其他小动物都在耐心地等待，希望有像您这样的人愿意给予他们爱、关怀和一个温馨的环境。\n' +
          '\n' +
          '通过选择领养，您不仅给了一个值得的动物第二次幸福的机会，还在减少流浪宠物数量和倡导负责任的宠物拥有方面做出了重要贡献。'
    }
  },
  methods: {
    infoInit() {
      this.value = ''
    },
    onSearch(val) {
      this.$axios.get(`/adopt`,{params: {keywords: val}},
          {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
          .then(({data: res}) => {
            console.log(res)
            this.adoptList = res.data
          })
    },
    getList() {
      this.$axios.get('/adopt/list').then(({data: res}) => {
        console.log(res)
        this.adoptList = res.data
      })
    },
    onClick(id) {
      this.$router.push({
        path: 'message',
        query: {
          id: id
        }
      })
    },
    clickBar() {
      Dialog({
        title: '通知',
        message: this.text
      })
    }
  },
  mounted() {
    this.infoInit()
    this.getList()
  }
}
</script>

<style scoped>

</style>