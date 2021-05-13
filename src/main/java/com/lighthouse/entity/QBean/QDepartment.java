//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lighthouse.entity.QBean;

import com.lighthouse.entity.Department;
import com.lighthouse.entity.QAbstractBaseEntity;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

public class QDepartment extends EntityPathBase<Department> {
    private static final long serialVersionUID = 683416198L;
    public static final QDepartment department = new QDepartment("department");
    public final QAbstractBaseEntity _super = new QAbstractBaseEntity(this);
    public final NumberPath<Long> id;
    public final StringPath name;
    public final NumberPath<Integer> number;

    public QDepartment(String variable) {
        super(Department.class, PathMetadataFactory.forVariable(variable));
        this.id = this._super.id;
        this.name = this.createString("name");
        this.number = this.createNumber("number", Integer.class);
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata());
        this.id = this._super.id;
        this.name = this.createString("name");
        this.number = this.createNumber("number", Integer.class);
    }

    public QDepartment(PathMetadata metadata) {
        super(Department.class, metadata);
        this.id = this._super.id;
        this.name = this.createString("name");
        this.number = this.createNumber("number", Integer.class);
    }
}
