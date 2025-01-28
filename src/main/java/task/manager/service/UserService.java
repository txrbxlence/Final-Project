package task.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.manager.dao.UserDao;
import task.manager.entity.User;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User createUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User user) {
        User existingUser = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userDao.save(existingUser);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
