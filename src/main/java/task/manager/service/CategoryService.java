package task.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.manager.dao.CategoryDao;
import task.manager.entity.Category;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

        public Category createCategory(Category category) {
        return categoryDao.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryDao.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryDao.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(category.getName());
        return categoryDao.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        categoryDao.deleteById(id);
    }
}
