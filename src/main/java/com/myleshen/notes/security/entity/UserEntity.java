package com.myleshen.notes.security.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private UUID id;
    private String userName;
    private String userPass;
    private String roleList;
    private Boolean active;

}
