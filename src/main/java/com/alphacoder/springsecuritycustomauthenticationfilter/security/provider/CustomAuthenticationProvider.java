package com.alphacoder.springsecuritycustomauthenticationfilter.security.provider;

import com.alphacoder.springsecuritycustomauthenticationfilter.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${user.security.key}")
    private String authKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authKey.equals(authentication.getName())){
            var result= new CustomAuthentication(null, null, null);
            return result;
        }else{
            throw new BadCredentialsException("User not authorized");
        }
    }

    @Override
    public boolean supports(Class<?> authType) {
        return CustomAuthentication.class.equals(authType);
    }
}
