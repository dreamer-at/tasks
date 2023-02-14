package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Mediator;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextChatMr implements ChatMr{
    UserMr admin;
    List<UserMr> userList = new ArrayList<>();

    public void setAdmin(UserMr admin) {
        this.admin = admin;
    }

    public void addUserToChat(UserMr user){
        this.userList.add(user);
    }

    @Override
    public void sendMessage(String message, UserMr user) {
        for (UserMr u : userList) {
            if (u != user) {
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}
