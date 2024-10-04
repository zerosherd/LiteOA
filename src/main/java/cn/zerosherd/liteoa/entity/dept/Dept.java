package cn.zerosherd.liteoa.entity.dept;

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
@Table(name = "deptinfo")
@Getter
@Setter
public class Dept {

    @Id
    @UuidGenerator
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String deptname;

    @Column(nullable = false)
    private int status;

    @Column(nullable = true)
    private Date createTime;

}
