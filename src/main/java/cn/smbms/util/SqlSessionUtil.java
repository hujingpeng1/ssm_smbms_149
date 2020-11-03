package cn.smbms.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory factory = null;

    static {
       try {
           InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
           factory = new SqlSessionFactoryBuilder().build(is);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    /**
     * 获取SqlSession的方法
     * @return
     */
    public static SqlSession getSqlSession(){
        return  factory.openSession(); //默认是true
    }

    /**
     * 关闭的方法
     * @param session
     */
    public static void closeSqlSession(SqlSession session){

        if (session!=null)session.close();
    }

}
