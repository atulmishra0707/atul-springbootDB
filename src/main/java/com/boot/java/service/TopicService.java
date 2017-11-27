package com.boot.java.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.java.dao.TopicDAO;
import com.boot.java.dto.Topic;

@Service
public class TopicService {
	@Autowired
	private TopicDAO topicDao;

	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring Framework Description"),
			new Topic("Java","core Java","Java Description"),
			new Topic("JavaScript","Java Script","JavaScript Description")
			));*/
	
	public List<Topic> getAllTopic(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicDao.findAll().forEach(topics::add);
		return topics;
		}
	
	public Topic getTopic(String id){
		//return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
		return topicDao.findOne(id);
	}

	public List<Topic> putTopic(String id, Topic topic) {
		/*for(int i=0; i < topics.size();i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return topics;
			}
		}*/
		topicDao.save(topic);
		return this.getAllTopic();
	}

	public Topic deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id)); // Lambda Expression 
		/*Topic topic = topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
		topics.remove(topic);
		return topic;*/
		Topic topic = this.getTopic(id);
		topicDao.delete(id);
		return topic;
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicDao.save(topic);
	}
}
