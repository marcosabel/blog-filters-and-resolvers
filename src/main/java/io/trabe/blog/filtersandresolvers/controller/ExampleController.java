package io.trabe.blog.filtersandresolvers.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.trabe.blog.filtersandresolvers.model.pojo.ContextInformation;
import io.trabe.blog.filtersandresolvers.model.pojo.UserInformation;

@RestController
@RequestMapping("/api")
public class ExampleController {


    @GetMapping("/context")
    public ContextInformation getApplicationContext(ContextInformation contextInformation) {
        return contextInformation;
    }

    @GetMapping("/user")
    public UserInformation getApplicationContext(UserInformation userInformation) {
        return userInformation;
    }

    @GetMapping("/context-and-user")
    public Map<String, Object> getApplicationContext(UserInformation userInformation,
            ContextInformation contextInformation) {
        Map<String, Object> map = new HashMap<>();
        map.put("userInformation", userInformation);
        map.put("contextInformation", contextInformation);
        return map;
    }
}
