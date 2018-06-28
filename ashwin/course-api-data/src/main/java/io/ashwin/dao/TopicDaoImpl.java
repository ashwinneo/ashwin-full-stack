package io.ashwin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.ashwin.springboot.response.ErrorResponse;
import io.ashwin.springboot.response.TopicResponse;
import io.ashwin.springboot.topic.SignUpRequest;
import io.ashwin.springboot.topic.TeamInfo;
import io.ashwin.springboot.topic.Topic;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TopicDaoImpl implements TopicDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Object getTopicById(String league, String name) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM LEAGUES WHERE LEAGUE=? OR NAME=?";
		try {
//			Topic t = (Topic) jdbcTemplate.queryForObject(query,
//					new Object[] { league }, new TopicMapper());
			Object league1 = jdbcTemplate.query(
					query,new Object[] { league, name }, new TopicMapper());

			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("League Successfully Fetched");
			topicResp.setLeagueResponse(league1);
			return topicResp;
			// return topics;
		} catch (Exception e) {

			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("No Data Found!");
			return errorResponse;

		}
	}

	public Object getTopics() {

		String query = "SELECT * FROM LEAGUES";
		try {
			ArrayList<Topic> topics1 = (ArrayList<Topic>) jdbcTemplate.query(
					query, new TopicMapper());
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("Leagues Successfully Fetched");
			topicResp.setLeagueResponse(topics1);
			return topicResp;
		} catch (Exception e) {

			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("No Data Found!");
			return errorResponse;

		}
	}

	public Object addTopic(Topic topic) {
		
		String query = "INSERT INTO LEAGUES (NAME,MANAGER,COUNTRY,LEAGUE) VALUES (?,?,?,?)";
		//return null;
		int count = jdbcTemplate.update(query, topic.getName(),
				topic.getManager(),topic.getCountry(),topic.getLeague());
		if (count == 1) {
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("League Successfully Added");
			topicResp.setLeagueResponse(topic.getId());
			return topicResp;
		} else {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while adding");
			return errorResponse;
		}
	}

	public Object updateTopic(Topic topic, String id) {
		String query = "UPDATE LEAGUES SET name=? , manager=? , country=? , league=? where ID=?";
		
		int count = jdbcTemplate.update(query, topic.getName(),
				topic.getManager(),topic.getCountry(),topic.getLeague(),topic.getId());

		if (count == 1) {
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("League Successfully Updated");
			topicResp.setLeagueResponse(topic.getId());
			return topicResp;
		} else {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while adding");
			return errorResponse;
		}
	}

	public Object deleteTopic(String id) {

		String query = "DELETE FROM LEAGUES WHERE ID=?";
		int count = jdbcTemplate.update(query, new Object[] { id });
		if (count == 1) {
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("League Successfully Deleted");
			topicResp.setLeagueResponse(id);
			return topicResp;
		}
		return null;
	}

	private static final class TopicMapper implements RowMapper {

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
	
	private static final class TeamInfoMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			TeamInfo c = new TeamInfo();

			c.setId(rs.getString("ID"));
			c.setTeamName(rs.getString("teamName"));
			c.setManager(rs.getString("manager"));
			c.setStadium(rs.getString("stadium"));
			c.setLocation(rs.getString("location"));
			c.setTeamSponsor(rs.getString("teamSponsor"));
			c.setTeamKitSponsor(rs.getString("teamKitSponsor"));
			return c;
		}

	}
	
	private static final class LoginMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			SignUpRequest c = new SignUpRequest();

			c.setFullName(rs.getString("full_name"));
			c.setEmail(rs.getString("email"));
			c.setUserName(rs.getString("user_name"));
			c.setPassword(rs.getString("password"));
			c.setRepeatPassword(rs.getString("repeat_password"));
			return c;
		}

	}

	@Override
	public Object getTeamInfo(String name) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM TEAM_INFO WHERE TEAMNAME = ?";
		try {
//			Topic t = (Topic) jdbcTemplate.queryForObject(query,
//					new Object[] { league }, new TopicMapper());
			Object league1 = jdbcTemplate.query(
					query,new Object[] { name }, new TeamInfoMapper());
			System.out.println(league1);
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("Team Infomation Successfully Fetched");
			topicResp.setLeagueResponse(league1);
			return topicResp;
			// return topics;
		} catch (Exception e) {

			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("No Data Found!");
			return errorResponse;

		}
	}
	
	public Object registerAccount(SignUpRequest signUpRequest){
		
		String query = "INSERT INTO USER (FULL_NAME,EMAIL,USER_NAME,PASSWORD,REPEAT_PASSWORD) VALUES (?,?,?,?,?)";
		
		int count = jdbcTemplate.update(query, signUpRequest.getFullName(),signUpRequest.getEmail()
				,signUpRequest.getUserName(),signUpRequest.getPassword()
				,signUpRequest.getRepeatPassword());
		if (count == 1) {
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("Successfully Registered");
			topicResp.setLeagueResponse(signUpRequest.getFullName());
			return topicResp;
		} else {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while adding");
			return errorResponse;
		}
	}
	
	public Object getLoginDetails(String userId) {
		
		String query = "SELECT * FROM USER WHERE user_name = ?";
		try{
		Object list = jdbcTemplate.query(query,new Object[] { userId },
				new LoginMapper());
		TopicResponse topicResp = new TopicResponse();
		topicResp.setAppStatus(0);
		topicResp.setStatus("200");
		topicResp.setSuccessMessage("Team Infomation Successfully Fetched");
		topicResp.setLeagueResponse(list);
		return topicResp;
		}catch(Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("No Data Found!");
			return errorResponse;
		}
	}
}
