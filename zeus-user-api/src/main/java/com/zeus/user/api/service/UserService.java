package com.zeus.user.api.service;

import com.zeus.common.model.Paging;
import com.zeus.user.api.criteria.UserCriteria;
import com.zeus.user.api.domain.User;

/**
 * @author keven
 * @date 2018-02-10 下午3:31
 * @Description
 */
public interface UserService {

    User findById(Long id);

    User findByMail(String mail);

    User findByTelPhone(String telPhone);

    Long create(User user);

    Boolean update(User user);

    Boolean deleteById(Long id);

    Paging<User> paging(UserCriteria criteria);

}
