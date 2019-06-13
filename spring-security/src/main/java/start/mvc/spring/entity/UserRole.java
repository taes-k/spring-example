package start.mvc.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_USER_ROLE")
@Data
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "seq")
	private int seq;

    @Column(name = "user_seq")
	private int user;
	
    @Column(length = 200, nullable = false)
    private String role;
}
