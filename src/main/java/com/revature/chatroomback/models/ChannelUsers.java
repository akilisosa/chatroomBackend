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
@Table(name = "CHAT_CHANNEL_USERS")
public class ChannelUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7641726481625683628L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_channels_users_gen")
	@SequenceGenerator(name = "chat_channel_users_gen", sequenceName = "CHAT_CHANNEL_USERS_seq", allocationSize = 1)
	@Column(name = "CCU_ID")
	private Integer id;

	@Column(name = "CHANNEL_ID")
	private String channelId;

	@Column(name = "CCUSER_ID")
	private Integer channelUser;

	@Column(name = "USERSTATUS")
	private Integer userStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Integer getChannelUser() {
		return channelUser;
	}

	public void setChannelUser(Integer channelUser) {
		this.channelUser = channelUser;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "ChannelUsers [id=" + id + ", channelId=" + channelId + ", channelUser=" + channelUser + ", userStatus="
				+ userStatus + "]";
	}

	public ChannelUsers(Integer id, String channelId, Integer channelUser, Integer userStatus) {
		super();
		this.id = id;
		this.channelId = channelId;
		this.channelUser = channelUser;
		this.userStatus = userStatus;
	}

	public ChannelUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((channelUser == null) ? 0 : channelUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
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
		ChannelUsers other = (ChannelUsers) obj;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (channelUser == null) {
			if (other.channelUser != null)
				return false;
		} else if (!channelUser.equals(other.channelUser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}
	

}
