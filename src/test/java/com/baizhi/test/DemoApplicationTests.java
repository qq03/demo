package com.baizhi.test;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelect() {
//        查询所有
        List<User> users = userMapper.selectAll();
        System.out.println(users);
//        根据主键进行查询
       // User user = userMapper.selectByPrimaryKey("1");

//        查询总条数
        //int i = userMapper.selectCount(new User());
  /*      User t = new User();
       t.setName("qq");
        List<User> users = userMapper.select(t);
       t.setName("admin");
        User one = userMapper.selectOne(t);
        System.out.println(one);*/

    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("张三");
        user.setPassword("123456");
//        增加
       // userMapper.insert(user);
//        使用insertSelective进行插入时，会忽略值为null的字段
        userMapper.insertSelective(new User("13","ss",null));
    }
    @Test
    public void testUpdate(){
        //userMapper.updateByPrimaryKey(new User("15","张三岁","777"));
        userMapper.updateByPrimaryKeySelective(new User("15",null,"105"));
    }
    @Test
    public void testDelete(){
//        删除多个数据
        int i = userMapper.delete(new User(null, "qq", null));
        System.out.println(i);
        // userMapper.deleteByPrimaryKey("2");
    }

}
