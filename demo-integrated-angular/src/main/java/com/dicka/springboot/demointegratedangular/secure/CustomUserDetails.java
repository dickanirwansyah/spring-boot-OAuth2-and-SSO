package com.dicka.springboot.demointegratedangular.secure;

import com.dicka.springboot.demointegratedangular.entity.entity_oauth.Roles;
import com.dicka.springboot.demointegratedangular.entity.entity_oauth.Users;
import com.dicka.springboot.demointegratedangular.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomUserDetails implements UserDetailsService{

    private final Logger log = LoggerFactory.getLogger(CustomUserDetails.class);

    @Autowired
    private UsersRepository usersRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        log.debug("Authentication {}", login);
        String lowercaseLogin = login.toLowerCase();

        Users usersDatabase;
        if(lowercaseLogin.contains("@")){
            usersDatabase = usersRepository.findByEmail(lowercaseLogin);
        }else{
            usersDatabase = usersRepository.findByUsernameCaseInsensitive(lowercaseLogin);
        }

        if(usersDatabase == null){
            throw new UsernameNotFoundException("User "+lowercaseLogin+" was not found in the database !");
        }else if(!usersDatabase.isActivated()){
            throw new UsernameNotFoundException("User "+lowercaseLogin+" is not active");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Roles roles : usersDatabase.getRolesList()){
            GrantedAuthority grantRole = new SimpleGrantedAuthority(roles.getName());
            grantedAuthorities.add(grantRole);
        }

        return new User(usersDatabase.getUsername(),usersDatabase.getPassword(), grantedAuthorities);
    }
}
