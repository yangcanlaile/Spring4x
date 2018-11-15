package com.test;

import com.smart.dao.UserDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:smart-context.xml", "file:C:\\ideaPro\\Spring4x\\chapter2\\src\\main\\webapp\\WEB-INF\\smart-servlet.xml"})
public class Test1 {
    @Autowired
    private List<UserDao> userDaoList;



    @org.junit.Test
    public void getListLen() {
        System.out.println("userDao有多少个： " + userDaoList.size());
    }
}
