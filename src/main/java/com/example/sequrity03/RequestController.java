package com.example.sequrity03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RequestController {
    @Autowired
     UserService userService;
    @Autowired
    JwtService jwtService;
    @PostMapping("/add")
    public String addUser(@RequestBody() UseEntity useEntity){
        userService.addUser(useEntity);
        return "Succussefully Added";
    }

    @PostMapping("/GetToken")
    public String  findUser(@RequestBody Authentication authentication) throws Exception{
      if( userService.findUserByNameAndPassord(authentication)!=null){
             return jwtService.generateToken(authentication.getUsername());
      }
      return "String Not Match";
    }


}
