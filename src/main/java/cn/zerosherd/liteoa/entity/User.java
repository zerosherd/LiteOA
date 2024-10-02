package cn.zerosherd.liteoa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "userinfo")
public class User {
    @Id
    @GeneratedValue
    private String id;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private String dept;
    private int status;
}
