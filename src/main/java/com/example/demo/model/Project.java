package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Project {
	@Id
	// @Column(name = "projectid")
	String projectId;
	@ManyToMany(mappedBy = "projectList")
	// @JoinColumn(name = "projectid")

	@EqualsAndHashCode.Exclude
	List<User> user;
	// @Column(name = "projectname")
	String projectName;
}
