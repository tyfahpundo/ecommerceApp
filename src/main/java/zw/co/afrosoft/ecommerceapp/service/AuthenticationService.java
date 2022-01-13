package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.model.AuthenticationToken;
import zw.co.afrosoft.ecommerceapp.model.User;

public interface AuthenticationService {

    void saveConfimationToken(AuthenticationToken authenticationToken);

    AuthenticationToken getToken(User user);

    void authenticate(String token);

    User getUser(String token);
}
