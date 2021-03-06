package io.ashwin.dao;

import io.ashwin.springboot.mapper.LeagueMapper;
import io.ashwin.springboot.mapper.LoginMapper;
import io.ashwin.springboot.mapper.ManagerInfoMapper;
import io.ashwin.springboot.mapper.TeamInfoMapper;
import io.ashwin.springboot.mapper.TeamSquadMapper;
import io.ashwin.springboot.mapper.TopicMapper;
import io.ashwin.springboot.request.ManagerInfo;
import io.ashwin.springboot.request.SignUpRequest;
import io.ashwin.springboot.request.TeamInfo;
import io.ashwin.springboot.request.TeamSquad;
import io.ashwin.springboot.request.Topic;
import io.ashwin.springboot.response.ErrorResponse;
import io.ashwin.springboot.response.TopicResponse;
import io.ashwin.springboot.util.QueryConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.json.JSONObject;

//import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Repository
public class TopicDaoImpl implements TopicDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private QueryConfig queryConfig;

	@Override
	public Object getTopicById(String league, String name) {
		// TODO Auto-generated method stub
		String query = queryConfig.getGetLeagueByName();
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

		String query = queryConfig.getGetAllLeagues();
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
		
		String query = queryConfig.getCreateLeague();
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
		String query = queryConfig.getEditLeague();
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
		String query = queryConfig.getDeleteLeague();
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

	@Override
	public Object getTeamInfo(String name) {
		// TODO Auto-generated method stub
		String query = queryConfig.getGetTeamInfoByName();
		try {
//			Topic t = (Topic) jdbcTemplate.queryForObject(query,
//					new Object[] { league }, new TopicMapper());
			TeamInfo league1 = (TeamInfo) jdbcTemplate.queryForObject(
					query,new Object[] { name }, new TeamInfoMapper());
			System.out.println(league1);
//			JSONObject jo = new JSONObject();
//			jo.put("passes", league1.getPasses());
//			jo.put("crosses", league1.getCrosses());
//			jo.put("passesPerMatch", league1.getPassesPerMatch());
//			jo.put("foul", league1.getFoul());
//			jo.put("offsides", league1.getOffsides());
//			jo.put("yellowCards", league1.getYellowCards());
//			jo.put("redCards", league1.getRedCards());
//			JSONObject j1 = new JSONObject();
//			j1.put("teamPlayDiscipline", jo);
//			
//			JSONObject j2 = new JSONObject();
//			j2.put("totalGoals", league1.getTotalGoals());
//			j2.put("goalsPerMatch", league1.getGoalsPerMatch());
//			j2.put("shots", league1.getShots());
//			j2.put("shotsOnTarget", league1.getShotsOnTarget());
//			j2.put("penaltiesScored", league1.getPenaltiesScored());
//			j2.put("bigChancesCreated", league1.getBigChancesCreated());
//			j2.put("hitWoodWork", league1.getHitWoodWork());
//			j2.put("cleanSheets", league1.getTotalCleanSheets());
//			j2.put("goalsConceded",league1.getTotalGoalsConceded());
//			j2.put("goalsConcededPerMatch", league1.getGoalsConcededPerMatch());
//			j2.put("saves", league1.getSaves());
//			j2.put("tackles", league1.getTackles());
//			j2.put("blockedShots", league1.getBlockedShots());
//			j2.put("interception", league1.getInterceptions());
//			j2.put("clearances", league1.getClearances());
//			j2.put("headedClearance", league1.getHeadedClearances());
//			j2.put("arielBattles", league1.getAreilBattlesWon());
//			j2.put("errorsLeading", league1.getErrorsLeadingtoGoal());
//			j2.put("ownGoals", league1.getOwnGoals());
//			JSONObject j3 = new JSONObject();
//			j3.put("attackDefense", j2);
//			
//			JSONObject mainObj = new JSONObject();
//			mainObj.put("id", league1.getId());
//			mainObj.put("teamName", league1.getTeamName());
//			mainObj.put("manager", league1.getManager());
//			mainObj.put("stadium", league1.getStadium());
//			mainObj.put("location", league1.getLocation());
//			mainObj.put("teamSponsor", league1.getTeamSponsor());
//			mainObj.put("teamKitSponsor", league1.getTeamKitSponsor());
//			mainObj.put("matchPlayed", league1.getMatchPlayed());
//			mainObj.put("wins", league1.getWins());
//			mainObj.put("losses", league1.getLosses());
//			mainObj.put("goals", league1.getGoals());
//			mainObj.put("goalsConceded", league1.getGoalsConceded());
//			mainObj.put("cleanSheets", league1.getCleanSheets());
//			mainObj.putAll(j1);
//			mainObj.putAll(j3);s
			
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
		String query = queryConfig.getRegisterAccount();
		int count = jdbcTemplate.update(query, signUpRequest.getFullName(),signUpRequest.getEmail()
				,signUpRequest.getUserName(),signUpRequest.getPassword()
				,signUpRequest.getRepeatPassword(),signUpRequest.getAddress(),signUpRequest.getCountry(),signUpRequest.getState(),signUpRequest.getCity(),signUpRequest.getZipCode());
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
	
	public Object getLoginDetails(String userId, String password, String emailId) {
		String query = queryConfig.getGetLoginDetails();
		try{
		SignUpRequest list = (SignUpRequest) jdbcTemplate.queryForObject(query,new Object[] { userId, password, emailId },
				new LoginMapper());
		
//		JSONObject jo = new JSONObject();
//		jo.put("address",list.getAddress());
//		jo.put("country", list.getCountry());
//		jo.put("city", list.getCity());
//		jo.put("zipcode", list.getZipCode());
//		jo.put("state", list.getState());
//		JSONObject personalDetails = new JSONObject();
//		personalDetails.put("userDetails", jo);
//		
//		JSONObject j1 = new JSONObject();
//		j1.put("fullName", list.getFullName());
//		j1.put("email", list.getEmail());
//		j1.put("userName", list.getUserName());
//		j1.put("password", list.getPassword());
//		j1.put("repeatPassword", list.getRepeatPassword());
//		j1.put("id", list.getId());
//		j1.put("personalDetails", personalDetails);
		
		TopicResponse topicResp = new TopicResponse();
		topicResp.setAppStatus(0);
		topicResp.setStatus("200");
		topicResp.setSuccessMessage("User Infomation Successfully Fetched");
		topicResp.setLeagueResponse(list);
		return topicResp;
		}catch(Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error or Data Not Found!");
			return errorResponse;
		}
	}

	@Override
	public Object updatePassword(SignUpRequest signUpRequest, String id) {
		
		String query = null;
		boolean userFlag = false;
		int count = 0;
		
		if(signUpRequest.getAddress() == null){
		 query = queryConfig.getUpdatePassword();
		} else {
		 query = queryConfig.getUpdateProfile();
		 userFlag = true;
		}
		try{
		if(userFlag == false){
		count = jdbcTemplate.update(query, signUpRequest.getPassword(),
				signUpRequest.getRepeatPassword(),signUpRequest.getId());
		} else {
		count = jdbcTemplate.update(query, signUpRequest.getFullName(),
					signUpRequest.getEmail(),signUpRequest.getUserName(),signUpRequest.getAddress(),
					signUpRequest.getCountry(),signUpRequest.getState(),signUpRequest.getCity(),
					signUpRequest.getZipCode(),signUpRequest.getId());
		}
		if (count == 1) {
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("Password Successfully Updated");
			topicResp.setLeagueResponse(signUpRequest.getPassword());
			return topicResp;
		} else {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while updating password");
			return errorResponse;
		}
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Object getLeague() {
		// TODO Auto-generated method stub
		String query = queryConfig.getGetLeague();
		try{
		ArrayList<Topic> list = (ArrayList<Topic>) jdbcTemplate.query(query, new LeagueMapper());
		TopicResponse topicResp = new TopicResponse();
		topicResp.setAppStatus(0);
		topicResp.setStatus("200");
		topicResp.setSuccessMessage("League Successfully Fetched");
		topicResp.setLeagueResponse(list);
		return topicResp;
		}catch(Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("EmailId not Found!");
			return errorResponse;
		}
	}

	@Override
	public Object getTeamSquad(String teamName) {
		String query = queryConfig.getGetTeamSquad();
		try{
			ArrayList<TeamSquad> list = (ArrayList<TeamSquad>) jdbcTemplate.query(query, new Object [] {teamName}, new TeamSquadMapper());
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("Team Squad Successfully Fetched");
			topicResp.setLeagueResponse(list);
			return topicResp;
		}catch(Exception e) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while getting data!!!" + e);
			return errorResponse;
		}
		
	}
	private static String UPLOADED_FOLDER = "E://temp//";
	@Override
	public Object uploadImage(SignUpRequest signUpRequest, MultipartFile file,
			RedirectAttributes redirectAttributes) {
		// TODO Auto-generated method stub
		String query = "UPDATE USER SET PATH = ? WHERE ID = ?";
		int count = 0;
		Path path = null;
		if (file.isEmpty()) {
          redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
          return "redirect:uploadStatus";
      }

      try {

          // Get the file and save it somewhere
          byte[] bytes = file.getBytes();
          path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
          Files.write(path, bytes);
          System.out.println("path" + "--->" + path);
          redirectAttributes.addFlashAttribute("message",
                  "You successfully uploaded '" + file.getOriginalFilename() + "'");

      } catch (IOException e) {
          e.printStackTrace();
      }
		try{
		count = jdbcTemplate.update(query,path,signUpRequest.getId());
		if (count == 1) {
			TopicResponse topicResp = new TopicResponse();
			topicResp.setAppStatus(0);
			topicResp.setStatus("200");
			topicResp.setSuccessMessage("Image Successfully Updated");
			topicResp.setLeagueResponse(signUpRequest.getPath());
			return topicResp;
		} else {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while updating password");
			return errorResponse;
		}
		}catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public Object getManagerDetails(String name) {
		// TODO Auto-generated method stub
		String query = queryConfig.getGetManagerInfo();
		try {
		ManagerInfo list = (ManagerInfo) jdbcTemplate.queryForObject(query, new Object[] { name } , new ManagerInfoMapper());
		
		JSONObject jo = new JSONObject();
		jo.put("seasons",list.getSeasons());
		jo.put("matches",list.getMatches());
		jo.put("wins",list.getWins());
		jo.put("draws",list.getDraws());
		jo.put("losses",list.getLosses());
		jo.put("gf",list.getGf());
		jo.put("ga",list.getGa());
		
		JSONObject stats = new JSONObject();
		stats.put("stats", jo);
		
		JSONObject j1 = new JSONObject();
		j1.put("id",list.getId());
		j1.put("name",list.getName());
		j1.put("country",list.getCountry());
		j1.put("joinDate",list.getJoinedDate());
		j1.put("age",list.getAge());
		j1.put("dob",list.getDob());
		//j1.putAll(stats);
		TopicResponse topicResp = new TopicResponse();
		topicResp.setAppStatus(0);
		topicResp.setStatus("200");
		topicResp.setSuccessMessage("Manager Infomation Successfully Fetched");
		topicResp.setLeagueResponse(j1);
		return topicResp;
		}catch(Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("No data Found!" + e);
			return errorResponse;
		}
		
	}

	@Override
	public Object updateteamInfo(TeamInfo teamInfo) {
		// TODO Auto-generated method stub
		String query = queryConfig.getUpdateTeamInfo();
		int count = 0;
		
		try{
			count = jdbcTemplate.update(query, teamInfo.getTeamName(), teamInfo.getManager(),teamInfo.getStadium(), teamInfo.getLocation(), teamInfo.getId());
			if(count == 1){
				TopicResponse topicResp = new TopicResponse();
				topicResp.setAppStatus(0);
				topicResp.setStatus("200");
				topicResp.setSuccessMessage("Team Information Successfully Updated");
				topicResp.setLeagueResponse(teamInfo.getId());
				return topicResp;
			} else {
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setAppStatus(1);
				errorResponse.setStatus("200");
				errorResponse.setErrorId(1000);
				errorResponse.setErrorMessage("Error while updating password");
				return errorResponse;
			}
		}catch(Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Error while updating password" + " " + e);
			return errorResponse;
		}
		
	}

	@Override
	public Object updateTeamName(Topic topic) {
		// TODO Auto-generated method stub
		String query = queryConfig.getUpdateTeamName();
		int count = 0;
		
		try{
			count = jdbcTemplate.update(query, topic.getName(),topic.getId());
			
			if(count == 1) {
				TopicResponse topicResp = new TopicResponse();
				topicResp.setAppStatus(0);
				topicResp.setStatus("200");
				topicResp.setSuccessMessage("Team Name Successfully Updated");
				topicResp.setLeagueResponse(topic.getId());
				return topicResp;
			} else {
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setAppStatus(1);
				errorResponse.setStatus("200");
				errorResponse.setErrorId(1000);
				errorResponse.setErrorMessage("Error while updating password" + " ");
				return errorResponse;
			}
			
		}catch(Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setAppStatus(1);
			errorResponse.setStatus("200");
			errorResponse.setErrorId(1000);
			errorResponse.setErrorMessage("Exception" + " " + e);
			return errorResponse;
		}
	}
}
