package io.ashwin.springboot.mapper;

import io.ashwin.springboot.request.TeamSquad;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeamSquadMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		TeamSquad c = new TeamSquad();
		c.setId(rs.getInt("id"));
		c.setPlayerName(rs.getString("player_name"));
		c.setKitNumber(rs.getString("kit_number"));
		c.setPosition(rs.getString("position"));
		c.setCountry(rs.getString("country"));
		c.setTeamName(rs.getString("team_name"));
		return c;
	}
}
