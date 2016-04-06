package com.profiler.dal.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProfile is a Querydsl query type for Profile
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProfile extends EntityPathBase<Profile> {

    private static final long serialVersionUID = -1353235979L;

    public static final QProfile profile = new QProfile("profile");

    public final QMainEntity _super = new QMainEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public QProfile(String variable) {
        super(Profile.class, forVariable(variable));
    }

    public QProfile(Path<? extends Profile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfile(PathMetadata<?> metadata) {
        super(Profile.class, metadata);
    }

}

