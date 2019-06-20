package server.auth.msa.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_USER")
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_name", length = 20, unique = true, nullable = false)
	private String username;
	@Column(length = 400, nullable = false)
	private String password;
	@Column(name = "user_type", nullable = false)
	private int userType;
	@Column(nullable = false)
	private Date date;
	
}
