package com.example.ads.repository;

import com.example.ads.model.LoginUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface LoginUserMapper {
    Optional<LoginUser> selectByUserName(String userName);
}