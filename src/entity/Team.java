package entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.round;

public class Team {
    // Team Information
    private final int id;
    private String name;
    private String nickname;
    private String code;
    private String city;
    private String logo;
    private String conference;
    private ArrayList<Player> players;

    // Wins/Losses
    private int wins;
    private int losses;
    private int winsPastTen;
    private int lossesPastTen;
    private int conferencePlace;

    // Team Statistics
    private int games;
    private int fastBreakPoints;
    private int pointsInPaint;
    private int secondChancePoints;
    private int pointsOffTurnovers;
    private int points;
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;
    private int freeThrowsMade;
    private int freeThrowsAttempted;
    private int threePointsMade;
    private int threePointsAttempted;
    private int offReb;
    private int defReb;
    private int assists;
    private int pFouls;
    private int steals;
    private int turnovers;
    private int blocks;
    private int plusMinus;


    public Team(int id, String name, String nickname, String code, String city, String logo, String conference, ArrayList<Player> players, int wins, int losses, int winsPastTen, int lossesPastTen, int conferencePlace, int games, int fastBreakPoints, int pointsInPaint, int secondChancePoints, int pointsOffTurnovers, int points, int fieldGoalsMade, int fieldGoalsAttempted, int freeThrowsMade, int freeThrowsAttempted, int threePointsMade, int threePointsAttempted, int offReb, int defReb, int assists, int pFouls, int steals, int turnovers, int blocks, int plusMinus) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.code = code;
        this.city = city;
        this.logo = logo;
        this.conference = conference;
        this.players = players;
        this.wins = wins;
        this.losses = losses;
        this.winsPastTen = winsPastTen;
        this.lossesPastTen = lossesPastTen;
        this.conferencePlace = conferencePlace;
        this.games = games;
        this.fastBreakPoints = fastBreakPoints;
        this.pointsInPaint = pointsInPaint;
        this.secondChancePoints = secondChancePoints;
        this.pointsOffTurnovers = pointsOffTurnovers;
        this.points = points;
        this.fieldGoalsMade = fieldGoalsMade;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.threePointsMade = threePointsMade;
        this.threePointsAttempted = threePointsAttempted;
        this.offReb = offReb;
        this.defReb = defReb;
        this.assists = assists;
        this.pFouls = pFouls;
        this.steals = steals;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.plusMinus = plusMinus;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", logo='" + logo + '\'' +
                ", conference='" + conference + '\'' +
                ", players=" + players +
                ", wins=" + wins +
                ", losses=" + losses +
                ", winsPastTen=" + winsPastTen +
                ", lossesPastTen=" + lossesPastTen +
                ", conferencePlace=" + conferencePlace +
                ", games=" + games +
                ", fastBreakPoints=" + fastBreakPoints +
                ", pointsInPaint=" + pointsInPaint +
                ", secondChancePoints=" + secondChancePoints +
                ", pointsOffTurnovers=" + pointsOffTurnovers +
                ", points=" + points +
                ", fieldGoalsMade=" + fieldGoalsMade +
                ", fieldGoalsAttempted=" + fieldGoalsAttempted +
                ", freeThrowsMade=" + freeThrowsMade +
                ", freeThrowsAttempted=" + freeThrowsAttempted +
                ", threePointsMade=" + threePointsMade +
                ", threePointsAttempted=" + threePointsAttempted +
                ", offReb=" + offReb +
                ", defReb=" + defReb +
                ", assists=" + assists +
                ", pFouls=" + pFouls +
                ", steals=" + steals +
                ", turnovers=" + turnovers +
                ", blocks=" + blocks +
                ", plusMinus=" + plusMinus +
                '}';
    }

    public Map<String, Object> toMap() {
        Map<String, Object> out = new HashMap<>();

        //General Info
        out.put("id", + id);
        out.put("name", name);
        out.put("nickname", nickname);
        out.put("code", code);
        out.put("city", city);
        out.put("logo", logo);
        out.put("conference", conference);
        out.put("players", players);

        //Stats
        out.put("wins", wins);
        out.put("losses", losses);
        out.put("winsPastTen", winsPastTen);
        out.put("lossesPastTen", lossesPastTen);
        out.put("conferencePlace", conferencePlace);
        out.put("games", games);
        out.put("fastBreakPoints", fastBreakPoints);
        out.put("pointsInPaint", pointsInPaint);
        out.put("secondChancePoints", secondChancePoints);
        out.put("pointsOffTurnovers", pointsOffTurnovers);
        out.put("points", points);
        out.put("fieldGoalsMade", fieldGoalsMade);
        out.put("fieldGoalsAttempted", fieldGoalsAttempted);
        out.put("freeThrowsMade", freeThrowsMade);
        out.put("freeThrowsAttempted", freeThrowsAttempted);
        out.put("threePointsMade", threePointsMade);
        out.put("threePointsAttempted", threePointsAttempted);
        out.put("offReb", offReb);
        out.put("defReb", defReb);
        out.put("assists", assists);
        out.put("pFouls", pFouls);
        out.put("steals", steals);
        out.put("turnovers", turnovers);
        out.put("blocks", blocks);
        out.put("plusMinus", plusMinus);

        // Per game metrics
        out.put("pointsPerGame", pointsPerGame());
        out.put("assistsPerGame", assistsPerGame());
        out.put("fieldGoalsMadePerGame", fieldGoalsMadePerGame());
        out.put("fieldGoalsAttemptedPerGame", fieldGoalsAttemptedPerGame());
        out.put("freeThrowsMadePerGame", freeThrowsMadePerGame());
        out.put("freeThrowsAttemptedPerGame", freeThrowsAttemptedPerGame());
        out.put("threePointsMadePerGame", threePointsMadePerGame());
        out.put("threePointsAttemptedPerGame", threePointsAttemptedPerGame());
        out.put("defensiveReboundsPerGame", defensiveReboundsPerGame());
        out.put("offensiveReboundsPerGame", offensiveReboundsPerGame());
        out.put("reboundsPerGame", reboundsPerGame());
        out.put("personalFoulsPerGame", personalFoulsPerGame());
        out.put("stealsPerGame", stealsPerGame());
        out.put("turnoversPerGame", turnoversPerGame());
        out.put("blocksPerGame", blocksPerGame());
        out.put("totalRebounds", totalRebounds());
        return out;
    }


    public void addStat(Team stat) {
        this.wins += stat.wins;
        this.losses += stat.losses;
        this.winsPastTen += stat.winsPastTen;
        this.lossesPastTen += stat.lossesPastTen;
        this.conferencePlace += stat.conferencePlace;
        this.games += stat.games;
        this.fastBreakPoints += stat.fastBreakPoints;
        this.pointsInPaint += stat.pointsInPaint;
        this.secondChancePoints += stat.secondChancePoints;
        this.pointsOffTurnovers += stat.pointsOffTurnovers;
        this.points += stat.points;
        this.fieldGoalsMade += stat.fieldGoalsMade;
        this.fieldGoalsAttempted += stat.fieldGoalsAttempted;
        this.freeThrowsMade += stat.freeThrowsMade;
        this.freeThrowsAttempted += stat.freeThrowsAttempted;
        this.threePointsMade += stat.threePointsMade;
        this.threePointsAttempted += stat.threePointsAttempted;
        this.offReb += stat.offReb;
        this.defReb += stat.defReb;
        this.assists += stat.assists;
        this.pFouls += stat.pFouls;
        this.steals += stat.steals;
        this.turnovers += stat.turnovers;
        this.blocks += stat.blocks;
        this.plusMinus += stat.plusMinus;
    }

    // TODO: Put in different file
    private double statPerGame(int stat){
        if (games != 0) {
           return roundTwoDecimals((double)stat/(double)games);
        } else {
            return 0.0;
        }
    }

    public double pointsPerGame() { return statPerGame(points);}
    public double assistsPerGame(){ return statPerGame(assists);}

    public double fieldGoalsMadePerGame() {return statPerGame(fieldGoalsMade); }
    public double fieldGoalsAttemptedPerGame() {return statPerGame(fieldGoalsAttempted); }

    public double freeThrowsMadePerGame() {return statPerGame(freeThrowsMade); }
    public double freeThrowsAttemptedPerGame() {return statPerGame(freeThrowsAttempted); }

    public double threePointsMadePerGame() {return statPerGame(threePointsMade); }
    public double threePointsAttemptedPerGame() {return statPerGame(threePointsAttempted); }

    public double defensiveReboundsPerGame() {return statPerGame(defReb); }

    public double offensiveReboundsPerGame() {return statPerGame(offReb); }

    public double reboundsPerGame(){ return statPerGame(totalRebounds());}

    public double personalFoulsPerGame(){ return statPerGame(pFouls); }

    public double stealsPerGame(){ return statPerGame(steals); }

    public double turnoversPerGame() {return statPerGame(turnovers); }

    public double blocksPerGame(){ return statPerGame(blocks);}

    public int totalRebounds(){ return defReb + offReb; }

    // TODO: Put in different file
    private double roundTwoDecimals(double num){
        DecimalFormat df = new DecimalFormat("#.##"); // Round double to 2 decimal places
        return Double.valueOf(df.format(num));
    }

    public double fieldGoalPercentage(){
        // Return 0% if the player has not attempted any field goals
        if (fieldGoalsAttempted != 0){
            return roundTwoDecimals((double)fieldGoalsMade/(double)fieldGoalsAttempted * 100);
        } else {
            return 0.0;
        }
    }

    public double freeThrowPercentage(){
        // Return 0% if the player has not attempted any free throws
        if (freeThrowsAttempted != 0){
            return roundTwoDecimals((double)freeThrowsMade/(double)freeThrowsAttempted * 100);
        } else {
            return 0.0;
        }
    }

    public double threePointPercentage(){
        // Return 0% if the player has not attempted any field goals
        if (threePointsAttempted != 0){
            return roundTwoDecimals((double)threePointsMade/(double)threePointsAttempted * 100);
        } else {
            return 0.0;
        }
    }


    public int getId() {
        return id;
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

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWinsPastTen() {
        return winsPastTen;
    }

    public void setWinsPastTen(int winsPastTen) {
        this.winsPastTen = winsPastTen;
    }

    public int getLossesPastTen() {
        return lossesPastTen;
    }

    public void setLossesPastTen(int lossesPastTen) {
        this.lossesPastTen = lossesPastTen;
    }

    public int getConferencePlace() {
        return conferencePlace;
    }

    public void setConferencePlace(int conferencePlace) {
        this.conferencePlace = conferencePlace;
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

    public int getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(int fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public int getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(int fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }

    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public int getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(int freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public int getThreePointsMade() {
        return threePointsMade;
    }

    public void setThreePointsMade(int threePointsMade) {
        this.threePointsMade = threePointsMade;
    }

    public int getThreePointsAttempted() {
        return threePointsAttempted;
    }

    public void setThreePointsAttempted(int threePointsAttempted) {
        this.threePointsAttempted = threePointsAttempted;
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
