package com.nadetdev.task;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;

import com.nadetdev.project.Project;
import com.nadetdev.user.User;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Table(name = "tasks")
public class Task extends PanacheEntity {
	
	@Column(nullable = false)
	public String title;
	
	@Column(length = 1000)
	public String description;
	
	public Integer priority;
	
	@ManyToOne(optional = false)
	public User user;
	
	public ZonedDateTime complete;
	
	@ManyToOne
	public Project project;
	
	@CreationTimestamp
	@Column(updatable = false, nullable =  false)
	public ZonedDateTime created;
	
	@Version
	public int version;
}
