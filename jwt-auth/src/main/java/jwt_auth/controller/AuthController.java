package jwt_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jwt_auth.entity.User;
import jwt_auth.repository.UserRepository;
import jwt_auth.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser =
                repo.findByUsername(user.getUsername())
                        .orElseThrow();

        if (dbUser.getPassword()
                .equals(user.getPassword())) {

            return jwtUtil.generateToken(
                    dbUser.getUsername(),
                    dbUser.getRole());
        }

        return "Invalid Credentials";
    }
}