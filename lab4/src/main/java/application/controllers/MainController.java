package application.controllers;

import application.dto.PointRequest;
import application.entities.Point;
import application.entities.User;
import application.repositories.PointRepository;
import application.repositories.UserRepository;
import application.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/api/points")
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping(value = "/get", produces = {MediaType.APPLICATION_JSON_VALUE})
    private ResponseEntity<?> getPoints(HttpServletRequest req) {
        String token = jwtUtils.getTokenFromRequest(req);
        if (token != null  && jwtUtils.validateToken(token)) {
            User user = userRepository.getUserByUsername(jwtUtils.getUsernameFromToken(token));
            if (user != null) {
                return ResponseEntity.ok().body(pointRepository.getAllByUsername(user.getUsername()));
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping(value = "/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    private ResponseEntity<?> addPoint(@RequestBody PointRequest pointRequest, HttpServletRequest req) {
        long startTime = System.nanoTime();
        String token = jwtUtils.getTokenFromRequest(req);
        if (token != null && jwtUtils.validateToken(token)) {
            User user = userRepository.getUserByUsername(jwtUtils.getUsernameFromToken(token));
            if (user != null) {
                double x = pointRequest.getX();
                double y = pointRequest.getY();
                double r = pointRequest.getR();
                boolean isInArea = pointIsInTriangle(x, y, r) || pointIsInCircle(x, y, r) || pointIsInRectangle(x, y, r);
                String exec = String.format("%8.7f", (System.nanoTime() - startTime) * Math.pow(10, -9)).replace(',','.');
                Point point = new Point(x, y, r, isInArea, exec, user.getUsername());
                pointRepository.save(point);
                return ResponseEntity.ok("");
            }
            return new ResponseEntity<>("User not found", HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>("Your authorization token is invalid. Please, login again!", HttpStatus.FORBIDDEN);
        }
    }

    private boolean pointIsInTriangle(double x, double y, double r) {
        if(r == 0){return false;}
        if (r > 0) {
            return (y <= r / 2 - x / 2) && (y >= 0) && (x >= 0);
        }
        return (y >= r / 2 - x / 2) && (y <= 0) && (x <= 0);
    }

    private boolean pointIsInCircle(double x, double y, double r) {
        if(r == 0){return false;}
        if (r > 0) {
            return (x * x + y * y <= r * r / 4) && (y <= 0) && (x >= 0);
        }
        return (x * x + y * y <= r * r / 4) && (y >= 0) && (x <= 0);
    }

    private boolean pointIsInRectangle(double x, double y, double r) {
        if(r == 0){return false;}
        if (r > 0) {
            return (y <= r) && (x >= -r/2) && (x <= 0) && (y >= 0);
        }
        return (y >= r) && (y <= 0) && (x <= -r/2) && (x >= 0);
    }
}