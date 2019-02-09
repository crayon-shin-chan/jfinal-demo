<template>
  <div class="management-engine-container">
    <el-table :data="[data]" :border="true" style="width: 100%">
      <el-table-column prop="name" label="名称" ></el-table-column>
      <el-table-column prop="resourceUrl" label="资源" ></el-table-column>
      <el-table-column prop="exception" label="异常" ></el-table-column>
      <el-table-column prop="version" label="版本" ></el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts">

import Vue from 'vue'
import Component from 'vue-class-component'
import { AxiosResponse } from 'axios';

type Engine = {
  name: string,
  resourceUrl: string,
  exception: string,
  version: string
}

/** 引擎信息组件 */
@Component({})
export default class ManagementEngine extends Vue {

  data:Engine = {} as any;

  getEngine(){
      this.$http.get(`/management/engine`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getEngine();
  }

}
</script>

<style lang="scss">

  .management-engine-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>