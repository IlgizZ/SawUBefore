package ru.kpfu.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.services.UserService;

import java.util.Date;
import java.util.List;

import static java.lang.Math.*;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void findAllUsers(Double lat, Double lg, Date time, Long user_id) {
        //List<User> users = userRepository.findUserBy
    }

    @Override
    public List<User> findUsers(Date time, Long user_id) {
        return null;
    }

    private double calculateDistance(double lan1, double lg1, double lan2, double lg2) {
        lan1 = 55.865203 * PI / 180; //широта
        lg1 = 49.082148 * PI / 180;
        lan2 = 55.863903 * PI / 180; //долгота
        lg2 = 49.087373 * PI / 180;
        double distance;
        double radius = 6372795;
        double signm; // угловая разница
        double dl = lg2 - lg1;
        signm = atan(sqrt(pow(cos(lan2) * sin(dl), 2)
                + pow(cos(lan1) * sin(lan2) - sin(lan1) * cos(lan2) * cos(dl), 2))
                / (sin(lan1) * sin(lan2) + cos(lan1) * cos(lan2) * cos(dl)));
        distance = signm * radius;
        return distance;
    }
}
