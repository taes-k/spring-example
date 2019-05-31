package start.mvc.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import start.mvc.spring.vo.News;

@Repository
public class MainNewsDaoImpl implements NewsDao {
	
    @Autowired
    private SqlSessionTemplate sqlSession;
	
	@Override
	public List<News> getNews() {
		List mainNews = new ArrayList();
		
		return sqlSession.selectList("news.getMainNews");
	}
}
