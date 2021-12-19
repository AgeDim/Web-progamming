package web.Lab3.backend;

import web.Lab3.bean.Interim;
import web.Lab3.data.Data;

public interface IValidation {
    boolean validateX(Interim data);
    boolean validateY(Interim data);
    boolean validateR(Interim data);
}
