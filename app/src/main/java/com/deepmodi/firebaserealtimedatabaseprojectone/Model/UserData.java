package com.deepmodi.firebaserealtimedatabaseprojectone.Model;

public class UserData {

    private String UserName;
    private String UserSurname;
    private String UserNumber;

    public UserData() {
    }

    public UserData(String userName, String userSurname, String userNumber) {
        UserName = userName;
        UserSurname = userSurname;
        UserNumber = userNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSurname() {
        return UserSurname;
    }

    public void setUserSurname(String userSurname) {
        UserSurname = userSurname;
    }

    public String getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(String userNumber) {
        UserNumber = userNumber;
    }
}
