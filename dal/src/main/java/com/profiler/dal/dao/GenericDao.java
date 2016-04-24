package com.profiler.dal.dao;

import com.profiler.dal.entity.MainEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author birladeanu
 */
public interface GenericDao<K extends Serializable, V extends MainEntity> {

    V getById(K id);

    K save(V entity);

    V update(V entity);

    void delete(V entity);

    List<V> getAll();

    <T> T getEntity(Class<T> entityClass, Serializable D);

    <KC> KC saveEntity(MainEntity entity, Class<KC> keyClass);
}
