package javarush.test.crud.dao;


import javarush.test.crud.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
    User updateUser(User user);
    User getUser(int id);
    List<User> listUsers(int maxRecords,int page);
    List<User> searchUsers(String name);
    int getRecords();
}
