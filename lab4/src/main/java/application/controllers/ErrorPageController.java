package application.controllers;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class ErrorPageController extends AbstractErrorController {
    static final String ERROR_PATH = "/error";

    public ErrorPageController(final ErrorAttributes errorAttributes) {
        super(errorAttributes, Collections.emptyList());
    }

    @RequestMapping(ERROR_PATH)
    public String error() {
        return "forward:/";
    }
}
