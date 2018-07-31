package io.ashwin.springboot.mapper;

import io.ashwin.springboot.request.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TopicMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			Topic c = new Topic();

			c.setId(rs.getString("ID"));
			c.setName(rs.getString("Name"));
			c.setManager(rs.getString("Manager"));
			c.setCountry(rs.getString("Country"));
			c.setLeague(rs.getString("league"));
			// TODO Auto-generated method stub
			return c;
		}
}
