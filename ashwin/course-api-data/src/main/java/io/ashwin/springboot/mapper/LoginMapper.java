package io.ashwin.springboot.mapper;

import io.ashwin.springboot.request.SignUpRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			SignUpRequest c = new SignUpRequest();
			c.setFullName(rs.getString("full_name"));
			c.setEmail(rs.getString("email"));
			c.setUserName(rs.getString("user_name"));
			c.setPassword(rs.getString("password"));
			c.setRepeatPassword(rs.getString("repeat_password"));
			c.setId(rs.getString("id"));
			c.setAddress(rs.getString("address"));
			c.setCountry(rs.getString("country"));
			c.setState(rs.getString("state"));
			c.setCity(rs.getString("city"));
			c.setZipCode(rs.getString("zipcode"));
			return c;
		}
}
