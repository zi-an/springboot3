package spring.boot.web;

import com.github.javafaker.Faker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.database.UserEntity;
import spring.boot.database.UserMapper;

import java.util.List;
import java.util.Locale;

@RestController
public class UserController {
    Faker faker = new Faker(Locale.CHINA);
    @Resource
    UserMapper userMapper;

    @RequestMapping("/user/get")
    List<UserEntity> getUser() {
        return userMapper.getUsers();
    }

    @RequestMapping("/user/faker")
    UserEntity faker() {
        UserEntity user = new UserEntity(faker.name().lastName() + faker.name().firstName(),
                faker.code().ean13());
        userMapper.insertOne(user);
        return user;
    }


}
