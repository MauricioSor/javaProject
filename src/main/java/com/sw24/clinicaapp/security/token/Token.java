package com.sw24.clinicaapp.security.token;

public class Token {
    private final String token;
    private boolean isValid;

    public Token(String token) {
        this.token = token;
        this.isValid = true;
    }

    public String getToken() {
        return token;
    }

    public boolean isValid() {
        return isValid;
    }

    public void invalidate() {
        this.isValid = false;
    }
}