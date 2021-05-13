package com.lighthouse.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class AbstractBaseEntity implements Cloneable, Serializable {

    @Id
    @ApiModelProperty("主键ID")
    public Long id;

    @Override
    public AbstractBaseEntity clone() {
        try {
            return (AbstractBaseEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
