package io.ashwin.springboot.request;

public class TeamInfo {

	String id;
	String teamName;
	String manager;
	String stadium;
	String location;
	String teamSponsor;
	String teamKitSponsor;
	String matchPlayed;
	String wins;
	String losses;
	String goals;
	String goalsConceded;
	String cleanSheets;
	public String getMatchPlayed() {
		return matchPlayed;
	}
	public void setMatchPlayed(String matchPlayed) {
		this.matchPlayed = matchPlayed;
	}
	public String getWins() {
		return wins;
	}
	public void setWins(String wins) {
		this.wins = wins;
	}
	public String getLosses() {
		return losses;
	}
	public void setLosses(String losses) {
		this.losses = losses;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getGoalsConceded() {
		return goalsConceded;
	}
	public void setGoalsConceded(String goalsConceded) {
		this.goalsConceded = goalsConceded;
	}
	public String getCleanSheets() {
		return cleanSheets;
	}
	public void setCleanSheets(String cleanSheets) {
		this.cleanSheets = cleanSheets;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeamSponsor() {
		return teamSponsor;
	}
	public void setTeamSponsor(String teamSponsor) {
		this.teamSponsor = teamSponsor;
	}
	public String getTeamKitSponsor() {
		return teamKitSponsor;
	}
	public void setTeamKitSponsor(String teamKitSponsor) {
		this.teamKitSponsor = teamKitSponsor;
	}
	
}
