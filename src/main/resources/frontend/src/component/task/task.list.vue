<template>
  <div class="task-list-container">
    <el-table :data="list" :border="true" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="rev" label="版本号" width="180"></el-table-column>
      <el-table-column prop="executionId" label="执行ID" width="180"></el-table-column>
      <el-table-column prop="procInstId" label="流程实例ID" width="180"></el-table-column>
      <el-table-column prop="procDefId" label="流程定义ID" width="180"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="parentTaskId" label="父任务ID" width="180"></el-table-column>
      <el-table-column prop="description" label="描述" width="180"></el-table-column>
      <el-table-column prop="taskDefKey" label="任务定义KEY" width="180"></el-table-column>
      <el-table-column prop="owner" label="拥有者" width="180"></el-table-column>
      <el-table-column prop="assignee" label="代理人" width="180"></el-table-column>
      <el-table-column prop="deletegation" label="代理" width="180"></el-table-column>
      <el-table-column prop="priority" label="优先级" width="180"></el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="180"></el-table-column>
      <el-table-column prop="dueDate" label="持续时间" width="180"></el-table-column>
      <el-table-column prop="category" label="类别" width="180"></el-table-column>
      <el-table-column prop="suspension" label="状态" width="180"></el-table-column>
      <el-table-column prop="tenantId" label="承租人ID" width="180"></el-table-column>
      <el-table-column prop="formKey" label="表单KEY" width="180"></el-table-column>
      <el-table-column prop="claimTime" label="认领时间" width="180"></el-table-column>
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

type Task = {
  id: string
  rev: string
  executionId: string
  procInstId: string
  procDefId:string
  name:string
  parentTaskId:string
  description:string
  taskDefKey:string
  owner:string
  assignee:string
  deletegation:string
  priority:string
  createTime:string
  dueDate:string
  category:string
  suspensionState:string
  tenantId: string
  formKey:string
  claimTime:string
}

/** 任务列表组件 */
@Component({})
export default class TaskList extends Vue {

  pageSize:number = 10;
  pageNumber:number = 1;

  data:{
    data: Task[],
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

  getTasks(){
      this.$http.get(`/runtime/tasks`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }
  
  mounted() {
      this.getTasks();
  }

}
</script>

<style lang="scss">

  .task-list-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>