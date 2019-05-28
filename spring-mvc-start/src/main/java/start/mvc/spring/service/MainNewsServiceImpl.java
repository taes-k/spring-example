package start.mvc.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import start.mvc.spring.vo.News;

@Service
public class MainNewsServiceImpl implements NewsService {

	@Override
	public List<News> getNews() {
		List mainNews = new ArrayList();
		
		News news1 = new News();
		news1.setTitle("중고차 매매 후 한 달 내 고장나면 보험 보상받는다");
		news1.setContents("중고차 구입 소비자의 피해를 구제하기 위한 중고차 보험이 다음 달부터 의무화되면서 구입 한 달 이내의 중고차 고장은 보험으로 보장을 받을 수 있게 된다.");
		news1.setDate("2019-05-27 13:30");
		news1.setAuthor("Taes");
		news1.setType("financial");

		News news2 = new News();
		news2.setTitle("하늘 참 신기하네");
		news2.setContents("오전 대구 달서구청 옥상 정원에서 시민들이 하늘에 펼쳐진 이색적인 구름을 관찰하고 있다. 파란 하늘에서 잘라낸 듯 넓게 펼쳐진 구름대와 차고 습한 대기 속을 비행하는 항공기가 남기는 가늘고 긴 구름 ‘비행운(오른쪽 가늘고 긴 구름)’이 겹쳐지며 진기한 풍경을 연출하고 있다. ");
		news2.setDate("2019-05-27 09:30");
		news2.setAuthor("Taes");
		news2.setType("social");

		News news3 = new News();
		news3.setTitle("커쇼 11연승, 다저스 4연승");
		news3.setContents("커쇼가 11연승에 성공했다. 벨린저는 19호 홈런과 함께 팀을 구해낸 두 개의 외야 어시스트를 기록했다. 오클랜드는 10연승을 질주. ");
		news3.setDate("2019-05-27 11:35");
		news3.setAuthor("Taes");
		news3.setType("sports");
		
		
		mainNews.add(news1);
		mainNews.add(news2);
		mainNews.add(news3);
		
		return mainNews;
	}
}
