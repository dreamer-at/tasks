package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Mediator;

public class SimpleChatRunnerMr {
    public static void main(String[] args) {
        SimpleTextChatMr chat = new SimpleTextChatMr();

        UserMr admin = new AdminMr(chat, "Admin");
        UserMr user1 = new SimpleUserMr(chat, "User1");
        UserMr user2 = new SimpleUserMr(chat, "User2");

        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);

        user1.sendMessage("Hello, I am User 1!!!");
        admin.sendMessage("Roger that. Iam admin...");
    }

}
