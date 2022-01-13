package zw.co.afrosoft.ecommerceapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.ecommerceapp.dto.ResponseDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignInDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignInResponseDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignUpDto;
import zw.co.afrosoft.ecommerceapp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //signup
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }
    //signin
    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto){
        return userService.signin(signInDto);
    }
}
