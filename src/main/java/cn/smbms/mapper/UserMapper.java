package cn.smbms.mapper;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询用户列表
     * @param userName
     * @param roleId
     * @return
     */
    public List<User> getUserList(@Param("userName")String userName,
                                  @Param("userRole")Integer roleId);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 使用（foreach）迭代参数(数组)
     * 根据用户列表，获取该角色列表下的用户列表信息
     * @param roleIds
     * @return
     */
    public List<User> getUserByRoleId(Integer[] roleIds);


    /**
     * 使用（foreach）迭代参数(集合)
     * 根据用户角色列表，获取该角色下列表下用户列表信息-foreach_list
     * @param roleList
     * @return
     */
    public List<User> getUserByRoleId_foreach_list(List<Integer> roleList);

    /**
     * 根据用户角色列表性别(多参数)，获取该角色列表下指定性别的用户列表信息
     * @param conditionMap
     * @return
     */
    public List<User> getUserByConditionMap(Map<String,Object> conditionMap);

    /**
     * 查询用户列表
     * 根据条件（用户名称，用户角色，用户编码，创建时间）查询用户表
     * @param userName
     * @param roleId
     * @param userCode
     * @param creationDate
     * @return
     */
    public List<User> getUserListChoose(@Param("userName")String userName,
                                        @Param("userRole")Integer roleId,
                                        @Param("userCode")String userCode,
                                        @Param("creationDate")Date creationDate);

    /**
     * 查询用户表的数量
     * @return
     */
    public int count();

    /**
     *
     * 查询用户列表（分页显示）
     * @param userName
     * @param roleId
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    public List<User> getFyeUserList(@Param("userName") String userName,
                                     @Param("userRole") Integer roleId,
                                     @Param("from") Integer currentPageNo,
                                     @Param("pageSize")Integer pageSize);

}
