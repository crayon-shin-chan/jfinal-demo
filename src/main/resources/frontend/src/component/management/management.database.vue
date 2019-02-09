<template>
  <div class="deployment-list-container">
    <el-table :data="list" :border="true" style="width: 100%">
      <el-table-column prop="name" label="名称" width="240"></el-table-column>
      <el-table-column prop="count" label="数据量" width="240"></el-table-column>
      <el-table-column label="操作" width="180" align="center">
        <template slot-scope="scope">
            <el-button type="text" size="small">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="data.length" :page-size="pageSize" :current-page.sync="pageNumber"></el-pagination>
  </div>
</template>

<script lang="ts">

import Vue from 'vue'
import Component from 'vue-class-component'
import { AxiosResponse } from 'axios';

type Table = {
  name:string
  url:string
  count:number
}

/** 部署列表组件 */
@Component({})
export default class ManagementDatabase extends Vue {

  pageNumber:number = 1;
  pageSize:number = 10;

  data:Table[] = [];

  get list(){
    return this.data.slice((this.pageNumber-1)*this.pageSize,this.pageNumber*this.pageSize)
  }

  getTables(){
      this.$http.get(`/management/tables`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getTables();
  }

}
</script>

<style lang="scss">

  .deployment-list-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>