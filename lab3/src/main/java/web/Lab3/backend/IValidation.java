package web.Lab3.backend;

import web.Lab3.entity.Result;

public interface IValidation {
    boolean validateX(Result data);
    boolean validateY(Result data);
    boolean validateR(Result data);
}
