package com.lalitbodana.sde.companywise.amazon.lld.splitwise.service;

import com.lalitbodana.sde.companywise.amazon.lld.splitwise.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<String, User> userMap = new HashMap<>();
    
    public void addUser(String email, String username, String phone) {
        User user = new User(email, username, phone);
        userMap.put(username, user);
    }
    
    public Map<String, User> getUserMap() {
        return userMap;
    }
}
