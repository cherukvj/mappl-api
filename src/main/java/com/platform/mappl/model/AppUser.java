package com.platform.mappl.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Login ID cannot be empty")
    @Size(max = 255, message = "Login ID cannot exceed 255 characters")
    @Column(name = "login_id", nullable = false)
    private String loginId;

    @NotBlank(message = "First Name cannot be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Profile Name cannot be empty")
    @Column(name = "profile_name", nullable = false)
    private String profileName;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email", nullable = false)
    private String email;
    
    @NotBlank(message = "DOB cannot be empty")
    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "age", nullable = false)
    private int age;
    
    @NotBlank(message = "Height cannot be empty")
    @Column(name = "height", nullable = false)
    private int height;
    
    @NotBlank(message = "Hearts cannot be empty")
    @Column(name = "hearts", nullable = false)
    private int hearts;

    @NotBlank(message = "Gender cannot be empty")
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @NotBlank(message = "Marital Status cannot be empty")
    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;
    
    @NotBlank(message = "Location cannot be empty")
    @Column(name = "location", nullable = false)
    private String location;

    @NotBlank(message = "Status cannot be empty")
    @Column(name = "status", nullable = false)
    private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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
