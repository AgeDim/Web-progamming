package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = "*")
public class FallbackController {
    @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.GET}, path = {"/main", "/auth", "/"})
    private String forwardVuePaths() {
        return "forward:/index.html";
    }
}