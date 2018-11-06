package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private String MATCH_COUNT_SQL = "SELECT count(*) FROM t_user " +
            "where user_name=? and password=?";
    private final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

    /**
     * @param username 用户名
     * @param password 密码
     * @return 数据库匹配数
     */
    public int getMatchCount(String username, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,
                new Object[]{username, password}, Integer.class);
    }

    /**
     * 通过用户名查询用户
     * @param userName 用户名
     * @return  用户对象
     */
    public User findUserByUserName(String userName) {
        String sqlStr = "SELECT user_id, user_name, credits " +
                "FROM t_user WHERE user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserName(userName);
                user.setUserId(resultSet.getInt("user_id"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    /**
     * 更新用户登录时间
     *
     * @param user 登录用户对象
     */
    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(),
                user.getLastIp(), user.getCredits(), user.getUserId()});
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
