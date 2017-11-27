package com.boot.java.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.java.dto.Topic;


public interface TopicDAO extends CrudRepository<Topic, String>{

	
}
