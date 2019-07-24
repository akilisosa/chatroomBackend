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
@Table(name = "CHAT_CHANNELS")
public class Channel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8335028713964196526L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_channel_gen")
	@SequenceGenerator(name = "chat_channel_gen", sequenceName = "CHAT_CHANNEL_seq", allocationSize = 1)
	@Column(name = "CHANNELID")
	private Integer channelId;

	@Column(name = "CHANNELNAME")
	private String channelName;

	@Column(name = "CHANNELTYPE")
	private Integer channelType;

	@Column(name = "CHANNELUSER1")
	private Integer channelUser1;
	
	@Column(name = "CHANNELUSER2")
	private Integer channelUser2;

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public Integer getChannelUser1() {
		return channelUser1;
	}

	public void setChannelUser1(Integer channelUser1) {
		this.channelUser1 = channelUser1;
	}

	public Integer getChannelUser2() {
		return channelUser2;
	}

	public void setChannelUser2(Integer channelUser2) {
		this.channelUser2 = channelUser2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
		result = prime * result + ((channelType == null) ? 0 : channelType.hashCode());
		result = prime * result + ((channelUser1 == null) ? 0 : channelUser1.hashCode());
		result = prime * result + ((channelUser2 == null) ? 0 : channelUser2.hashCode());
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
		Channel other = (Channel) obj;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (channelType == null) {
			if (other.channelType != null)
				return false;
		} else if (!channelType.equals(other.channelType))
			return false;
		if (channelUser1 == null) {
			if (other.channelUser1 != null)
				return false;
		} else if (!channelUser1.equals(other.channelUser1))
			return false;
		if (channelUser2 == null) {
			if (other.channelUser2 != null)
				return false;
		} else if (!channelUser2.equals(other.channelUser2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", channelType=" + channelType
				+ ", channelUser1=" + channelUser1 + ", channelUser2=" + channelUser2 + "]";
	}

	public Channel(Integer channelId, String channelName, Integer channelType, Integer channelUser1,
			Integer channelUser2) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelType = channelType;
		this.channelUser1 = channelUser1;
		this.channelUser2 = channelUser2;
	}

	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
