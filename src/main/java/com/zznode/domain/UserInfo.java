package com.zznode.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by asus on 2018/3/22.
 */

/*@ConfigurationProperties(prefix = "info")//映射application中的info*/

@Entity
@Component//使其被扫描，注入ioc容器
public class UserInfo {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名字
     */
    private String name;
    /**
     * 国籍
     */
    @NotNull(message = "国籍不能为空")
    private String nationality;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public UserInfo() {
    }

    public UserInfo(Integer id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
