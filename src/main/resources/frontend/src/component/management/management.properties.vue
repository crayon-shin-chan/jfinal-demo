<template>
  <div class="management-properties-container">
    <el-table :data="list" :border="true" style="width: 100%">
        <el-table-column prop="key" label="键" ></el-table-column>
        <el-table-column prop="value" label="值" ></el-table-column>
        <el-table-column label="操作" width="180" align="center">
        <template slot-scope="scope">
            <el-button type="text" size="small">查看</el-button>
            <el-button type="text" size="small">更新</el-button>
            <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts">

import Vue from 'vue'
import Component from 'vue-class-component'
import { AxiosResponse } from 'axios';

type Properties = {
  [key:string]:string
}

/** 引擎信息组件 */
@Component({})
export default class ManagementProperties extends Vue {

  data:Properties = {} as any;

  get list(){
      let keys:string[] = Object.keys(this.data);
      let list:{key:string,value:string}[] = [];
      for(let i=0;i<keys.length;i++){
          list.push({key:keys[i],value:this.data[keys[i]]})
      }
      return list;
  }

  getProperties(){
      this.$http.get(`/management/properties`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getProperties();
  }

}
</script>

<style lang="scss">

  .management-properties-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>