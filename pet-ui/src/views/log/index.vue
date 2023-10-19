<template>
  <div style="width: 100%;height: 100%">

    <van-nav-bar
        title="我的日志"
        style="background-color: #4fc08d;color: white"
    />

    <div style="display: flex;justify-content: center;flex-wrap: wrap;" >
      <div v-for="item in dataList" :key="item.id" class="box"
          style="width: 90%;height: 100px;margin-top: 15px;border-radius: 5px;display: flex;align-items: center;">
        <div style="width: 90px;height: 90px;background-color: skyblue;margin-left: 5px;">
          <van-image :src="item.imageUrl" width="90px" height="90px" />
        </div>
        <div style="width: 71%;height: 90px;margin-left: 5px;">
          {{item.description}}
        </div>
        <div>
          <van-button type="danger" size="small" @click="deleteOne(item.id)">删除</van-button>
          <van-button type="primary" size="small" @click="updateLog(item)">修改</van-button>
        </div>
      </div>
    </div>

    <van-button icon="plus" type="primary" round
                style="position: absolute; bottom: 70px;right: 20px;"
                @click="publicLog"/>

    <van-popup v-model="show" round position="bottom" :style="{ height: '50%' }" closeable >
      <div style="margin-top: 20px;">
        <van-uploader v-model="fileList" multiple :after-read="afterRead" :max-count="1" />
      </div>
      <div style="width: 100%;">
        <van-field v-model="context" placeholder="请输入内容..." style="border-radius: 5px;" />
      </div>
      <van-button type="primary" block style="margin-top: 100px;" @click="clickSend">
        发布日志
      </van-button>
    </van-popup>

    <van-popup v-model="showUpdate" round position="bottom" :style="{ height: '50%' }" closeable >
      <div style="margin-top: 20px;">
        <van-uploader v-model="fileList" multiple :after-read="afterRead" :max-count="1" />
      </div>
      <div style="width: 100%;">
        <van-field v-model="context" placeholder="请输入内容..." style="border-radius: 5px;" />
      </div>
      <van-button type="primary" block style="margin-top: 100px;" @click="clickUpdate">
        修改日志
      </van-button>
    </van-popup>


  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Log",
  data() {
    return {
      dataList: [],
      show: false,
      showUpdate: false,
      fileList: [],
      context: '',
      forms: [],
      logId: 0,
      isUpdateImage: false,
      log: {}
    }
  },
  mounted() {
    this.getList()
    this.infoInit()
  },
  methods: {
    getList() {
      this.$axios.get(`/log/list`, {
        params: {
          username: this.$store.state.username
        }
      })
          .then(({data: res}) => {
            console.log(res.data)
            this.dataList = res.data
      })
    },
    publicLog() {
      if (!sessionStorage.getItem('token')) return Toast('请先登录一下吧')
      this.show = true
    },
    infoInit() {
      this.fileList = []
      this.context = ''
      this.isUpdateImage = false
      this.log = {}
    },
    afterRead(file) {
      this.forms.push(file)
      this.isUpdateImage = true
      console.log(this.forms)

    },
    clickSend() {
      const formData = new FormData();
      this.forms.forEach(file => {
        formData.append('files', file.file);
      })

      this.$axios.post(`/log/upload?context=${encodeURIComponent(this.context)}&username=${this.$store.state.username}`,
          formData).then(({data: res}) => {
        Toast(res.message)
        this.show = false
        this.infoInit()
        this.getList()
      })
    },
    deleteOne(id) {
      console.log(id);
      this.$dialog.confirm({
        title: '确认删除吗',
        message: '删除后消息不可恢复,是否继续该操作',
        confirmButtonColor: '#2693ff',
      }).then(() => {
        console.log("then")
        this.$axios.delete(`/log/${id}`).then(({data: res}) => {
          Toast(res.message)
          if(res.code === 200) {
            this.getList()
          }
        })
      })
    },
    updateLog(item) {
      this.showUpdate = true
      this.logId = item.id
      this.context = item.description
      this.fileList = [{ url: item.imageUrl }]
    },
    clickUpdate() {
      console.log("image", this.isUpdateImage)
      if(this.isUpdateImage) {
        console.log(123)
        const formData = new FormData();
        this.forms.forEach(file => {
          formData.append('files', file.file);
        })
        this.$axios.post(`/log/update2?context=${encodeURIComponent(this.context)}&id=${this.logId}`,
            formData).then(({data: res}) => {
          Toast(res.message)
          this.showUpdate = false
          this.infoInit()
          this.getList()
        })
      }else {
        this.log.username = this.$store.state.username
        this.log.description = this.context
        this.log.imageUrl = this.fileList[0].url
        this.log.id = this.logId
        console.log(this.log)
        this.$axios.post('/log/update1', JSON.stringify(this.log),
            {headers: {"Content-Type": "application/json"}}).then(({ data: res }) => {
          Toast(res.message)
          this.showUpdate = false
          this.infoInit()
          this.getList()
        })
      }
    }
  }
}
</script>

<style scoped>
.box{
  margin: 20px auto;
  width: 90%;
  padding: 5px;
  box-shadow: 2px 2px 5px #cccccc;
  background-color: #ffffff;
  border-radius: 10px;
}
</style>