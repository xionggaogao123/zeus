package com.zeus.user.impl.dao;

import com.zeus.common.base.BaseMyBatisDao;
import com.zeus.user.api.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author keven
 * @date 2018-02-10 下午3:37
 * @Description
 */
@Repository
public class UserDao extends BaseMyBatisDao<User>{

    public User selectByMail(String mail) {
        return sqlSession.selectOne(sqlId("selectByMail"), mail);
    }

    public User selectByTelPhone(String telPhone) {
        return sqlSession.selectOne(sqlId("selectByTelPhone"), telPhone);
    }


}
