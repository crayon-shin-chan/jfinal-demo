<template>
  <div class="user-list-container">
    <el-table :data="list" :border="true" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="lastName" label="姓" width="180"></el-table-column>
      <el-table-column prop="firstName" label="名" width="180"></el-table-column>
      <el-table-column prop="email" label="邮箱" width="180"></el-table-column>
      <el-table-column label="头像" width="180">
          <template slot-scope="scope">
              <img :src="scope.row.pictureUrl"/>
          </template>
      </el-table-column>
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

type User = {
  id: string
  firstName: string
  lastName: string
  url: string
  email: string
  pictureUrl:string
}

/** 用户列表组件 */
@Component({})
export default class UserList extends Vue {

  pageSize:number = 10;
  pageNumber:number = 1;

  data:{
    data: User[],
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

  getUsers(){
      this.$http.get(`/identity/users`)
        .then((value:AxiosResponse)=>{
           this.data = value.data
        })
        .catch(reason=>{
          console.log("请求失败")
          console.log(reason)
        })
  }

  mounted() {
      this.getUsers();
  }

}
</script>

<style lang="scss">

  .user-list-container{
    margin: 20px auto 0px auto;
    width: 80%;
  }

</style>