package start.mvc.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.mvc.spring.dao.MainNewsDaoImpl;
import start.mvc.spring.vo.News;

@Service
public class MainNewsServiceImpl implements NewsService {

	@Autowired
	MainNewsDaoImpl mainNewsDao;
	
	@Override
	public List<News> getNews() {
		List mainNews = new ArrayList();
		
		mainNews = mainNewsDao.getNews();
		
		System.out.println("mainNews ::"+mainNews);
		
		return mainNews;
	}
}
