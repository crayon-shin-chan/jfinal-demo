package czy.demo.controller;

import com.jfinal.core.Controller;

/* Controller类 */
public class HelloWorldController extends Controller {

    /* index方法会被映射为/路径，其他方法映射为方法名 */
    public void index(){
        renderText("欢迎进入JFinal！");
    }

}
