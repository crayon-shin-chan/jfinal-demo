<template>
  <div class="model-list-container">
    <el-table :data="list" :border="true" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="rev" label="版本号" width="180"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="key" label="键" width="180"></el-table-column>
      <el-table-column prop="category" label="类别" width="180"></el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="180"></el-table-column>
      <el-table-column prop="lastUpdateTime" label="最后更新时间" width="180"></el-table-column>
      <el-table-column prop="version" label="版本" width="180"></el-table-column>
      <el-table-column prop="metaInfo" label="元信息" width="180"></el-table-column>
      <el-table-column prop="deploymentId" label="部署ID" width="180"></el-table-column>
      <el-table-column label="操作" width="180" align="center">
        <template slot-scope="scope">
            <el-button type="text" size="small">查看</el-button>
            <el-button type="text" size="small">更新</el-button>
            <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="data.total" :page-size="pageSize" :current-page.sync="pageNumber"></el-pagination>
  </div>
</template>

<script lang="ts">

import Vue from 'vue'
import Component from 'vue-class-component'
import { AxiosResponse } from 'axios';

type Model = {
  id: string
  rev: string
  name: string
  key: string
  category:string
  createTime:string
  lastUpdateTime:string
  version: number
  metaInfo: string
  deploymentId: string
  tenantId: string
}

/** 部署列表组件 */
@Component({})
export default class ModelList extends Vue {

  pageSize:number = 10;
  pageNumber:number = 1;

  data:{
    data: Model[],
    order:'asc'|'desc',
    start:number,
    total:number,
    sort:string
  } = {
    data:[]
  } as any;

  get list(){
    return this.data.data.slice((this.pageNumber-1)*this.pageSize,this.pageNumber*this.pageSize)
  }

  getModels(){
      this.$http.get(`/repository/models`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getModels();
  }

}
</script>

<style lang="scss">

  .model-list-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>