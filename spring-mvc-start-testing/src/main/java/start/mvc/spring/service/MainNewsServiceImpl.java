package start.mvc.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.mvc.spring.dao.NewsDao;
import start.mvc.spring.entity.News;

@Service
public class MainNewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;
	
	@Override
	public List<News> getNews() {
		List mainNews = new ArrayList();
		mainNews = newsDao.findAll();
		return mainNews;
	}
}
