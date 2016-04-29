package ru.kpfu.itis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.form.GeolocationForm;
import ru.kpfu.itis.model.Geolocation;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.repository.UserRepository;

import java.util.function.Function;

@Component
public class TransformGeolocationFomToGeolocation implements Function<GeolocationForm, Geolocation> {


    @Autowired
    UserRepository userRepository;

    @Override
    public Geolocation apply(GeolocationForm geolocationForm) {
        Geolocation geolocation = userRepository.findOne(geolocationForm.getUserId()).getGeolocations();
        Point point = new Point();
        point.setLg(geolocationForm.getLg());
        point.setLat(geolocationForm.getLat());
        geolocation.getPoint().add(point);
        return geolocation;
    }
}
