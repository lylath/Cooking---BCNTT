package com.isep.cooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
public class CookingUser implements Serializable {

	@Id
	private String id;

	private String firstName;
	private String lastName;
	private String password;
	private String hashedSessionId;

	@Column(unique = true)
	private String email;
	private int age;

	/*@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "")       NOT IMPLEMENTED YET
    private Comment[] comments;*/
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Ingredient> ingredients;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Recipe> likedRecipes;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Tool> tools;

	/*@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "")       NOT IMPLEMENTED YET
    private Recipe[] writtenRecipes;*/
	public CookingUser() {
		this.id = UUID.randomUUID().toString();
	}

	public CookingUser(String firstName, String lastName, String password, String hashedSessionId, String email, int age, List<Ingredient> ingredients, List<Recipe> likedRecipes, List<Tool> tools) {

		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = new String(DigestUtils.sha512(password));
		this.hashedSessionId = hashedSessionId;
		this.email = email;
		this.age = age;
		this.ingredients = ingredients;
		this.likedRecipes = likedRecipes;
		this.tools = tools;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getHashedSessionId() {
		return hashedSessionId;
	}

	public void setHashedSessionId(String hashedSessionId) {
		this.hashedSessionId = hashedSessionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int Age) {
		this.age = Age;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Recipe> getLikedRecipes() {
		return likedRecipes;
	}

	public void setLikedRecipes(List<Recipe> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}

	public boolean generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
			return true;
		}
		return false;
	}

	public void addIngredient(Ingredient i) {
		this.ingredients.add(i);
	}

	public void addLikedRecipe(Recipe r) {
		this.likedRecipes.add(r);
	}

	public void addTool(Tool t) {
		this.tools.add(t);
	}

}
