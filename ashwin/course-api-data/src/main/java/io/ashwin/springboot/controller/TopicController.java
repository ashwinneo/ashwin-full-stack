package io.ashwin.springboot.controller;

import io.ashwin.springboot.request.SignUpRequest;
import io.ashwin.springboot.request.Topic;
import io.ashwin.springboot.response.ErrorResponse;
import io.ashwin.springboot.topic.TopicService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
//	@RequestMapping("league/{league}/{name}")
	@RequestMapping("league")
//	public Object getTopics(@RequestParam String league , Topic topic){
//	public Object getTopics(@PathVariable(name = "league", required = false) String league,@PathVariable(name = "name", required = false) String name, Topic topic){
	public Object getTopics(@RequestParam(value = "league", required=false) String  league,@RequestParam(value = "name", required=false) String name, Topic topic){
		
			return topicService.getTopicById(league ,name, topic);
			
	}
	

	@RequestMapping("leagues")
	public Object getLeagueById(){
		//return topicService.getTopics();
		Object topic = null;
		topic = topicService.getTopics();
		return topic;
	}
	
//	@RequestMapping(value="/topics" , method=RequestMethod.POST)
	@PostMapping(value="/createLeague")
	public Object addTopic(@RequestBody Topic topic){
//		Object obj = topicService.validateEmpty(topic);
//		if(obj instanceof ErrorResponse){
//			return obj;
//			
//		}else{
			return topicService.addTopic(topic);
		//}
	}
	
//	@RequestMapping(method=RequestMethod.PUT, value="topics/{id}")
	@PutMapping(value="editLeague")
	public Object updateTopic(@RequestBody Topic topic , @RequestParam(value = "id", required=false) String  id){
		return topicService.updateTopic(id , topic);
	}
	
	@DeleteMapping(value="/deleteLeague")
		public Object deleteTopic(@RequestParam(value = "id", required=false) String id){
			
		return topicService.deleteTopic(id);
	}

	@RequestMapping("teamInfo")
	public Object getTeamInfo(@RequestParam(value = "name", required=false) String name){
		return topicService.getTeamInfo(name);
	}
	
	@PostMapping(value= "signUp")
	public Object registerAccount(@RequestBody SignUpRequest signUpRequest){
		
		return topicService.registerAccount(signUpRequest);
	}
	
	@RequestMapping("getLoginDetails")
	public Object getLoginDetails(@RequestParam(value = "userId" , required=false) String userId, @RequestParam(value = "password" , required=false) String password, @RequestParam(value = "emailId" , required=false) String emailId) {
		
		return topicService.getLoginDetails(userId,password,emailId);
	}
	
	@PutMapping(value = "updateUserDetails")
	public Object updatePassword(@RequestBody SignUpRequest signUpRequest ,@RequestParam(value = "id", required=false)  String id){
		
		return topicService.updatePassword(signUpRequest,id);
	}
	
	@RequestMapping("getLeague")
	public Object getLeague() {
		
		return topicService.getLeague();
	}
	
	@RequestMapping("getTeamSquad")
	public Object getTeamSquad(@RequestParam(value="teamName") String teamName) {
		return this.topicService.getTeamSquad(teamName);
	}
}
