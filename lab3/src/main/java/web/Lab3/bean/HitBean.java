package web.Lab3.bean;

import web.Lab3.backend.CheckArea;
import web.Lab3.backend.Validation;
import web.Lab3.data.Data;
import web.Lab3.data.History;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "hitresBean")
@ApplicationScoped
public class HitBean implements Serializable {
    long startTime = System.nanoTime();
    private final History history;
    private final Validation validation;
    private final CheckArea checkArea;
    public HitBean() {
        history = new History();
        validation = new Validation();
        checkArea = new CheckArea();
        x = 0F;
    }
    private Float x;
    private Float y;
    private Float r;

    public void submit() {
    Interim interim = new Interim(x,y,r);
    boolean numX = validation.validateX(interim);
    boolean numY = validation.validateY(interim);
    boolean numR = validation.validateR(interim);
            if (numX & numY & numR) {
                Data result = new Data(x, y, r, new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime()), String.valueOf((System.nanoTime() - startTime) * Math.pow(10, -9)), checkArea.hit(x, y, r));
                history.addData(result);
            }
    }

    public List<Data> getHistory() {
        return history.getHistory();
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
}
