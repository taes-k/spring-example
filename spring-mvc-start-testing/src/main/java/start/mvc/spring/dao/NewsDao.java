package start.mvc.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import start.mvc.spring.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

	List<News> findByType(String type);
	
	@Query("select n from News n where n.type = :type")
	List<News> findCategoryNews(String type);


}
