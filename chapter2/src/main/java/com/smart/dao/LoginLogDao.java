package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;
    private String UPDATE_LOGIN_LOG = "INSERT INTO t_login_log(user_id, ip, login_datetime)" +
            " VALUES(?, ?, ?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertloginLog(LoginLog loginLog) {
        Object[] args = new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDatetime()};
        jdbcTemplate.update(UPDATE_LOGIN_LOG, args);

    }
}
