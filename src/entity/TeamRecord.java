package entity;

public class TeamRecord {
    public int wins;
    public int losses;
    public int winsPastTen;
    public int lossesPastTen;
    public int conferencePlace;

    public TeamRecord(int wins, int losses, int winsPastTen, int lossesPastTen, int conferencePlace) {
        this.wins = wins;
        this.losses = losses;
        this.winsPastTen = winsPastTen;
        this.lossesPastTen = lossesPastTen;
        this.conferencePlace = conferencePlace;
    }
}
