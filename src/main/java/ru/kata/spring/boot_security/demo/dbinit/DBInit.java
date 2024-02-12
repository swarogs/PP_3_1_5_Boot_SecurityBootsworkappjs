package ru.kata.spring.boot_security.demo.dbinit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DBInit {
    private UserServiceImpl userService;
    private RoleServiceImpl roleService;

    @Autowired
    public DBInit(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void run() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleService.addRole(adminRole);
        roleService.addRole(userRole);

        userService.addUser(new User("Anastasiya", "Votikova", "anastas", "1234", Set.of(adminRole)));

        userService.addUser(new User("Veronika", "Nikishina", "vernik", "102030", Set.of(userRole)));


    }
}
