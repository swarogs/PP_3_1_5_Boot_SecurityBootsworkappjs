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
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public DBInit(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void run() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleService.save(adminRole);
        roleService.save(userRole);

        userService.save(new User("Anastasiya", "1234", "nast@gmail.com", Set.of(adminRole)));

        userService.save(new User("Veronika", "4321", "swar@gmail.com", Set.of(userRole)));


    }
}
