package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.form.PointForm;
import ru.kpfu.itis.form.UserRequestForm;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.model.Push;
import ru.kpfu.itis.model.UserRequest;
import ru.kpfu.itis.repository.PushRepository;
import ru.kpfu.itis.service.PointService;
import ru.kpfu.itis.service.UserRequestService;
import ru.kpfu.itis.util.TransFromUserRequestFormToUserRequest;
import ru.kpfu.itis.util.TransformPoinFomToPoint;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    TransformPoinFomToPoint transformPoinFomToPoint;

    @Autowired
    TransFromUserRequestFormToUserRequest transFromUserRequestFormToUserRequest;

    @Autowired
    UserRequestService userRequestService;

    @Autowired
    PushRepository pushRepository;

    @Autowired
    PointService pointService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public List<Push> saveGeolocation(@ModelAttribute PointForm pointForm) {
        Point point = transformPoinFomToPoint.apply(pointForm);
        pointService.savePoint(point);
        return pushRepository.findNotReadPush(pointForm.getUserId());
    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.POST)
    @ResponseBody
    public void findAllUsers(@ModelAttribute UserRequestForm userRequestForm) {
        UserRequest userRequest = transFromUserRequestFormToUserRequest.apply(userRequestForm);
        userRequestService.saveUserRequest(userRequest);
        userRequestService.findAndSend(userRequest);
    }
}
