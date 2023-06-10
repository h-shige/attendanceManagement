package com.example.ads.service;

import com.example.ads.model.LoginUser;
import com.example.ads.repository.LoginUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final LoginUserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = mapper.selectByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        User user = new User(loginUser.getUserName(), loginUser.getPassword(),
                AuthorityUtils.createAuthorityList(loginUser.getAuthorityName()));
        return user;
    }
}
