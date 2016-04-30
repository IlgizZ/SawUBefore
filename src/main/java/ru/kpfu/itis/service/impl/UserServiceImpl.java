package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void findAllUsers(Double lat, Double lg, Date time, Long user_id) {
        //List<User> users = userRepository.findUserBy

    }

    @Override
    public List<User> findUsers(Date time, Long user_id) {
        return null;
    }

    @Override
    public List<User> findUsersByParams() {
        return null;
    }


}
