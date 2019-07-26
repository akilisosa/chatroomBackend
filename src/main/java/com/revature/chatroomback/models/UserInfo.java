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
@Table(name = "BLOCKED_USERS")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8981853160890266421L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_users_gen")
	@SequenceGenerator(name = "chat_users_gen", sequenceName = "CHAT_USERS_seq", allocationSize = 1)
	@Column(name = "CUI_ID")
	private Integer id;
	
	@Column(name = "screenName_user")
	private String screenName;
	
	@Column(name = "imgSrc")
	private String image;
	
	@Column(name = "birthyear")
	private String birthYear;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (birthYear == null) {
			if (other.birthYear != null)
				return false;
		} else if (!birthYear.equals(other.birthYear))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", screenName=" + screenName + ", image=" + image + ", birthYear=" + birthYear
				+ "]";
	}

	public UserInfo(Integer id, String screenName, String image, String birthYear) {
		super();
		this.id = id;
		this.screenName = screenName;
		this.image = image;
		this.birthYear = birthYear;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
