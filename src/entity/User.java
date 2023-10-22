package entity;

import java.util.ArrayList;

//Todo

public interface User {
    String getUserName();

    void setUserName();

    String getPassword();

    void setPassword();

    ArrayList<League> getMemberLeagues();

    void setMemberLeagues();
}
