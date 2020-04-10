package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor@EqualsAndHashCode
public class User {
private String username;
private int id;
@EqualsAndHashCode.Exclude
private List<Project> projectList;
}
