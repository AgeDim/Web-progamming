package web.Lab3.backend;

import java.io.Serializable;
import web.Lab3.entity.Result;

public class Validation implements IValidation, Serializable {
    @Override
    public boolean validateX(Result data) {
        boolean res = true;
        if (data.getX() >4){
            if(data.getX()<-4){
             res = false;
            }
        }
        return res;
    }


    @Override
    public boolean validateY(Result data) {
        boolean res = true;
        float resY = Float.parseFloat(String.valueOf(data.getY()));
        if (resY >5){
            if(resY<-3){
                res = false;
            }
        }
        return res;
    }

    @Override
    public boolean validateR(Result data) {
        boolean res = true;
        float resR = Float.parseFloat(String.valueOf(data.getR()));
        if (resR >4){
            if(resR<1){
                res = false;
            }
        }
        return res;
    }
}