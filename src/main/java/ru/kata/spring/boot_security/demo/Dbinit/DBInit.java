package ru.kata.spring.boot_security.demo.Dbinit;


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

        userService.addUser(new User("Anastasiya", "Votikova", "anastas", "$2a$10$nOfZFe84aXdvi599cUraOuP7wCszxrF161qPz1WwTxL65A/FlZolq", Set.of(adminRole)));

        userService.addUser(new User("Veronika", "Nikishina", "vernik", "$2a$10$XbSWcIyrf5EBdhX0EF5L6.H4EAJlatDxJrZKd49eJ32M83gZuV9Ki", Set.of(userRole)));


    }
}
