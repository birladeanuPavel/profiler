package com.profiler.dao;

import com.mysema.query.jpa.hibernate.HibernateQueryFactory;
import com.profiler.GenericTest;
import com.profiler.dal.Gender;
import com.profiler.dal.dao.UserDao;
import com.profiler.dal.entity.Profile;
import com.profiler.dal.entity.QUser;
import com.profiler.dal.entity.User;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pavel
 */
public class UserDaoTest extends GenericTest{

    @Autowired
    private HibernateQueryFactory queryFactory;
    
    @Autowired
    private UserDao userDao;
    
    @Before
    public void init() {
        Profile profile = new Profile();
        profile.setName("adminProfile");
        Long id = userDao.saveEntity(profile, Long.class);
        profile.setId(id);
        
        User user = new User();
        user.setAvatar(new byte[2]);
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setBirthDate(new Date());
        user.setEmail("admin@emai.ro");
        user.setPassword("123456");
        user.setProfile(profile);
        user.setGender(Gender.MALE);
        userDao.save(user);
    }
    
    @Test
    public void saveUser() {
        QUser qUser = QUser.user;
        
        User user = queryFactory.from(qUser)
                .where(qUser.firstName.eq("admin")).uniqueResult(qUser);
     
        Assert.assertNotNull(user);
        Assert.assertEquals("admin@emai.ro", user.getEmail());
        Assert.assertEquals(Gender.MALE, user.getGender());
    }
    
}
