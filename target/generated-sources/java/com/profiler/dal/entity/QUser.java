package com.profiler.dal.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -383387905L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QMainEntity _super = new QMainEntity(this);

    public final ArrayPath<byte[], Byte> avatar = createArray("avatar", byte[].class);

    public final DatePath<java.util.Date> birthDate = createDate("birthDate", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final EnumPath<com.profiler.dal.Gender> gender = createEnum("gender", com.profiler.dal.Gender.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lastName = createString("lastName");

    public final StringPath password = createString("password");

    public final QProfile profile;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile")) : null;
    }

}

