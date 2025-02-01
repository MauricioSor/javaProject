package com.sw24.clinicaapp.security.auth;

import com.sw24.clinicaapp.entity.Usuario;
import com.sw24.clinicaapp.security.jwt.JwtService;
import com.sw24.clinicaapp.security.token.UserTokenService;
import com.sw24.clinicaapp.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioService usuarioService;
    private final UserTokenService userTokenService;

    public AuthenticationService(AuthenticationManager authenticationManager, JwtService jwtService, UsuarioService usuarioService, UserTokenService userTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
        this.userTokenService = userTokenService;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsuario(),
                            request.getPassword()
                    )
            );

            Usuario<?> user = (Usuario<?>) authentication.getPrincipal();
            String role = user.getAuthorities().stream().findFirst()
                    .map(authority -> authority.getAuthority().replace("ROLE_", ""))
                    .orElse("");

            String token = jwtService.generateToken(user);
            userTokenService.addToken(user.getUsername(), token);

            log.info("Usuario {} ha iniciado sesión exitosamente", user.getUsername());

            return AuthenticationResponse.builder()
                    .mensaje("Login exitoso")
                    .token(token)
                    .role(role)
                    .build();
        } catch (Exception e) {
            log.error("Error en el login para el usuario {}: {}", request.getUsuario(), e.getMessage());
            throw e;
        }
    }

    public void register(RegisterRequest request) {
        usuarioService.crearUsuario(request);
        log.info("Nuevo usuario registrado.");
    }

    public void logout(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            String username = jwtService.extractUsername(jwt);

            userTokenService.invalidateTokens(username);

            log.info("Usuario {} ha cerrado sesión y sus tokens han sido invalidados", username);
        } else {
            log.warn("Intento de logout con token inválido");
            throw new IllegalArgumentException("Intento de logout con token inválido");
        }
    }
}