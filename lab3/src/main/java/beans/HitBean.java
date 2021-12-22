package beans;

import back.CheckArea;
import back.Validation;
import database.dao.ResultDAO;
import entity.Result;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Named("hitresBean")
@ApplicationScoped
public class HitBean implements Serializable {
    private final Validation validation;
    private final CheckArea checkArea;
    private final ResultDAO resultDAO;


    public HitBean(){
        validation = new Validation();
        checkArea = new CheckArea();
        resultDAO = new ResultDAO();
        resultDAO.initializeTable();
        x = "0";
    }

    private String x;
    private String y;
    private String r;

    public static Error errorX = new Error("");
    public static Error errorY = new Error("");
    public static Error errorR = new Error("");

    private boolean correctX = false;
    private boolean correctY = false;
    private boolean correctR = false;

    public void submit(){
        long start = System.nanoTime();

        Float numericalX = validation.validateX(x);
        Float numericalY = validation.validateY(y);
        Float numericalR = validation.validateR(r);

        correctX = (numericalX != null);
        correctY = (numericalY != null);
        correctR = (numericalR != null);

        if (correctX && correctY && correctR){
            Result result = new Result();
            result.setX(numericalX.floatValue());
            result.setY(numericalY.floatValue());
            result.setR(numericalR);
            result.setCurrentTime(new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime()));
            result.setExecuteTime((System.nanoTime() - start)/1000);
            result.setResult(checkArea.hit(numericalX, numericalY, numericalR));
            resultDAO.addResult(result);
        } 
    }

    public List<Result> getHistory(){
        return  resultDAO.getResult();
    }


    public String getX() {
        return x;
    }

    public void setX(String x) {
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

    public Object getErrorR() {
        return errorR;
    }

    public Object getErrorY() {
        return errorY;
    }

    public Object getErrorX() {
        return errorX;
    }
}
