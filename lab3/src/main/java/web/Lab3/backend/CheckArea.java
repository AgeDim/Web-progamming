package web.Lab3.backend;

import java.io.Serializable;

public class CheckArea implements ICheckArea, Serializable {
    @Override
    public boolean hit(double x, double y, double r) {
        if (y >= 0){
            if (x >= 0){
                return (x <= r/2 && y<= r);
            } else {
                return false;
            }
        } else {
            if (x >= 0) {
                return (y > (x/2) - (r/2));
            } else {
                return (x*x+y*y<r*r);
            }
        }
    }
}
