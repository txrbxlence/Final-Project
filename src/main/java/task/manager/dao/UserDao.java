package task.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.manager.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
