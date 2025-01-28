package task.manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCategory {

    @EmbeddedId
    private TaskCategoryId id;

    @ManyToOne
    @MapsId("taskId") 
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @MapsId("categoryId") 
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}