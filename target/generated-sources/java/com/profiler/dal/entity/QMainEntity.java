package com.profiler.dal.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMainEntity is a Querydsl query type for MainEntity
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QMainEntity extends EntityPathBase<MainEntity> {

    private static final long serialVersionUID = -528630992L;

    public static final QMainEntity mainEntity = new QMainEntity("mainEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QMainEntity(String variable) {
        super(MainEntity.class, forVariable(variable));
    }

    public QMainEntity(Path<? extends MainEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMainEntity(PathMetadata<?> metadata) {
        super(MainEntity.class, metadata);
    }

}

