package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Topics;
import com.example.demo.service.TopicService;

@Controller
public class TopicController
{
	@Autowired
	private TopicService service;


	// Inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) 
	{

		model.addAttribute("message", message);

		return "index";
	}

	@GetMapping("/topics")
	public String getTopics(Model model)
	{
		List<Topics> list= service.getTopics();

		model.addAttribute("topics",list);
		return "Topics";
	}

	@GetMapping("/onetopic/{id}")
	public String getTopic(@PathVariable int id,Model model)
	{
		System.out.println("Get Id-"+id);
		Topics topic=service.getTopic(id);
		System.out.println(topic);

		model.addAttribute("topic",topic);
		return "topic";
	}

	@GetMapping("/form")
	public String form(Model model)
	{
		Topics topics=new Topics();
		
		model.addAttribute(topics);
		
		return "form";
	}

	@RequestMapping(value = { "/topics" }, method = RequestMethod.POST)
	public String addTopic(@ModelAttribute("topics") Topics topics)
	{
			System.out.println(topics);
			
		    service.addTopic(topics);
		    
			return "redirect:/topics";
	}


	@GetMapping("/update/{id}")
	public String updateTopic(@PathVariable int id,Model model)
	{
		Topics topics=service.getTopic(id);
		model.addAttribute("topics",topics);

		return "form";
	}


	@GetMapping("/delete/{id}")
	public String deleteTopic(@PathVariable int id)
	{
		System.out.println("Delete-"+id);
		service.deleteTopic(id);
		return "redirect:/topics";
	}

	@GetMapping("/search")
	public String getbyName(@RequestParam("search") String search,Model model)
	{
		System.out.println(search);
		List<Topics> tps=service.getbyName(search);
		System.out.println(tps);
		model.addAttribute("topics",tps);
		return "Topics";
	}
}
