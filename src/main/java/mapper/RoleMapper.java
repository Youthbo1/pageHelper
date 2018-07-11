package mapper;

import pojo.Role ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    public List<Role> f();
    public List<Role> findRole1(@Param("roleName") String roleName);
    
    public List<Role> findRole2(Role role);
    
    public List<Role> findRole3(Role role);
    
    public List<Role> findRole4(@Param("roleName") String roleName);
    
    public List<Role> findRole5(String roleName);
    
    public List<Role> findRole6(@Param("roleName") String roleName, @Param("note") String note);
    
    public int updateRole(Role role);
    
    public List<Role> findRoleByNums1(@Param("roleNoList") List<String> roleNoList);
    public Role getRole(Long id);
    public List<Role> getRoleTest(@Param("type") String type);
    
}
