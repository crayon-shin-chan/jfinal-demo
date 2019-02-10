package czy.demo.model;

import com.jfinal.plugin.activerecord.Model;

/* JFinal的model并不是普通的JavaBean，没有属性 */
public class User extends Model<User> {

    /* 获取一个dao查询对象 */
    public static final User dao = new User().dao();

}
