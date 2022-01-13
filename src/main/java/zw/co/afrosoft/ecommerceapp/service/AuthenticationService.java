package zw.co.afrosoft.ecommerceapp.service;

import zw.co.afrosoft.ecommerceapp.model.AuthenticationToken;

public interface AuthenticationService {
    void saveConfimationToken(AuthenticationToken authenticationToken);
}
