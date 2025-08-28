package com.basicSecurity.SpringSecurityDemo.ServiceImpl;

import com.basicSecurity.SpringSecurityDemo.Model.User;
import com.basicSecurity.SpringSecurityDemo.Repository.UserRepository;
import com.basicSecurity.SpringSecurityDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User addedUser = userRepository.save(user);
        if(addedUser!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.deleteById(userId);
        return true;
    }
}
