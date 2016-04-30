package ru.kpfu.itis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.form.PointForm;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Function;

@Component
@Transactional
public class TransformPoinFomToPoint implements Function<PointForm, Point> {


    @Autowired
    UserRepository userRepository;

    @Override
    public Point apply(PointForm pointForm) {
        User user = userRepository.findOne(pointForm.getUserId());
        Point point = new Point();
        point.setUser(user);
        point.setLg(pointForm.getLg());
        point.setLat(pointForm.getLat());
        point.setLat(pointForm.getLat());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            point.setDate(formatter.parse(pointForm.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return point;
    }
}
