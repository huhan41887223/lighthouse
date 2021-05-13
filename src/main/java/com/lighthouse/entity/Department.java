package com.lighthouse.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@DynamicUpdate(value = true)
@Table(name = "dt_department")
public class Department extends AbstractBaseEntity {

    @Column(length = 255)
    @ApiModelProperty("部门名称")
    public String name;

    @Column(length = 2000)
    @ApiModelProperty("人数")
    public Integer number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
