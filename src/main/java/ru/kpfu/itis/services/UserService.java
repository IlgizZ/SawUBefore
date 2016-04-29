package ru.kpfu.itis.services;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public interface UserService {
    void findUser(Double lat, Double lg, Date time, Long user_id);

    List<User> findUsers(Date time, Long user_id);
}
