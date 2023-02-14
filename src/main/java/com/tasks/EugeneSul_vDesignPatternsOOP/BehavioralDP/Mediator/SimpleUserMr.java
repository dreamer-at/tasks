package com.tasks.EugeneSul_vDesignPatternsOOP.BehavioralDP.Mediator;

public class SimpleUserMr implements UserMr{
    ChatMr chat;
    String name;

    public SimpleUserMr(ChatMr chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public ChatMr getChat() {
        return chat;
    }

    public void setChat(ChatMr chat) {
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message: " + message + ".");
    }
}
