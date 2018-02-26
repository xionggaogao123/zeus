package com.zeus.user.impl.service;

import com.zeus.common.base.BaseMyBatisDao;
import com.zeus.common.base.BaseService;
import com.zeus.common.model.Paging;
import com.zeus.user.api.criteria.UserCriteria;
import com.zeus.user.api.domain.User;
import com.zeus.user.api.service.UserService;
import com.zeus.user.impl.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author keven
 * @date 2018-02-10 下午3:58
 * @Description
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService{


    @Resource
    private UserDao userDao;

    @Override
    protected BaseMyBatisDao<User> getEntityDao() {
        return userDao;
    }

    @Override
    public User findByMail(String mail) {
        return userDao.selectByMail(mail);
    }

    @Override
    public User findByTelPhone(String telPhone) {
        return userDao.selectByTelPhone(telPhone);
    }

    @Override
    public Paging<User> paging(UserCriteria criteria) {
        return null;
    }
}
