package com.zznode.repository;

import com.zznode.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by asus on 2018/3/23.
 */
@Repository
public interface UserJpa extends JpaRepository<UserInfo,Integer> {

}
