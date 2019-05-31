package start.mvc.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_NEWS")
@Data
public class News {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 200, nullable = false)
	private String title;
	@Column(length = 2000, nullable = false)
	private String contents;
	@Column(nullable = false)
	private Date date;
	@Column(length = 50, nullable = false)
	private String author;
	@Column(length = 45, nullable = false)
	private String type;

}
