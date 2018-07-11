import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Role;
import utils.SqlSessionFactoryUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

            List<Role> roleList1 = roleMapper.f();
            PageInfo page = new PageInfo(roleList);
//测试PageInfo全部属性
//PageInfo包含了非常全面的分页属性
            assertEquals(1, page.getPageNum());
            assertEquals(4, page.getPageSize());
            assertEquals(1, page.getStartRow());
            assertEquals(10, page.getEndRow());
            assertEquals(183, page.getTotal());
            assertEquals(19, page.getPages());
            assertEquals(1, page.getFirstPage());
            assertEquals(8, page.getLastPage());
//            assertEquals(true, page.isFirstPage());
//            assertEquals(false, page.isLastPage());
            assertEquals(false, page.isHasPreviousPage());
            assertEquals(true, page.isHasNextPage());
            System.out.println("**********************roleList1:");
            for (Role r: roleList1
                    ) {
                System.out.println(r);
            }
            List<Role> rl=pageInfo.getList();
            System.out.println("**********************pageInfo:");
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
