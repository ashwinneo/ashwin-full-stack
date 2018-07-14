package io.ashwin.springboot.topic;

import io.ashwin.springboot.request.Topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic , String> {

}
