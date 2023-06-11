package com.example.ads.repository;

import com.example.ads.model.Authority;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AuthorityMapper {

    Authority selectByCode(String code);
}
