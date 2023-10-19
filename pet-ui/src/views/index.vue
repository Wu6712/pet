<template>
  <div>
    <router-view />
    <van-tabbar v-model="active" @change="onChange">
      <van-tabbar-item
          to="/foster"
          :icon="active === 0 ? require('@/assets/fosterActive.png') : require('@/assets/foster.png')"
      >
        寄养
      </van-tabbar-item>
      <van-tabbar-item
          to="/adopt"
          :icon="active === 1 ? require('@/assets/adoptActive.png') : require('@/assets/adopt.png')"
      >
        领养
      </van-tabbar-item>
      <van-tabbar-item to="log" icon="comment-o">日志</van-tabbar-item>
      <van-tabbar-item to="my" icon="friends-o">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      active: 0
    }
  },
  methods: {
    onChange(index) {
      this.active = index
      sessionStorage.setItem('index', index)
    }
  },
  computed: {
    //changeIndex() {
    //  this.active = sessionStorage.getItem('index')
    //}
  },
  watch: {
    $router: {
      change() {
        this.active = sessionStorage.getItem('index')
      }
    }
  }
}
</script>

<style scoped>

</style>