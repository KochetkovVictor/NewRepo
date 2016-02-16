package su.pos.sevice;

import su.pos.domain.User;

import java.util.List;

/**
 * Created by Kochetkov_V on 04.02.2016.
 */

public interface UserDAO {
    User getUser(int id);
    void setUser(User user);
    List<User> getUsers(int page, int count);
    List<User> getAll();
    void removeUser(User user);
    void editUser(User user);
    List<User> findByName(String name);
    List<User> findPagedByName(String name,int page, int count);
}