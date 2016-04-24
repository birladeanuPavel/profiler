package com.profiler.dal.dao.impl;

import com.mysema.query.jpa.hibernate.HibernateQueryFactory;
import com.profiler.dal.dao.GenericDao;
import com.profiler.dal.entity.MainEntity;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author birladeanu
 * @param <K>
 * @param <V>
 */
public class GenericDaoImpl<K extends Serializable, V extends MainEntity> implements GenericDao<K, V> {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    protected HibernateQueryFactory queryFactory;
    
    protected static final Logger LOGGER = Logger.getLogger(GenericDaoImpl.class);
    
    private final Class<V> clazz;
    
    protected GenericDaoImpl() {
         this.clazz =(Class<V>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public V getById(K id) {
        return (V) getSession().get(clazz, id);
    }

    @Override
    public K save(V entity) {
        return (K) getSession().save(entity);
    }

    @Override
    public void delete(V entity) {
        getSession().delete(entity);
    }

    @Override
    public List<V> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<V>) criteria.list();
    }

    @Override
    public V update(V entity) {
        return (V) getSession().merge(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(clazz);
    }

    @Override
    public <T> T getEntity(Class<T> entityClass, Serializable D) {
        return (T) getSession().get(entityClass, D);
    }

    @Override
    public <KC> KC saveEntity(MainEntity entity, Class<KC> keyClass) {
        return (KC) getSession().save(entity);
    }

}
