package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.model.Push;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.UserRequest;
import ru.kpfu.itis.repository.PushRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.repository.UserRequestRepository;
import ru.kpfu.itis.service.UserRequestService;
import ru.kpfu.itis.service.UserService;

import java.util.List;

import static java.lang.Math.*;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public class UserRequestServiceImpl implements UserRequestService {
    private static final double distanceRadius = 500;
    private static final double e = 10E-10;
    private static final long timeInterval = 30 * 60 * 1000;
    @Autowired
    UserRequestRepository userRequestRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    PushRepository pushRepository;

    @Override
    public void saveUserRequest(UserRequest userRequest) {
        userRequestRepository.save(userRequest);
    }

    @Override
    public void findAndSend(UserRequest userRequest) {
        List<User> users = userService.findUsersByParams(userRequest.getParams().getSex());
        Point requsetPoint = userRequest.getPoint();
        for (User user : users) {
            for (Point point : user.getPoints()) {
                long requestTime = userRequest.getTime().getTime();
                long userTime = point.getDate().getTime();
                if ((Math.abs(requestTime - userTime) < timeInterval) &&
                        calculateDistance(requsetPoint.getLat(), requsetPoint.getLg(),
                                point.getLat(), point.getLg()) - distanceRadius < e) {
                    Push push = new Push();
                    push.setFromUserId(user);
                    push.setUserRequestId(userRequest);
                    pushRepository.save(push);
                }
            }
        }
//        users.forEach(user -> {
//
//            user.getPoints().forEach(point -> {
//                long requestTime = userRequest.getTime().getTime();
//                long userTime = point.getDate().getTime();
//                if ((Math.abs(requestTime - userTime) < timeInterval) &&
//                        calculateDistance(requsetPoint.getLat(), requsetPoint.getLg(),
//                                point.getLat(), point.getLg()) - distanceRadius < e) {
//                    Push push = new Push();
//                    push.setFromUserId(user);
//                    push.setUserRequestId(userRequest);
//                    pushRepository.save(push);
//                }
//            });
//
//        });
    }

    /**
     * @param lat1 широта 1
     * @param lg1  долгота 1
     * @param lat2 широта 2
     * @param lg2  долгота 2
     * @return расстояние в метрах
     */
    private double calculateDistance(double lat1, double lg1, double lat2, double lg2) {
        lat1 *= PI / 180; //широта
        lg1 *= PI / 180;
        lat2 *= PI / 180; //долгота
        lg2 *= PI / 180;
        double distance;
        double radius = 6372795;
        double signm; // угловая разница
        double dl = lg2 - lg1;
        signm = atan(sqrt(pow(cos(lat2) * sin(dl), 2)
                + pow(cos(lat1) * sin(lat2) - sin(lat1) * cos(lat2) * cos(dl), 2))
                / (sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(dl)));
        distance = signm * radius;
        return distance;
    }
}
