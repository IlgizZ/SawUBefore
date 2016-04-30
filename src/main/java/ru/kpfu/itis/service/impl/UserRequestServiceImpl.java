package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.UserRequest;
import ru.kpfu.itis.repository.UserRequestRepository;
import ru.kpfu.itis.service.UserRequestService;

import static java.lang.Math.*;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public class UserRequestServiceImpl implements UserRequestService {
    @Autowired
    UserRequestRepository userRequestRepository;
    @Override
    public void saveUserRequest(UserRequest userRequest) {
        userRequestRepository.save(userRequest);
    }

    @Override
    public void findAndSend(UserRequest userRequest) {

    }

    /**
     * @param lan1 широта 1
     * @param lg1  долгота 1
     * @param lan2 широта 2
     * @param lg2  долгота 2
     * @return расстояние в метрах
     */
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
