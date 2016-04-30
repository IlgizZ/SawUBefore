package ru.kpfu.itis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.form.UserRequestForm;
import ru.kpfu.itis.model.Params;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.UserRequest;
import ru.kpfu.itis.repository.UserRepository;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        Params params = new Params();
        params.setBottomColor(userRequestForm.getBottomcolor());
        params.setTopColor(userRequestForm.getTopcolor());
        params.setColor(userRequestForm.getColor());
        params.setSex(userRequestForm.getSex());
        params.setRequest(userRequest);

        Point point = new Point();
        point.setLg(userRequestForm.getLg());
        point.setLat(userRequestForm.getLat());

        userRequest.setUser(user);
        userRequest.setPoint(point);
        userRequest.setParams(params);

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            userRequest.setTime(formatter.parse(userRequestForm.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return userRequest;
    }
}
