package web.Lab3.data;

import java.io.Serializable;

public class Data implements Serializable {
    private Float x;
    private Float y;
    private Float r;
    private String currentTime;
    private String executeTime;
    private boolean result;

    public Data(Float x, Float y, Float r, String currentTime, String executeTime, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.executeTime = executeTime;
        this.result = result;
    }


    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
