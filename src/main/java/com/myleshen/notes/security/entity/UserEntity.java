package com.myleshen.notes.security.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
@Data
public class UserEntity {

    @Id
    private int id;
    private String userName;
    private String userPass;
    private String roleList;
    private Boolean active;

}
