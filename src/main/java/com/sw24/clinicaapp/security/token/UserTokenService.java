package com.sw24.clinicaapp.security.token;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserTokenService {
    private final Map<String, List<Token>> userTokens = new ConcurrentHashMap<>();

    public void addToken(String username, String token) {
        userTokens.computeIfAbsent(username, k -> new ArrayList<>()).add(new Token(token));
    }

    public void invalidateTokens(String username) {
        List<Token> tokens = userTokens.get(username);
        if (tokens != null) {
            tokens.forEach(Token::invalidate);
        }
    }

    public List<String> getValidTokens(String username) {
        return userTokens.getOrDefault(username, List.of()).stream()
                .filter(Token::isValid)
                .map(Token::getToken)
                .collect(Collectors.toList());
    }

    public boolean isValidUserToken(String username, String token) {
        var tokens = userTokens.get(username);
        return tokens != null && tokens.stream().anyMatch(t -> t.getToken().equals(token) && t.isValid());
    }
}