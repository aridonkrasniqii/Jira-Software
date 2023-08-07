package io.jira.domain.user.mappers;

import io.jira.domain.user.dtos.CreateUser;
import io.jira.domain.user.dtos.UpdateUser;
import io.jira.domain.user.models.User;

public class UserMapper {

    public static User mapToUser(CreateUser createUser) {
        User user = new User();
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setPosition(createUser.getPosition());
        user.setEmail(createUser.getEmail());
        user.setPosition(createUser.getPosition());
        // here you can hash password
        user.setHashedPassword(createUser.getPassword());
        user.setActive(createUser.isActive());
        return  user;
    }

    public static User mapToUser(UpdateUser updateUser) {
        User user = new User();
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPosition(updateUser.getPosition());
        user.setEmail(updateUser.getEmail());
        user.setPosition(updateUser.getPosition());
        // here you can hash password
        user.setHashedPassword(updateUser.getPassword());
        user.setActive(updateUser.isActive());
        return user;
    }
}
