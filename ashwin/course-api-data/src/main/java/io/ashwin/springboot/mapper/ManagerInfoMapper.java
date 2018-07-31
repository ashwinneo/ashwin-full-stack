package io.ashwin.springboot.mapper;

import io.ashwin.springboot.request.ManagerInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ManagerInfoMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			ManagerInfo c = new ManagerInfo();
			c.setId(rs.getString("id"));
			c.setName(rs.getString("name"));
			c.setCountry(rs.getString("country"));
			c.setJoinedDate(rs.getString("joinDate"));
			c.setAge(rs.getString("age"));
			c.setDob(rs.getDate("dob"));
			c.setSeasons(rs.getString("seasons"));
			c.setMatches(rs.getString("matches"));
			c.setWins(rs.getString("wins"));
			c.setDraws(rs.getString("draws"));
			c.setLosses(rs.getString("losses"));
			c.setGf(rs.getString("gf"));
			c.setGa(rs.getString("ga"));			
			return c;
		}
}
