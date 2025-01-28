package task.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.manager.dao.TaskCategoryDao;
import task.manager.entity.TaskCategory;
import task.manager.entity.TaskCategoryId;
import java.util.List;

@Service
public class TaskCategoryService {

    @Autowired
    private TaskCategoryDao taskCategoryDao;

    public TaskCategory linkTaskToCategory(TaskCategory taskCategory) {
        return taskCategoryDao.save(taskCategory);
    }

    public void unlinkTaskFromCategory(Long taskId, Long categoryId) {
      TaskCategoryId id = new TaskCategoryId(taskId, categoryId);
      TaskCategory taskCategory = taskCategoryDao.findById(id)
              .orElseThrow(() -> new RuntimeException("TaskCategory link not found"));
      taskCategoryDao.delete(taskCategory);
    }

    public List<TaskCategory> getCategoriesForTask(Long taskId) {
        return taskCategoryDao.findByIdTaskId(taskId);
    }

    public List<TaskCategory> getTasksForCategory(Long categoryId) {
        return taskCategoryDao.findByIdCategoryId(categoryId);
    }
}
