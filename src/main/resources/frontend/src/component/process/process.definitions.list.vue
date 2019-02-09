<template>
  <div class="process-definitions-list-container">
    <el-table :data="list" :border="true" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="key" label="键" width="180"></el-table-column>
      <el-table-column prop="version" label="版本" width="180"></el-table-column>
      <el-table-column prop="description" label="描述" width="180"></el-table-column>
      <el-table-column prop="category" label="类别" width="180"></el-table-column>
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

type ProcessDefinition = {
  id: string
  url: string
  key: string
  version: number
  name: string
  description: string
  tenantId: string
  deploymentId: string
  deploymentUrl: string
  resource: string
  diagramResource: string
  category:string
  graphicalNotationDefined: boolean
  suspended: boolean
  startFormDefined: boolean
}

/** 部署列表组件 */
@Component({})
export default class ProcessDefinitionsList extends Vue {

  pageSize:number = 10;
  pageNumber:number = 1;

  data:{
    data: ProcessDefinition[],
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

  getProcessDefinitions(){
      this.$http.get(`/repository/process-definitions`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getProcessDefinitions();
  }

}
</script>

<style lang="scss">

  .process-definitions-list-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>