package com.vladcarcu.socialloginexample.extension;

import com.vladcarcu.sociallogin.SocialLoginAdapter;
import com.vladcarcu.sociallogin.SocialLoginAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class CustomSocialAdapter implements SocialLoginAdapter {
    private final String TYPE = "custom";

    @Override
    public boolean isApplicable(String type) {
        return TYPE.equals(type);
    }

    @Override
    public SocialLoginAuthenticationToken validateLogin(String token) {
        // here is where the validation logic goes
        // in our case, we just allow everything to go through
        SocialLoginAuthenticationToken result = new SocialLoginAuthenticationToken(token);
        result.setAuthenticated(true);
        return result;
    }
}
