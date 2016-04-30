package ru.kpfu.itis.service;

import ru.kpfu.itis.model.UserRequest;

/**
 * Created by Ilgiz on 30.04.2016.
 */
public interface UserRequestService {
    public void saveUserRequest(UserRequest userRequest);
    public void findAndSend(UserRequest userRequest);
}
