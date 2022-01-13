package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.dto.ResponseDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignUpDto;

public interface UserService {
    ResponseDto signUp(SignUpDto signUpDto);
}
