package com.api.curd.service.impl;

import com.api.curd.dto.UserDto;
import com.api.curd.entity.User;
import com.api.curd.exceptions.EmailAlreadyExistException;
import com.api.curd.exceptions.ResourceNotFountException;
import com.api.curd.reposiroty.UserRepository;
import com.api.curd.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

//        User userJpa = UserMapper.mapToUser(userDto);
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistException("User Email already exist");
        }
        User userJpa = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(userJpa);

//        UserDto savedUserDto =  UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFountException("user", "id", userId.toString())
        );
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach((user) -> userDtos.add(modelMapper.map(user, UserDto.class)));
        return userDtos;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFountException("user", "id",user.getId().toString())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setEmail(user.getEmail());
        existingUser.setLastName(user.getLastName());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId){

        User existingUser = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFountException("user", "id",userId.toString())
        );
        userRepository.deleteById(userId);
    }


}
