package javarush.test.crud.service;

import javarush.test.crud.dao.UserDao;
import javarush.test.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public List<User> listUsers(int maxRecords,int page) {
        return userDao.listUsers(maxRecords,page);
    }

    @Override
    @Transactional
    public List<User> searchUsers(String name) {
        return userDao.searchUsers(name);
    }

    @Override
    @Transactional
    public int getRecords() {
        return userDao.getRecords();
    }
}
