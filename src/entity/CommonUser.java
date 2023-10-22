package entity;

import java.util.ArrayList;

public class CommonUser implements User {

    String username;
    String password;
    ArrayList<League> memberLeagues;

    CommonUser(String name, String password, ArrayList<League> memberLeagues) {
        this.username = name;
        this.password = password;
        this.memberLeagues = memberLeagues;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void setUserName() {
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword() {
    }

    @Override
    public ArrayList<League> getMemberLeagues() {
        return null;
    }

    @Override
    public void setMemberLeagues() {
    }
}
