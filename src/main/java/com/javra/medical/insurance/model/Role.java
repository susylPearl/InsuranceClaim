package com.javra.medical.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "role_type")
	private String roletype;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
}
