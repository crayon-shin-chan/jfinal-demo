package czy.demo;


import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import czy.demo.controller.HelloWorldController;

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

        /* PropKit可以读取属性文件 */
        PropKit.use("db.properties");
        System.out.println(PropKit.get("url"));
    }

    /* 停止钩子 */
    @Override
    public void onStop() {
        System.out.println("项目已经停止");
    }

    @Override
    public void configConstant(Constants me) {

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

    }

    /* 拦截器 */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
