package task.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.manager.entity.TaskCategory;
import task.manager.entity.TaskCategoryId;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskCategoryDao extends JpaRepository<TaskCategory, TaskCategoryId> {

    List<TaskCategory> findByIdTaskId(Long taskId);

    List<TaskCategory> findByIdCategoryId(Long categoryId);

    Optional<TaskCategory> findById(TaskCategoryId id);

}
