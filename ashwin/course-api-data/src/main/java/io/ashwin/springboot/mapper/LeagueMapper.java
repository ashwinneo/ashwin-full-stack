package io.ashwin.springboot.mapper;

import io.ashwin.springboot.request.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LeagueMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			Topic c = new Topic();			
			c.setLeague(rs.getString("league"));
			// TODO Auto-generated method stub
			return c;
		}
}
