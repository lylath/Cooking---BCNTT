package com.isep.cooking.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tool implements Serializable {

	@Id
	@Column(name = "ID")
	private UUID id;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "tools")
	private List<CookingUser> users;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "tools")
	private List<Recipe> recipes;

	public Tool() {
		this.id = UUID.randomUUID();
	}

	public Tool(String name, List<CookingUser> users, List<Recipe> recipes) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.users = users;
		this.recipes = recipes;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CookingUser> getUsers() {
		return users;
	}

	public void setUsers(List<CookingUser> users) {
		this.users = users;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public void generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}

}
