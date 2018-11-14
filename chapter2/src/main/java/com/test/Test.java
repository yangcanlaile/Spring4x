package com.test;

import com.smart.dao.UserDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:smart-context.xml"})
public class Test {
    @Autowired
    private List<UserDao> userDaoList;

    @org.junit.Test
    public void getListLen() {
        System.out.println("userDao有多少个： " + userDaoList.size());
    }
}
