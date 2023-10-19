<template>
  <div>

    <van-nav-bar
        title="寄养"
        style="background-color: #4fc08d;color: white"
    />

    <div style="background: #ffffff;border-radius: 10px;margin: 10px;padding: 10px;box-shadow: 3px 2px 2px #cccccc">
      <van-form @submit="onSubmit" style="margin-top: 30px;font-size: 20px;">
        <van-field
            name="uploader"
            label="照片"
            label-align="center">
          <template #input>
            <van-uploader v-model="fileList" multiple :max-count="1"
                          :after-read="afterRead"/>
          </template>
        </van-field>
        <van-field class="color"
                   v-model="petName"
                   name="宠物名"
                   label="宠物名"
                   :clearable="true"
                   label-align="center"
                   placeholder="宠物名"
                   :rules="[{ required: true, message: '请填写宠物名' }]"
                   @clear="clear"
        />
        <van-field
            readonly
            clickable
            name="picker"
            :value="petType"
            label="宠物类型"
            placeholder="点击选择宠物类型"
            @click="showPicker = true"
            :clearable="true"
            label-align="center"
        />
        <van-popup v-model="showPicker" position="bottom">
          <van-picker
              show-toolbar
              :columns="columns"
              @confirm="onConfirm"
              @cancel="showPicker = false"
          />
        </van-popup>
        <van-field
            v-model="phone"
            name="联系方式"
            label="联系方式"
            placeholder="联系方式"
            :rules="[{ required: true, message: '请填写联系方式' }]"
            :clearable="true"
            label-align="center"
        />
        <van-field
            readonly
            clickable
            name="寄养日期"
            :value="fosterTime"
            label="寄养日期"
            placeholder="点击选择日期"
            @click="showCalendar = true"
            :clearable="true"
            label-align="center"
        />
        <van-calendar v-model="showCalendar" @confirm="onConfirmTime" />
        <div style="margin: 16px;">
          <van-button round block type="info" native-type="submit">提交申请</van-button>
        </div>
      </van-form>
    </div>
  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: "Foster",
  data() {
    return {
      petName: '',
      petType: '',
      showPicker: false,
      showCalendar: false,
      columns: ['宠物狗', '宠物猫'],
      phone: '',
      fosterTime: '',
      imageUrl: '',
      fileList: [],
      file: ''
    }
  },
  methods: {
    infoInit() {
      this.petName = ''
      this.petType = ''
      this.phone = ''
      this.fosterTime = ''
      this.imageUrl = ''
      this.file = ''
      this.fileList = []
    },
    onSubmit() {
      if (this.$store.state.token === '') return Toast('先登录一下吧')
      let form = new FormData()
      form.append("file", this.file)
      this.$axios.post('/foster/upload', form, {headers: {'Content-Type': 'multipart/form-data'}})

      this.$axios.post('/foster', JSON.stringify({
        username: this.$store.state.username,
        fosterTime: this.fosterTime,
        petName: this.petName,
        petType: this.petType,
        phone: this.phone,
        imageUrl: this.imageUrl
      }), {headers: {'Content-Type': 'application/json'}}).then(({data: res}) => {
        console.log(res)
        if (res.code !== 200) return Toast(res.message)
        Toast(res.message)
        setTimeout(() => {
          this.infoInit()
        }, 1000)
      })
    },
    onConfirm(val) {
      this.petType = val
      this.showPicker = false
    },
    onConfirmTime(date) {
      this.fosterTime = `${date.getMonth() + 1}/${date.getDate()}`
      this.showCalendar = false
    },
    clear(){
      console.log(123)
    },
    afterRead(file) {
      this.imageUrl = file.file.name
      this.file = file.file
    }
  }
}
</script>

<style scoped>


.van-field{
  height: 80px;
  font-size: 20px;
  background-color: #ffffff;
}

.van-field__control {
  color: white;
}

.color{

}

</style>