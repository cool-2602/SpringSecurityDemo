package com.basicSecurity.SpringSecurityDemo.ServiceImpl;

import com.basicSecurity.SpringSecurityDemo.Model.User;
import com.basicSecurity.SpringSecurityDemo.Security.UserPrinciple;
import com.basicSecurity.SpringSecurityDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        UserPrinciple userPrinciple = new UserPrinciple(user);
        return userPrinciple;
    }
}
