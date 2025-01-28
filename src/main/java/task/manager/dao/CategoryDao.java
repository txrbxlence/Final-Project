package task.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.manager.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
}
