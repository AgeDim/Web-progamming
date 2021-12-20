package web.Lab3.bean;

import web.Lab3.backend.CheckArea;
import web.Lab3.backend.Validation;
import web.Lab3.data.Data;
import web.Lab3.data.History;
import web.Lab3.entity.Result;
import web.Lab3.services.ResultService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Named("hitresBean")
@ApplicationScoped
public class HitBean implements Serializable {
    long startTime = System.nanoTime();
    private int pointer5 = 0;
    private int pointer2 = 0;
    private int isPointer = 0;
    private final History history;
    private final Validation validation;
    private final CheckArea checkArea;
    private Result newResult = new Result();
    private Result clickResult = new Result();
    private final ResultService resultService = new ResultService();
    private List<Result> resultList = new ArrayList<Result>(resultService.findAllResults());

    public HitBean(){
        history = new History();
        validation = new Validation();
        checkArea = new CheckArea();
        x = 0f;
    }

    private Float x;
    private String y;
    private String r;


    private boolean correctX = false;
    private boolean correctY = false;
    private boolean correctR = false;


    public List<Result> getResults(){
        resultList = resultService.findAllResults();
        return resultList;
    }

    public void addResult() {
        if (newResult.getX() != null && newResult.getY() != null && newResult.getR() != null) {
            if (validation.validateX(newResult)) {
                try {
                    makeResult(newResult);
                    resultService.addResult(newResult);
                    saveSubmitValues(newResult.getX(), newResult.getY(), newResult.getR());
                } catch (Exception exception) {
                    System.out.println("Database is dead...");
                }
            }
        } else {
            System.out.println("NullPointer here");
            System.out.println(newResult);
        }
    }

    public void deleteList() {
        try {
            resultService.deleteAll();
            resultList.clear();
        } catch (Exception exception) {
            System.out.println("Database is dead...");
        }
    }

    public void defaultResult() {
        newResult.setX(null);
        newResult.setY(null);
        newResult.setR(null);
        clickResult.setX(null);
        clickResult.setY(null);
        clickResult.setR(null);
    }

    public void setNewR(Float r) {
        newResult.setR(r);
        clickResult.setR(r);
        if (r == 5) this.pointer5 = 1;
        else this.pointer5 = 0;
        if (r == 2) this.pointer2 = 0;
        else this.pointer2 = 1;
        if (r == 0) this.isPointer = 0;
        else this.isPointer = 1;
    }

    public void update() {
        try {
            resultList = resultService.findAllResults();
        } catch (Exception exception) {
            System.out.println("Database is dead...");
        }
    }

    public void addCheck() {
        if (clickResult.getX() != null && clickResult.getY() != null) addClick();
        else addResult();
    }

    public void saveSubmitValues(Float x, Float y, Float r) {
        newResult = new Result();
        newResult.setX(x);
        newResult.setY(y);
        newResult.setR(r);
    }

    public void coordinatesToValues(Result result) {
        result.setX((float) (((result.getR() * (result.getX() - 175) / 135.0) / 1.2) * 4.0 / result.getR()));
        result.setY((float) (((result.getR() * (175 - result.getY()) / 135.0) / 1.2) * 4.0 / result.getR()));
    }

    public void addClick() {
        clickResult.setR(newResult.getR());
        if (validation.validateR(clickResult)) {
            try {
                coordinatesToValues(clickResult);
                makeResult(clickResult);
                resultService.addResult(clickResult);
                clickResult = new Result();
                saveSubmitValues(newResult.getX(), newResult.getY(), newResult.getR());
            } catch (Exception exception) {
                System.out.println("Database is dead...");
            }
        } else {
            System.out.println("NullPointer here");
            System.out.println(newResult);
        }
    }

    public void makeResult(Result result) {
        result.setCurrentTime(new TimeBean().getTime());
        long start = System.nanoTime();
        result.setResult(new CheckArea().hit(result.getX(),result.getY(),result.getR()));
        result.setExecutionTime(String.valueOf((System.nanoTime() - start) / 1000));
    }
    public List<Data> getHistory(){
        return history.getHistory();
    }


    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public boolean getCorrectX() {
        return correctX;
    }

    public boolean getCorrectY() {
        return correctY;
    }
}