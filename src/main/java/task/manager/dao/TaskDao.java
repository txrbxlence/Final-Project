package task.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.manager.entity.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {
}