package czy.demo;


import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import czy.demo.controller.HelloWorldController;

/* Jfinal需要一个全局配置类，启动时使用配置类启动 */
public class JFinalDemoApplication extends JFinalConfig {

    public static void main(String[] args){
        /* 使用Undertow服务器启动，参数为配置类，端口号，是否为开发模式 */
        UndertowServer.start(JFinalDemoApplication.class,8080,true);
        /* 使用jetty启动，参数为webapp目录，这个配置有问题，访问不了 */
        //JFinal.start("src/main/webapp", 8080, "/", 5);
    }

    /* 启动钩子 */
    @Override
    public void onStart() {
        System.out.println("项目已经启动");
    }

    /* 停止钩子 */
    @Override
    public void onStop() {
        System.out.println("项目已经停止");
    }

    @Override
    public void configConstant(Constants me) {
        /* 开发模式 */
        me.setDevMode(true);
        /* 编码 */
        me.setEncoding("utf-8");
    }

    /* 路由配置方法 */
    @Override
    public void configRoute(Routes me) {
        /* 配置首页路由 */
        me.add("/", HelloWorldController.class);
    }

    /* 配置模板引擎 */
    @Override
    public void configEngine(Engine me) {

    }

    /* 配置插件 */
    @Override
    public void configPlugin(Plugins me) {
        /* 读取数据库属性文件 */
        Prop db = PropKit.use("db.properties");

        /* Druid连接池插件 */
        DruidPlugin druid = new DruidPlugin(db.get("url"),db.get("username"),db.get("password"));
        me.add(druid);

        /* orm映射插件 */
        ActiveRecordPlugin activeRecord = new ActiveRecordPlugin(druid);
        me.add(activeRecord);
    }

    /* 拦截器 */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
