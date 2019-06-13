package start.mvc.spring.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_USER")
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "seq")
	private int id;

	@Column(name = "id", length = 20, unique = true, nullable = false)
	private String uid;
	@Column(length = 50, nullable = false)
	private String password;
	@Column(length = 10, nullable = false)
	private String name;
	@Column(nullable = false)
	private Date date;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_seq")
	private List<UserRole> roles = new ArrayList<UserRole>();
}
