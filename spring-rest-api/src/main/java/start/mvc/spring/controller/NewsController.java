package start.mvc.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import start.mvc.spring.entity.News;
import start.mvc.spring.service.MainNewsServiceImpl;

@RestController
public class NewsController {

	@Autowired
	MainNewsServiceImpl mainNewsService;
	
	@RequestMapping(value="/news", method=RequestMethod.POST)
	public News insertNews(@RequestBody News insertNews) {
		
		return mainNewsService.insertNews(insertNews);
	}
	
	@RequestMapping(value="/news/{id}", method=RequestMethod.PUT)
	public News updateNews( @PathVariable ("id") int newsId,
							@RequestBody News updateNews) {
		
		return mainNewsService.updateNews(newsId,updateNews);
	}
	
	@RequestMapping(value="/news/{id}", method=RequestMethod.GET)
	public Optional<News> getNews( @PathVariable ("id") int newsId) {
		
		return mainNewsService.getNews(newsId);
	}
}
