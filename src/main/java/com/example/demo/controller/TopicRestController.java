package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Topics;
import com.example.demo.service.TopicService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/rest")
public class TopicRestController {

	@Autowired
	private TopicService service;


	@RequestMapping("/topics")
	public List<Topics> getTopics(Model model)
	{
		System.out.println("working");
		return service.getTopics();

	}

	@GetMapping("/topics/{id}")
	public Topics getTopic(@PathVariable int id)
	{
		System.out.println("ID-"+id);
		return service.getTopic(id);
	}

	@RequestMapping(method=RequestMethod.POST,value="/savetopics")
	public void addTopic(@RequestBody Topics topic)
	{
		System.out.println("data="+topic);
		service.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/updatetopics/{id}")
	public void updateTopic(@RequestBody Topics topic,@PathVariable int id)
	{
		service.updateTopic(topic,id);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/deletetopics/{id}")
	public void deleteTopic(@PathVariable int id)
	{
		service.deleteTopic(id);
	}

	@PostMapping("/topics/{name}")
	public List<Topics> getbyName(@PathVariable String name)
	{
		return service.getbyName(name);
	}
}


