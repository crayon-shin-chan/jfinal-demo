package czy.demo;


import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class JFinalDemoApplication extends JFinalConfig {

    public static void main(String[] args){
        /* 使用Undertow服务器启动，参数为配置类，端口号，是否为开发模式 */
        //UndertowServer.start(JFinalDemoApplication.class,8080,true);
        /* 使用jetty启动，参数为webapp目录 */
        JFinal.start("src/main/webapp", 8080, "/", 5);
    }

    @Override
    public void onStart() {
        System.out.println("项目已经启动");
    }

    @Override
    public void onStop() {
        System.out.println("项目已经停止");
    }

    @Override
    public void configConstant(Constants me) {

    }

    @Override
    public void configRoute(Routes me) {

    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
