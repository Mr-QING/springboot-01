package com.zznode.controller;

import com.zznode.repository.UserJpa;
import com.zznode.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by asus on 2018/3/22.
 */
@RestController
public class UserInfoController {
    @Autowired
    public UserJpa userJpa;

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public UserInfo get(@PathVariable("id")Integer id){
        //springboot2.0以后不能直接findByid()
        return userJpa.findById(id).get();
    }

    /**
     * 查询所有列表
     * @return
     */
    @GetMapping("/getall")
    public List<UserInfo> findAll(){
        return  userJpa.findAll();
    }

    /**
     * 新增一条
     * @param
     * @return
     */
    @PostMapping("/add")
    public UserInfo adduser(@Valid UserInfo userInfo, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result.getFieldError().getDefaultMessage());
        }


        return userJpa.save(userInfo);
    }

    /**
     * 通过id更新
     * @param id
     * @param name
     * @param nationality
     * @return
     */
    @PutMapping("/update/{id}")
    public UserInfo update(@PathVariable("id")Integer id, @RequestParam("name")String name, @RequestParam("nationality")String nationality){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(name);
        userInfo.setNationality(nationality);
       return userJpa.save(userInfo);
    }

    /**
     * 通过id删除
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
         userJpa.deleteById(id);
    }
}
