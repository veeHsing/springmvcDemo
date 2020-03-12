package test;

import com.zhangwx.dao.UserMapper;
import com.zhangwx.model.User;
import com.zhangwx.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.InputStream;

public class MyTest {

    @Test
    public void test1(){

        ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContent.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.findAll();


    }

    @Test
    public void test2() throws Exception{
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findById();
        session.close();
        in.close();

    }
}
