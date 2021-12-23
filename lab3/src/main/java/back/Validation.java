package back;

import beans.HitBean;

import java.io.Serializable;

public class Validation implements IValidation, Serializable {
    @Override
    public Float validateX(String x) {
        Float doubleX = null;
        try {
            doubleX = Float.parseFloat(x);
            if (doubleX > 4 && doubleX < -4) {
                doubleX = null;
                HitBean.errorX = new Error("Поле должно быть от -2 до 2.");
            }
        } catch (NumberFormatException exception) {
            HitBean.errorX = new Error("Поле X должно быть числом.");
        } catch (NullPointerException exception) {
            HitBean.errorX = new Error("Поле X не введено.");
        }
        if (doubleX != null) {
            HitBean.errorX = new Error("");
        }
        return doubleX;
    }

    @Override
    public Float validateY(String y) {
        Float doubleY = null;
        try {
            doubleY = Float.parseFloat(y);
            if(doubleY == null){
                HitBean.errorY = new Error("Поле Y не введено.");
            }
            if (doubleY > 5 && doubleY < -3) {
                doubleY = null;
                HitBean.errorY = new Error("Поле должно быть от -3 до 5.");
            }
        } catch (NumberFormatException exception) {
            if (y.equals("")) {
                HitBean.errorY = new Error("Поле Y не введено.");
            } else {
                HitBean.errorY = new Error("Поле Y должно быть числом.");
            }
        } catch (NullPointerException ignored) {}
        if (doubleY != null) {
            HitBean.errorY = new Error("");
        }
        return doubleY;
    }

    @Override
    public Float validateR(String r) {
        Float intR = null;
        try {
            intR = Float.parseFloat(r);
            if (intR > 4 && intR < 1) {
                intR = null;
                HitBean.errorR = new Error("Поле должно быть от 1 до 4.");
            }
        } catch (NumberFormatException exception) {
            HitBean.errorR = new Error("Поле R должно быть числом.");
        } catch (NullPointerException exception) {
            HitBean.errorR = new Error("Поле R не введено.");
        }
        if (intR != null) {
            HitBean.errorR = new Error("");
        }
        return intR;
    }
}
