package entity;

import java.util.ArrayList;


public class Team {
    // Team Information
    private final int id;
    private String name;
    private String nickname;
    private String code;
    private String city;
    private String logo;
    private ArrayList<Player> players;

    // Team Statistics
    private int games;
    private int fastBreakPoints;
    private int pointsInPaint;
    private int secondChancePoints;
    private int pointsOffTurnovers;
    private int points;
    private int fgm;
    private int fga;
    private int ftm;
    private int fta;
    private int tpm;
    private int tpa;
    private int offReb;
    private int defReb;
    private int assists;
    private int pFouls;
    private int steals;
    private int turnovers;
    private int blocks;
    private int plusMinus;


    public Team(int id, String name, String nickname, String code, String city, String logo, ArrayList<Player> players, int games, int fastBreakPoints, int pointsInPaint, int secondChancePoints, int pointsOffTurnovers, int points, int fgm, int fga, int ftm, int fta, int tpm, int tpa, int offReb, int defReb, int assists, int pFouls, int steals, int turnovers, int blocks, int plusMinus) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.code = code;
        this.city = city;
        this.logo = logo;
        this.players = players;
        this.games = games;
        this.fastBreakPoints = fastBreakPoints;
        this.pointsInPaint = pointsInPaint;
        this.secondChancePoints = secondChancePoints;
        this.pointsOffTurnovers = pointsOffTurnovers;
        this.points = points;
        this.fgm = fgm;
        this.fga = fga;
        this.ftm = ftm;
        this.fta = fta;
        this.tpm = tpm;
        this.tpa = tpa;
        this.offReb = offReb;
        this.defReb = defReb;
        this.assists = assists;
        this.pFouls = pFouls;
        this.steals = steals;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.plusMinus = plusMinus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getFastBreakPoints() {
        return fastBreakPoints;
    }

    public void setFastBreakPoints(int fastBreakPoints) {
        this.fastBreakPoints = fastBreakPoints;
    }

    public int getPointsInPaint() {
        return pointsInPaint;
    }

    public void setPointsInPaint(int pointsInPaint) {
        this.pointsInPaint = pointsInPaint;
    }

    public int getSecondChancePoints() {
        return secondChancePoints;
    }

    public void setSecondChancePoints(int secondChancePoints) {
        this.secondChancePoints = secondChancePoints;
    }

    public int getPointsOffTurnovers() {
        return pointsOffTurnovers;
    }

    public void setPointsOffTurnovers(int pointsOffTurnovers) {
        this.pointsOffTurnovers = pointsOffTurnovers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public int getTpm() {
        return tpm;
    }

    public void setTpm(int tpm) {
        this.tpm = tpm;
    }

    public int getTpa() {
        return tpa;
    }

    public void setTpa(int tpa) {
        this.tpa = tpa;
    }

    public int getOffReb() {
        return offReb;
    }

    public void setOffReb(int offReb) {
        this.offReb = offReb;
    }

    public int getDefReb() {
        return defReb;
    }

    public void setDefReb(int defReb) {
        this.defReb = defReb;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getpFouls() {
        return pFouls;
    }

    public void setpFouls(int pFouls) {
        this.pFouls = pFouls;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(int plusMinus) {
        this.plusMinus = plusMinus;
    }
}
