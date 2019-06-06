package start.mvc.spring.service;

import java.util.Optional;

import start.mvc.spring.entity.News;

public interface NewsService {
	
	public News insertNews(News news);
	public News updateNews(int id, News news);
	public Optional<News> getNews(int newsId);	
}
