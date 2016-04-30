package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public interface UserService {
    void findAllUsers(Double lat, Double lg, Date time, Long user_id);

    void save(User user);

    List<User> findUsers(Date time, Long user_id);

    List<User> findUsersByParams(String string);
}
