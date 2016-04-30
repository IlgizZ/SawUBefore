package ru.kpfu.itis.util;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;

import javax.transaction.Transactional;
import java.util.function.Function;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Component
@Transactional
public class TransformUserFormToUser implements Function<UserForm, User> {

    @Override
    public User apply(UserForm userForm) {
        User user = new User();
        user.setLogin(userForm.getLogin());
        user.setPassword(userForm.getPassword());
        user.setSex(userForm.getSex());
        user.setUrl(userForm.getUrl());
        return user;
    }
}
