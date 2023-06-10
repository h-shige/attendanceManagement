package com.example.ads.repository;

import com.example.ads.model.SiteUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface SiteUserMapper {
    Optional<SiteUser> selectByUserName(String userName);
}