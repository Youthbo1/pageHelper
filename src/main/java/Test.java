import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Role;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        testPageHelper();

//        testGetRole();
    }
    public static void testPageHelper() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();

            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            PageHelper.startPage(1, 4);
            List<Role> roleList = roleMapper.f();
            PageInfo<Role> pageInfo = new PageInfo<>(roleList);

            List<Role> rl=pageInfo.getList();
            for (Role r: rl
                 ) {
                System.out.println(r);
            }
            System.out.println(roleList.size());
            System.out.println(pageInfo.getTotal());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    public static void testGetRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            System.out.println(role.getRoleName());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
