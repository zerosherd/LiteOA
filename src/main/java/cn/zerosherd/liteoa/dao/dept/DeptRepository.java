package cn.zerosherd.liteoa.dao.dept;

import cn.zerosherd.liteoa.entity.dept.Dept;
import cn.zerosherd.liteoa.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Long> {

    List<Dept> findById(String id);

}
