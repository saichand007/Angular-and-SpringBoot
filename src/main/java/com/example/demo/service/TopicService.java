package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Topics;
import com.example.demo.repository.TopicRepo;

@Service
public class TopicService
{
	@Autowired
	private TopicRepo topicRepo;

	public  List<Topics> lst=new ArrayList<Topics>();

	public TopicService()
	{

	}


	public List<Topics> getTopics()
	{
		return topicRepo.findAll();
		
	}

	public Topics getTopic(int id) 
	{
		return topicRepo.getOne(id);
				
	}


	public void addTopic(Topics topic) 
	{
		System.out.println(topic);
		topicRepo.save(topic);
	}


	public Topics updateTopic(Topics topic, int id) 
	{
		
		return topicRepo.save(topic);
	}


	public void deleteTopic(int id)
	{
		topicRepo.deleteById(id);

	}
	
	public List<Topics> getbyName(String name)
	{
		return topicRepo.findByName(name);
	}
	

}
