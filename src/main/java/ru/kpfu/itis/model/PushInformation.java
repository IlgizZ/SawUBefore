package ru.kpfu.itis.model;

/**
 * Created by Ilgiz on 30.04.2016.
 */
public class PushInformation {
    private Params requestParams;
    private String userUrl;
    private Point point;

    public Params getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Params requestParams) {
        this.requestParams = requestParams;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
