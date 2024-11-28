package com.sw24.clinicaapp.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class Usuario<T extends Persona> implements UserDetails {

    private T persona;
    private String usuario;
    private String password;

    public Usuario() {}

    public Usuario(T persona, String usuario, String password) {
        if (!(persona instanceof Medico) && !(persona instanceof Recepcionista)) {
            throw new IllegalArgumentException("El usuario debe ser un Medico o Recepcionista");
        }
        this.persona = persona;
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (persona instanceof Medico) {
            return List.of(new SimpleGrantedAuthority("ROLE_MEDICO"));
        } else if (persona instanceof Recepcionista) {
            return List.of(new SimpleGrantedAuthority("ROLE_RECEPCIONISTA"));
        } else {
            return List.of();
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}