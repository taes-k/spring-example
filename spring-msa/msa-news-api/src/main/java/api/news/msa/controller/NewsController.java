package api.news.msa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class NewsController {

	@RequestMapping("/")
	public String getNews() {

		return "news Information";
	}
	

    @RequestMapping("/review/add")
    public Mono<ResponseEntity> addReviewCount(@RequestParam(value="newsId") int newsId) {
      System.out.println("add news Review Count / news Id : "+newsId);

      return Mono.just(ResponseEntity.ok().build());
    }
    
}

