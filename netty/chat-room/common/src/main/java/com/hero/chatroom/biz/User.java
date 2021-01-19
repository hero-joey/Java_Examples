package com.hero.chatroom.biz;

/**
 * @description: User
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */
public class User {
    private String userId;
    private String deviceId;
    private String token;
    private String nickName;
    private PlatForm platform;

    public User() {

    }

    private enum PlatForm {
        WINDOWS, MAC, ANDROID, IOS, WEB, OTHER;
    }

    public void setPlatform(int platform) {
        PlatForm[] values = PlatForm.values();
        for (PlatForm value : values) {
            if (value.ordinal() == platform) {
                this.platform = value;
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", token='" + token + '\'' +
                ", nickName='" + nickName + '\'' +
                ", platform=" + platform +
                '}';
    }

    public User parseUserFromMsg(ProtoMsg.LoginRequest loginRequest) {
        User user = new User();
        user.userId = loginRequest.getUid();
        user.deviceId = loginRequest.getDeviceId();
        user.token = loginRequest.getToken();
        user.setPlatform(loginRequest.getPlatform());
        return user;
    }
}
