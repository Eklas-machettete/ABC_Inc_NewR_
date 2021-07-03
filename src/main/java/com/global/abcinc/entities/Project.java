package com.global.abcinc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
	@Id
	@Column(updatable = false, nullable = false)
	private String projectId;
	private String projectName;
    private String description;
	private String status;
  @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, mappedBy = "projectName")
	private List<Task> tasks;
	

}
