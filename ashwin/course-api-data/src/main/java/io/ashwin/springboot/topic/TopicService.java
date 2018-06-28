package io.ashwin.springboot.topic;

import io.ashwin.dao.TopicDao;
import io.ashwin.springboot.response.ErrorResponse;
import io.ashwin.springboot.response.TopicResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	TopicDao topicDao;
	
	List<Topic> topics = new ArrayList<Topic> (Arrays.asList(
			new Topic("Spring1" , "Spring Boot" , "STS"),
			new Topic("Core Java1" , "Java" , "SYSO"),
			new Topic("JavaScript1" , "Script" , "JSP")
			
			));

//	public List<Topic> getAllTopics(){
////		List<Topic> topics = new ArrayList<>();
////		topicRepository.findAll().forEach(topics::add);
//		
//		String query = "SELECT NAME FROM TOPIC WHERE ID=?";
//		
//		return (List<Topic>) jdbcTemplate.queryForObject(query, TopicService.class);
//		//return topics;
//	}
	
	public ErrorResponse validateEmpty(Topic topic){
		ErrorResponse error = new ErrorResponse();
		if(topic.getId().isEmpty()){
			error.setAppStatus(1);
			error.setStatus("200");
			error.setErrorId(1010);
			error.setErrorMessage("id is empty");
			return error;
		}else if(topic.getName().isEmpty()){
			error.setAppStatus(1);
			error.setStatus("200");
			error.setErrorId(1010);
			error.setErrorMessage("name is empty");
			return error;
		}
//		else if(topic.getDescription().isEmpty()){
//			error.setAppStatus(1);
//			error.setStatus("200");
//			error.setErrorId(1010);
//			error.setErrorMessage("description is empty");
//			return error;
//		}
		return null;
		
	}
	public Object getTopicById(String id ,String name, Topic topic){
	
		Object t = topicDao.getTopicById(id,name);
		return t;

	}
	
	public Object getTopics(){

		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//return topicRepository.findOne(id);
		Object t = topicDao.getTopics();
		return t;
		
		
	}
	
	public Object addTopic(Topic topic) {
		
		Object t = topicDao.addTopic(topic);
		return t;
		//topicRepository.save(topic);
	}

	public Object updateTopic(String id, Topic topic) {
		
//		for(int i=0; i<topics.size(); i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)){
//				topics.set(i, topic);
//				return;
//			}
//		}
		//topicRepository.save(topic);
		Object t = topicDao.updateTopic(topic,id);
		return t;
	}

	public Object deleteTopic(String id) {
		
		//topics.removeIf(t -> t.getId().equals(id));
		//topicRepository.delete(id);
		Object t = topicDao.deleteTopic(id);
		return t;
	}

	public Object getTeamInfo(String name){
		Object t = topicDao.getTeamInfo(name);
		return t;
	}
	
	public Object registerAccount(SignUpRequest signUpRequest) {
		Object t = topicDao.registerAccount(signUpRequest);
		return t;
	}
	
	public Object getLoginDetails(String userId) {
		
		Object t = topicDao.getLoginDetails(userId);
		return t;
		
	}
}
	