package zw.co.afrosoft.ecommerceapp.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.ecommerceapp.model.AuthenticationToken;
import zw.co.afrosoft.ecommerceapp.repository.AuthenticationTokenRepository;

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
}
