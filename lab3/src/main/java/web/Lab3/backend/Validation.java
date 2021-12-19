package web.Lab3.backend;

import java.io.Serializable;
import web.Lab3.bean.Interim;

public class Validation implements IValidation, Serializable {
    @Override
    public boolean validateX(Interim data) {
        boolean res = true;
        if (data.getX() >4){
            if(data.getX()<-4){
             res = false;
            }
        }
        return res;
    }


    @Override
    public boolean validateY(Interim data) {
        boolean res = true;
        if (data.getY() >5){
            if(data.getY()<-3){
                res = false;
            }
        }
        return res;
    }

    @Override
    public boolean validateR(Interim data) {
        boolean res = true;
        if (data.getR() >4){
            if(data.getR()<1){
                res = false;
            }
        }
        return res;
    }
}