package com.dicka.springboot.demointegratedangular.secure;

import org.springframework.security.core.AuthenticationException;

public class UsersNotActivatedException extends AuthenticationException{

    public UsersNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public UsersNotActivatedException(String msg) {
        super(msg);
    }
}
