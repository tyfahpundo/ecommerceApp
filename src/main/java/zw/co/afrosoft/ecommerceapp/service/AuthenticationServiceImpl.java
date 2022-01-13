package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.exceptions.AuthenticationFailException;
import zw.co.afrosoft.ecommerceapp.model.AuthenticationToken;
import zw.co.afrosoft.ecommerceapp.model.User;
import zw.co.afrosoft.ecommerceapp.repository.AuthenticationTokenRepository;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private final AuthenticationTokenRepository tokenRepository;

    public AuthenticationServiceImpl(AuthenticationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void saveConfimationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    @Override
    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    @Override
    public void authenticate(String token) {
        //null check
        if(Objects.isNull(token)){
            throw new AuthenticationFailException("Token not Present!");
        }
        if(Objects.isNull(getUser(token))){
            throw new AuthenticationFailException("Token Not Valid!");
        }
    }

    @Override
    public User getUser(String token) {
        final AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
        if(Objects.isNull(token)){
            return null;
        }
        return authenticationToken.getUser();
    }
}
