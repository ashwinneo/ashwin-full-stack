package io.ashwin.dao;

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

}