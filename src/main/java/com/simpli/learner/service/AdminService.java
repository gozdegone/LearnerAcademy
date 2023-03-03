package com.simpli.learner.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService {

  @Value("${admin.username}")
  private String username;

  @Value("${admin.password}")
  private String password;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    if (name.equals(username)) {
      List<GrantedAuthority> authorities = new ArrayList<>();
      SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
      authorities.add(authority);
      User user = new User(username, password, authorities);
      return user;
    }
    return null;
  }
}
