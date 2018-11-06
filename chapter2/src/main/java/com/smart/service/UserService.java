package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;


    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount >= 1 ? true : false;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDatetime(user.getLastVisit());
        loginLog.setUserId(user.getUserId());
        userDao.updateLoginInfo(user);
        loginLogDao.insertloginLog(loginLog);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }
}
