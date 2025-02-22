package com.platform.mappl.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user_invite")
public class UserInvite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int appUserId;

    @Column(name = "invite_user_id", nullable = false)
    private int inviteUserId;
    
    @NotBlank(message = "Hearts cannot be empty")
    @Column(name = "hearts", nullable = false)
    private int hearts;
    
    @Column(name = "invite_date")
    private Date inviteDate;

    @Column(name = "invite_time")
    private String inviteTime;

    @Column(name = "location")
    private String location;

    @Column(name = "status", nullable = false)
    private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	public int getInviteUserId() {
		return inviteUserId;
	}

	public void setInviteUserId(int inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public Date getInviteDate() {
		return inviteDate;
	}

	public void setInviteDate(Date inviteDate) {
		this.inviteDate = inviteDate;
	}

	public String getInviteTime() {
		return inviteTime;
	}

	public void setInviteTime(String inviteTime) {
		this.inviteTime = inviteTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
