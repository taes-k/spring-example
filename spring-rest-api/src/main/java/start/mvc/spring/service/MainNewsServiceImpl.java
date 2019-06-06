package start.mvc.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.mvc.spring.dao.NewsDao;
import start.mvc.spring.entity.News;

@Service
public class MainNewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;

	@Override
	public News insertNews(News news) {
		
		return newsDao.save(news);
	}

	@Override
	public News updateNews(int id, News news) {
		
		news.setId(id);
		
		return newsDao.save(news);
	}

	@Override
	public Optional<News> getNews(int newsId) {
		
		return newsDao.findById(newsId);
	}
}
