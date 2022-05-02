package com.adrianpoplesanu.MatchDay2.utils.activation;

import org.springframework.stereotype.Component;

@Component
public class ActivationManager {
    public boolean checkCode(String code) {
        return "sumudica".equals(code.toLowerCase());
    }
}
