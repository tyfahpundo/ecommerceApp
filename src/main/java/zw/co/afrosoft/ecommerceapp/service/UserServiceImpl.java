package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.dto.ResponseDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignInDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignInResponseDto;
import zw.co.afrosoft.ecommerceapp.dto.user.SignUpDto;
import zw.co.afrosoft.ecommerceapp.exceptions.AuthenticationFailException;
import zw.co.afrosoft.ecommerceapp.exceptions.CustomException;
import zw.co.afrosoft.ecommerceapp.model.AuthenticationToken;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.repository.UserRepository;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public UserServiceImpl(UserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    @Transactional
    public ResponseDto signUp(SignUpDto signUpDto) {
        //check if email already in use
        if(Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))){
            throw new CustomException("user already present with the same emailId!");
        }
        //hash the password
        String encryptedPassword = signUpDto.getPassword();
        try{
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //save the user
        User user = new User();
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(encryptedPassword);
        userRepository.save(user);

        //create the token
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfimationToken(authenticationToken);


        ResponseDto responseDto = new ResponseDto("success","User Created Successfully!!!");
        return responseDto;
    }

    @Override
    public SignInResponseDto signin(SignInDto signInDto) {
        //find user by email
        User user = userRepository.findByEmail(signInDto.getEmail());
        if(Objects.isNull(user)){
            throw new AuthenticationFailException("Invalid username or password, please try again!");
        }
        //hash the password and compare with the one in DB
        try {
            if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                throw new AuthenticationFailException("Invalid username or password, please try again!");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //retrieve token
        AuthenticationToken token = authenticationService.getToken(user);
        if(Objects.isNull(token)){
            throw new CustomException("Token is not present");
        }

        return new SignInResponseDto("success",token.getToken());

    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }
}
