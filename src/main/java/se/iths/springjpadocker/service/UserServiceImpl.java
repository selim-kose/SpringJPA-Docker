package se.iths.springjpadocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.springjpadocker.entity.User;
import se.iths.springjpadocker.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public User getUser(Long id) {
       Optional<User> student = userRepository.findById(id);
       if (student.isPresent()) {
           return student.get();
       }
       return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> userToChange = userRepository.findById(id);
        if(userToChange.isPresent()){
            User unwrappedUser = userToChange.get();
            unwrappedUser.setName(user.getName());
            unwrappedUser.setEmail(user.getEmail());
            return userRepository.save(unwrappedUser);
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
