package se.iths.springjpadocker.service;

import se.iths.springjpadocker.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);
    void deleteUser(Long id);
    User saveUser(User user);
    User updateUser(User user, Long id);
    List<User> getUsers();
}
