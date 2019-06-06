package start.mvc.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.mvc.spring.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

}
