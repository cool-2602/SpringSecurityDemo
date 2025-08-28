package com.basicSecurity.SpringSecurityDemo.Controller;

import com.basicSecurity.SpringSecurityDemo.Model.User;
import com.basicSecurity.SpringSecurityDemo.Service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Transactional
    @PostMapping("/admin/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        System.out.println(user);
        boolean isAdded = userService.addUser(user);
        if(isAdded){
            return ResponseEntity.ok("User Added Successfully...");
        }
        return ResponseEntity.badRequest().body("Failed to Add User..");
    }

    @GetMapping("/home")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok("Application is running fine....");
    }

    @GetMapping("/user/by-id/{userId}")
    public ResponseEntity<?> getUser(@PathVariable long userId){
        User userById = userService.getUserById(userId);
        if(userById==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found!");
        }
        return ResponseEntity.ok(userById);
    }

    @GetMapping("/admin/get-users")
    public ResponseEntity<?> getAll(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/admin/delete-user/{userId}")
    public ResponseEntity<String> delete(@PathVariable long userId){
        boolean isDeleted = userService.deleteUser(userId);
        if(isDeleted){
            return ResponseEntity.ok("User Deleted Successfully");
        }
        return ResponseEntity.ok("Failed to Delete User");
    }


}
