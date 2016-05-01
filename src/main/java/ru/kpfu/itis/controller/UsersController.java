package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.form.PointForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.form.UserRequestForm;
import ru.kpfu.itis.model.*;
import ru.kpfu.itis.repository.PushRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.PointService;
import ru.kpfu.itis.service.UserRequestService;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.TransFromUserRequestFormToUserRequest;
import ru.kpfu.itis.util.TransformPoinFomToPoint;
import ru.kpfu.itis.util.TransformUserFormToUser;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    TransformUserFormToUser transformUserFormToUser;

    @Autowired
    TransformPoinFomToPoint transformPoinFomToPoint;

    @Autowired
    TransFromUserRequestFormToUserRequest transFromUserRequestFormToUserRequest;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserRequestService userRequestService;

    @Autowired
    PushRepository pushRepository;

    @Autowired
    PointService pointService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<PushInformation> saveGeolocation(@ModelAttribute PointForm pointForm) {
        Point point = transformPoinFomToPoint.apply(pointForm);
        pointService.savePoint(point);
        List<Push> pushes = pushRepository.findNotReadPush(pointForm.getUserId());
        List<PushInformation> info = new ArrayList();
        pushes.forEach(push -> {
            push.setIsRead(true);
            pushRepository.save(push);
            PushInformation pushInformation = new PushInformation();
            pushInformation.setRequestParams(push.getUserRequestId().getParams());
            pushInformation.setUserUrl(push.getFromUserId().getUrl());
            pushInformation.setPoint(point);
            info.add(pushInformation);
        });

        return info;
    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.POST)
    @ResponseBody
    public void findAllUsers(@ModelAttribute UserRequestForm userRequestForm) {
        UserRequest userRequest = transFromUserRequestFormToUserRequest.apply(userRequestForm);
        userRequestService.saveUserRequest(userRequest);
        userRequestService.findAndSend(userRequest);
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    @ResponseBody
    public Long registration(@ModelAttribute UserForm userForm) {
        User user = transformUserFormToUser.apply(userForm);
        userService.save(user);
        return user.getId();
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    @ResponseBody
    public User login(@ModelAttribute UserForm userForm) {
        User user = transformUserFormToUser.apply(userForm);
        User userFromDB = userRepository.findOneByLogin(user.getLogin());
        if (userFromDB != null && user.getPassword().equals(userFromDB.getPassword())) {
            return userFromDB;
        }
        user.setId(-1);
        return user;
    }

}
