package com.revature.chatroomback.models;

import java.util.List;

public class SuperUser {

	private Integer userId;
	private String email;
	private String password;
	private String adminLvl;
	private String status;
	private String screenName;
	private String image;
	private String birthYear;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminLvl == null) ? 0 : adminLvl.hashCode());
		result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		SuperUser other = (SuperUser) obj;
		if (adminLvl == null) {
			if (other.adminLvl != null)
				return false;
		} else if (!adminLvl.equals(other.adminLvl))
			return false;
		if (birthYear == null) {
			if (other.birthYear != null)
				return false;
		} else if (!birthYear.equals(other.birthYear))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperUser [userId=" + userId + ", email=" + email + ", password=" + password + ", adminLvl=" + adminLvl
				+ ", status=" + status + ", screenName=" + screenName + ", image=" + image + ", birthYear=" + birthYear
				+ "]";
	}
	public SuperUser(Integer userId, String email, String password, String adminLvl, String status, String screenName,
			String image, String birthYear) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.adminLvl = adminLvl;
		this.status = status;
		this.screenName = screenName;
		this.image = image;
		this.birthYear = birthYear;
	}
	public SuperUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
