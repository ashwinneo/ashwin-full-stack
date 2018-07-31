package io.ashwin.springboot.mapper;

import io.ashwin.springboot.request.TeamInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeamInfoMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			TeamInfo c = new TeamInfo();
			c.setId(rs.getString("ID"));
			c.setTeamName(rs.getString("teamName"));
			c.setManager(rs.getString("manager"));
			c.setStadium(rs.getString("stadium"));
			c.setLocation(rs.getString("location"));
			c.setTeamSponsor(rs.getString("teamSponsor"));
			c.setTeamKitSponsor(rs.getString("teamKitSponsor"));
			c.setMatchPlayed(rs.getString("matchPlayed"));
			c.setWins(rs.getString("wins"));
			c.setLosses(rs.getString("losses"));
			c.setGoals(rs.getString("goals"));
			c.setGoalsConceded(rs.getString("goalsConceded"));
			c.setCleanSheets(rs.getString("cleanSheets"));
			c.setCrosses(rs.getInt("passes"));
			c.setPasses(rs.getInt("crosses"));
			c.setPassesPerMatch(rs.getFloat("passes_per_match"));
			c.setFoul(rs.getInt("foul"));
			c.setOffsides(rs.getInt("offsides"));
			c.setYellowCards(rs.getInt("yellow_cards"));
			c.setRedCards(rs.getInt("red_cards"));
			c.setTotalGoals(rs.getInt("totalGoals"));
			c.setGoalsPerMatch(rs.getFloat("goal_per_match"));
			c.setShots(rs.getInt("shots"));
			c.setShotsOnTarget(rs.getInt("shots_on_target"));
			c.setPenaltiesScored(rs.getInt("penalties_scored"));
			c.setBigChancesCreated(rs.getInt("big_chances_created"));
			c.setHitWoodWork(rs.getInt("hit_woodwork"));
			c.setTotalCleanSheets(rs.getInt("clean_sheets"));
			c.setTotalGoalsConceded(rs.getInt("total_goals_conceded"));
			c.setGoalsConcededPerMatch(rs.getFloat("total_goals_conceded_per_match"));
			c.setSaves(rs.getInt("saves"));
			c.setTackles(rs.getInt("tackles"));
			c.setBlockedShots(rs.getInt("blocked_shots"));
			c.setInterceptions(rs.getInt("interception"));
			c.setClearances(rs.getInt("clearance"));
			c.setHeadedClearances(rs.getInt("headed_clearance"));
			c.setAreilBattlesWon(rs.getInt("aerial_battles"));
			c.setErrorsLeadingtoGoal(rs.getInt("errors_leading"));
			c.setOwnGoals(rs.getInt("own_goals"));
			return c;
		}
}
