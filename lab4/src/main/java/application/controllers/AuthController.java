package application.controllers;

import application.dto.AuthRequest;
import application.entities.User;
import application.repositories.UserRepository;
import application.security.Hasher;
import application.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(value="/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    private ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        User user = userRepository.getUserByUsername(authRequest.getUsername());
        if (user == null) {
            return new ResponseEntity<>("0:There is no user with such username!", HttpStatus.NOT_FOUND);
        } else if (!Hasher.encryptMD5(authRequest.getPassword()).equals(user.getPassword())) {
            return new ResponseEntity<>("1:Wrong password!", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(jwtUtils.generateToken(authRequest.getUsername()));
        }
    }

    @PostMapping(value="/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    private ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
        User user = userRepository.getUserByUsername(authRequest.getUsername());
        if (user == null) {
            userRepository.save(new User(authRequest.getUsername(), Hasher.encryptMD5(authRequest.getPassword())));
            return ResponseEntity.ok(jwtUtils.generateToken(authRequest.getUsername()));
        } else {
            return new ResponseEntity<>("0:That username is already in use!", HttpStatus.NOT_FOUND);
        }
    }
}
