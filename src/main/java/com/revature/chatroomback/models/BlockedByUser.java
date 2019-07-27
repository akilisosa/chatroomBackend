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
public class BlockedByUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3381218990047146370L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ae_block_gen")
	@SequenceGenerator(name = "ae_block_gen", sequenceName = "BLOCKED_USERS_seq", allocationSize = 1)
	@Column(name = "BU_ID")
	private Integer id;
	
	@Column(name = "USER_ID")
	private Integer blockingUserId;
	
	@Column(name = "BLOCKED_ID")
	private Integer blockedUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlockingUserId() {
		return blockingUserId;
	}

	public void setBlockingUserId(Integer blockingUserId) {
		this.blockingUserId = blockingUserId;
	}

	public Integer getBlockedUserId() {
		return blockedUserId;
	}

	public void setBlockedUserId(Integer blockedUserId) {
		this.blockedUserId = blockedUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockedUserId == null) ? 0 : blockedUserId.hashCode());
		result = prime * result + ((blockingUserId == null) ? 0 : blockingUserId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BlockedByUser other = (BlockedByUser) obj;
		if (blockedUserId == null) {
			if (other.blockedUserId != null)
				return false;
		} else if (!blockedUserId.equals(other.blockedUserId))
			return false;
		if (blockingUserId == null) {
			if (other.blockingUserId != null)
				return false;
		} else if (!blockingUserId.equals(other.blockingUserId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlockedByUser [id=" + id + ", blockingUserId=" + blockingUserId + ", blockedUserId=" + blockedUserId
				+ "]";
	}

	public BlockedByUser(Integer id, Integer blockingUserId, Integer blockedUserId) {
		super();
		this.id = id;
		this.blockingUserId = blockingUserId;
		this.blockedUserId = blockedUserId;
	}

	public BlockedByUser() {
		super();
	}

	

	
	
}
