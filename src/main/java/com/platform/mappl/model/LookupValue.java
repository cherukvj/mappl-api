package com.platform.mappl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lookup_value")
public class LookupValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lookup_type_id", nullable = false)
    private int lookupTypeId;

    @NotBlank(message = "Code cannot be empty")
    @Size(max = 10, message = "Code cannot exceed 10 characters")
    @Column(name = "code", nullable = false)
    private String code;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sequence")
    private Integer sequence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLookupTypeId() {
		return lookupTypeId;
	}

	public void setLookupTypeId(int lookupTypeId) {
		this.lookupTypeId = lookupTypeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
    
}
