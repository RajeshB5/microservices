package com.api.curd.mapper;

import com.api.curd.dto.UserDto;
import com.api.curd.entity.User;

public class UserMapper {

    // Convert user JPA to user DTO
    public static UserDto mapToUserDto(User user){
        UserDto userDto =  new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        // Convert user DTO to user JPA Entity
        User userJpa = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
        return userJpa;
    }
}
