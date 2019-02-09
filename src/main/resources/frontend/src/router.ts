import VueRouter from 'vue-router'
import Vue from 'vue'

const DeploymentList = () => import(/* webpackChunkName: "DeploymentList" */ './component/deployment/deployment.list.vue')

const ProcessDefinitionsList = () => import(/* webpackChunkName: ProcessDefinitionsList" */'./component/process/process.definitions.list.vue')

const ModelList = () => import(/* webpackChunkName: ModelList" */'./component/model/model.list.vue')

const TaskList = () => import(/* webpackChunkName: TaskList" */'./component/task/task.list.vue')

const ExecutionList = () => import(/* webpackChunkName: ExecutionList" */'./component/execution/execution.list.vue')

const UserList = () => import(/* webpackChunkName: UserList" */'./component/user/user.list.vue')

const UserGroupList = () => import(/* webpackChunkName: UserGroupList" */'./component/user/user.group.list.vue')

const ManagementDatabase = () => import(/* webpackChunkName: "ManagementDatabase" */'./component/management/management.database.vue')

const ManagementEngine = () => import(/* webpackChunkName: "ManagementDatabase" */'./component/management/management.engine.vue')

const ManagementProperties = () => import(/* webpackChunkName: "ManagementProperties" */'./component/management/management.properties.vue')


Vue.use(VueRouter);

const router:VueRouter = new VueRouter({
    routes:[
        {
            path:"/",
            component: DeploymentList
        },
        {
            path:"/deployment",
            component: DeploymentList
        },
        {
            path:"/process",
            component: ProcessDefinitionsList
        },
        {
            path:"/model",
            component: ModelList
        },
        {
            path:"/task",
            component: TaskList
        },
        {
            path:"/execution",
            component: ExecutionList
        },
        {
            path:"/user",
            component: UserList
        },
        {
            path:"/user/group",
            component: UserGroupList
        },
        {
            path:"/management/database",
            component:ManagementDatabase
        },
        {
            path:"/management/engine",
            component:ManagementEngine
        },
        {
            path:"/management/properties",
            component:ManagementProperties
        }
    ]
})

export default router;