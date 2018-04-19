package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Topics;

public interface TopicRepo extends JpaRepository<Topics, Integer>
{
   public List<Topics> findByName(String name);
}
