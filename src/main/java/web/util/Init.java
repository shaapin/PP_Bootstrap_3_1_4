package web.util;

import web.model.Role;
import web.service.UserService;
import web.model.User;
import web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);


        User admin = new User("Admin", "Admin", 29, "admin@mail.ru", "admin",
                "admin", adminSet);
        User user = new User("User", "User", 32, "user@mail.com", "user",
                "user", userSet);
        User user1 = new User("Нурхаят", "User", 24, "hayat@mail.com", "user1",
                "user1", userSet);
        User user2 = new User("Оксана", "User", 28, "user@mail.com", "user2",
                "user2", userSet);
        User user3 = new User("Михаил", "User", 31, "user@mail.com", "user3",
                "user3", userSet);
        User user4 = new User("Федор", "User", 55, "user@mail.com", "user4",
                "user4", userSet);

        userService.saveUser(user);
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(admin);
    }
}
