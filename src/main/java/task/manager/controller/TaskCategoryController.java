package task.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.manager.entity.TaskCategory;
import task.manager.service.TaskCategoryService;

import java.util.List;

@RestController
@RequestMapping("/task-categories")
public class TaskCategoryController {

    @Autowired
    private TaskCategoryService taskCategoryService;

    @PostMapping
    public ResponseEntity<TaskCategory> linkTaskToCategory(@RequestBody TaskCategory taskCategory) {
        TaskCategory createdLink = taskCategoryService.linkTaskToCategory(taskCategory);
        return new ResponseEntity<>(createdLink, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> unlinkTaskFromCategory(
            @RequestParam Long taskId,
            @RequestParam Long categoryId
    ) {
        taskCategoryService.unlinkTaskFromCategory(taskId, categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskCategory>> getCategoriesForTask(@PathVariable Long taskId) {
        List<TaskCategory> categories = taskCategoryService.getCategoriesForTask(taskId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<TaskCategory>> getTasksForCategory(@PathVariable Long categoryId) {
        List<TaskCategory> tasks = taskCategoryService.getTasksForCategory(categoryId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
