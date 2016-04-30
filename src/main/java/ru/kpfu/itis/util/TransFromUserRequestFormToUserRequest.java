package ru.kpfu.itis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.form.UserRequestForm;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.UserRequest;
import ru.kpfu.itis.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.function.Function;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Component
@Transactional
public class TransFromUserRequestFormToUserRequest implements Function<UserRequestForm, UserRequest> {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRequest apply(UserRequestForm userRequestForm) {
        UserRequest userRequest = new UserRequest();
        User user = userRepository.findOne(userRequestForm.getUserId());

        Point point = new Point();
        point.setLg(userRequestForm.getLg());
        point.setLat(userRequestForm.getLat());

        userRequest.setUser(user);
        userRequest.setPoint(point);
        userRequest.setTime(userRequestForm.getDate());

        return userRequest;
    }
}
