package com.example.ads.repository;

import com.example.ads.model.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityMapper {

    Authority selectByCode(String code);
}
