<template>
  <div class="execution-list-container">
    <el-table :data="list" :border="true" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="rev" label="版本号" width="180"></el-table-column>
      <el-table-column prop="procInstId" label="流程实例ID" width="180"></el-table-column>
      <el-table-column prop="procDefId" label="流程定义ID" width="180"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="parentId" label="父ID" width="180"></el-table-column>
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

type Execution = {
  id: string
  rev: string
  procInstId: string
  businessKey:string
  parentId:string
  procDefId:string
  superExec:string
  rootProcInstId:string
  actId:string
  isActive:number
  isConcurrent:number
  isScope:number
  isEventScope:number
  isMiRoot:number
  suspensionState:string
  cachedEntState:string
  tenantId:string
  name:string
  startTime:string
  startUserId:string
  lockTime:string
  isCountEnabled:number
  evtSubscrCount:number
  taskCount:number
  jobCount:number
  timerJobCount:number
  suspJobCount:number
  deadletterJobCount:number
  varCount:number
  idLinkCount:number
}

/** 执行列表组件 */
@Component({})
export default class ExecutionList extends Vue {

  pageSize:number = 10;
  pageNumber:number = 1;

  data:{
    data: Execution[],
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

  getExecutions(){
      this.$http.get(`/runtime/executions`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getExecutions();
  }

}
</script>

<style lang="scss">

  .execution-list-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>