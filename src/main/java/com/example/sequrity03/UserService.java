package com.example.sequrity03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private Repository repository;
    public void addUser(UseEntity useEntity){
        repository.save(useEntity);
    }
    public UseEntity findUserByNameAndPassord(Authentication authentication) throws Exception{
        String  name=authentication.getUsername();
        String password=authentication.getPassword();
        List<UseEntity> list=repository.findAll();
        UseEntity user=null;
        for(UseEntity userEntity:list){
            if(name.equals(userEntity.getName()) && password.equals(userEntity.getPassword()))
                 user= userEntity;
        }
        if(user==null)
             throw new Exception("not Match");
        return user;
    }
}
