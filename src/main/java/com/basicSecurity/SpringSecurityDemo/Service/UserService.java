package com.basicSecurity.SpringSecurityDemo.Service;

import com.basicSecurity.SpringSecurityDemo.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean addUser(User user);
    User getUserById(long userId);
    List<User> getAllUser();
    boolean deleteUser(long userId);

}
