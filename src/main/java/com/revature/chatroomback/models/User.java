package com.revature.chatroomback.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHAT_USERS")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9173885932651708257L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_users_gen")
	@SequenceGenerator(name = "chat_users_gen", sequenceName = "CHAT_USERS_seq", allocationSize = 1)
	@Column(name = "CU_ID")
	private Integer id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ADMINLVL")
	private String adminLvl;
	
	@Column(name = "STATUS")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminLvl() {
		return adminLvl;
	}

	public void setAdminLvl(String adminLvl) {
		this.adminLvl = adminLvl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminLvl == null) ? 0 : adminLvl.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (adminLvl == null) {
			if (other.adminLvl != null)
				return false;
		} else if (!adminLvl.equals(other.adminLvl))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", adminLvl=" + adminLvl + ", status="
				+ status + "]";
	}

	public User(Integer id, String email, String password, String adminLvl, String status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.adminLvl = adminLvl;
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
