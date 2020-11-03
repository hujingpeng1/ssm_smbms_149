package cn.smbms;

import cn.smbms.mapper.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserMapperTest {
    private static Logger logger =Logger.getLogger(UserMapperTest.class);
    private static SqlSession session = null;
    @Test
    public void getUserList(){
        try {
            session = SqlSessionUtil.getSqlSession();
            String userName = "";
            Integer roleId = 3;
            List<User> userList = session.getMapper(UserMapper.class).getUserList(userName, roleId);
            for (User item : userList) {
                logger.info(item.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlSession(session);
        }
    }

    @Test
    public void userMapByRoleTest(){
        try {
            session = SqlSessionUtil.getSqlSession();
            Integer[] integers = {2,3};
            List<User> userByRoleId = session.getMapper(UserMapper.class).getUserByRoleId(integers);
            for (User item : userByRoleId) {
                logger.info(item.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlSession(session);
        }
    }

    @Test
    public void getUserByRoleId_foreach_list(){
        try {
            session = SqlSessionUtil.getSqlSession();
            List<User> userList = new ArrayList<User>();
            List<Integer> roleList = new ArrayList<Integer>();
            roleList.add(2);
            roleList.add(3);
            userList = session.getMapper(UserMapper.class).getUserByRoleId_foreach_list(roleList);
            for (User item : userList) {
                logger.info(item.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlSession(session);
        }
    }

    @Test
    public void getUserByConditionMap(){
        try {
            session = SqlSessionUtil.getSqlSession();
            Map<String,Object> conditionMap = new HashMap<String,Object>();
            List<Integer> roleList = new ArrayList<Integer>();
            roleList.add(2);
            roleList.add(3);
            conditionMap.put("gender",1);
            conditionMap.put("roleIds",roleList);
            List<User> userList = session.getMapper(UserMapper.class).getUserByConditionMap(conditionMap);
            for (User item : userList) {
                logger.info(item.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlSession(session);
        }
    }

    @Test
    public void getUserListChoose(){
        try {
            session = SqlSessionUtil.getSqlSession();
            String userName = "";
            Integer roleId =null;
            String userCode = "";
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01");
            List<User> list = session.getMapper(UserMapper.class).getUserListChoose(userName, roleId, userCode, date);
            for (User item : list) {
                logger.info(item.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlSession(session);
        }
    }
}
