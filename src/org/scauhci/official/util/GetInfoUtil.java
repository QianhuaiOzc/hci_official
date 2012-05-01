package org.scauhci.official.util;

import cn.edu.scau.hci.info.person.datafetcher.DataFetcher;
import cn.edu.scau.hci.info.person.datafetcher.Params;
import java.sql.Date;
import org.nutz.dao.entity.Record;
import org.scauhci.official.Config;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.MemberExtend;

/**
 *
 * @author jiang
 */
public class GetInfoUtil {

    private static String apiKey = Config.apiKey;
    private static String base = Config.base;

    //init
    static {

        DataFetcher.setBase(base); // 设置人员数据接口的地址
        DataFetcher.setKeyCode(apiKey); // 设置接口的keyCode
    }

    public static Member getMember(String id) {
        Member m=new Member();
        MemberExtend me=new MemberExtend();
        Params params = Params.make("username", id).add("language", "CN").add("with", "contact_info");
        Record rc = DataFetcher.fetch("persons_infos", params);
        //无记录
        if (rc == null) {
            return null;
        }
        m.setName(rc.getString("name"));
        m.setStudentId(id);
        m.setExtend(me);
        me.setMobile(rc.getString("mobilenum"));
        me.setMobileshort(rc.getString("mobilenuminshort"));
        me.setEmail(rc.getString("email"));
        me.setBirthday(Date.valueOf(rc.getString("birthday")));
        me.setSex(rc.getString("birthday").endsWith("true")?1:0);
        me.setHomepage(rc.getString("homepage"));
        rc = DataFetcher.fetch("class_info", Params.make("username", id));
        if(rc==null){
            return m;
        }
        me.setMajor(rc.getString("major"));
        me.setAcademy(rc.getString("major").indexOf("软件学院")==-1?"信息学院":"软件学院");
        me.setGrade(Integer.parseInt(rc.getString("grade")));
        return m;
    }
}
