package cn.zerosherd.liteoa.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Data
@Entity
@Table(name = "userinfo")
@Getter
@Setter
public class User {
    @Id
    @UuidGenerator
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String username;
    
    @Column(nullable = true)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = true)
    private String dept;

    @Column(nullable = false)
    private int status;

    @Column(nullable = true)
    private String phonenumber;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String avatar;

    @Column(nullable = true)
    private String ip;

    @Column(nullable = true)
    private Date loginTime;

    @Column(nullable = false)
    private Date createTime;

    @Column(nullable = true)
    private Date updateTime;
}
