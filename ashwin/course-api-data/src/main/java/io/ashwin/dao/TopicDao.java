package io.ashwin.dao;

import io.ashwin.springboot.topic.SignUpRequest;
import io.ashwin.springboot.topic.Topic;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TopicDao {

	Object getTopicById(String ids, String name);
	Object getTopics();
	Object addTopic(Topic topic);
	Object updateTopic(Topic topic, String id);
	Object deleteTopic(String id);
	Object getTeamInfo(String name);
	Object registerAccount(SignUpRequest signUpRequest);
	Object getLoginDetails(String userId, String password, String emailId);
	Object updatePassword(SignUpRequest signUpRequest, String id);
	Object getLeague();
}
