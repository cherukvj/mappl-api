package com.platform.mappl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_preference")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int appUserId;

    @Column(name = "lookup_type_id", nullable = false)
    private int lookupTypeId;

    @Column(name = "lookup_value_id", nullable = false)
    private int lookupValueId;

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

	public int getLookupTypeId() {
		return lookupTypeId;
	}

	public void setLookupTypeId(int lookupTypeId) {
		this.lookupTypeId = lookupTypeId;
	}

	public int getLookupValueId() {
		return lookupValueId;
	}

	public void setLookupValueId(int lookupValueId) {
		this.lookupValueId = lookupValueId;
	}
}
