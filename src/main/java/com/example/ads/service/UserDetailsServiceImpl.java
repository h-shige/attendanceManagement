package com.example.ads.service;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import com.example.ads.repository.EmployeeInnerJoinAuthorityMapper;
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

    private final EmployeeInnerJoinAuthorityMapper mapper;

    @Override
    /**
     * 従業員コードでログイン認証
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeInnerJoinAuthority loginUser = mapper.selectByEmployeeCode(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        System.out.println(loginUser.toString());
        User user = new User(loginUser.getEmployeeCode(), loginUser.getPassword(),
                AuthorityUtils.createAuthorityList(loginUser.getAuthorityName()));
        return user;
    }
}
