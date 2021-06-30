package com.purchase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "userinfo")
public class User {

	@Id
	@Column (name="id")
	private Long id;
	
	@Column (name="name")
	private String name;
	
}
