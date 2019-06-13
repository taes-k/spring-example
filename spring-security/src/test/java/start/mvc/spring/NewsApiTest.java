package start.mvc.spring;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import start.mvc.spring.entity.News;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class NewsApiTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper mapper;
    
    @Test
    public void insertNewsTest() throws Exception {
    	//뉴스 생성
    	News insertNews = new News();
    	insertNews.setTitle("새로운 뉴스");
    	insertNews.setContents("새로운 뉴스 컨텐츠");
    	insertNews.setDate(new Date());
    	insertNews.setAuthor("Taes-k");
    	insertNews.setType("sports");
    	
    	
      	MvcResult insertResult = mockMvc.perform(MockMvcRequestBuilders.post("/news")
  	        .contentType(MediaType.APPLICATION_JSON)
  			.content(mapper.writeValueAsString(insertNews)))
			.andExpect(status().isOk())
			.andDo(print())
			.andReturn();
    	
      	String contents = insertResult.getResponse().getContentAsString();
      	News insertResultNews = mapper.readValue(contents, News.class);
      	
    	//뉴스 불러오기
      	mockMvc.perform(MockMvcRequestBuilders.get("/news/{id}",insertResultNews.getId()))
  			.andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("새로운 뉴스"))
  			.andDo(print());
      	
    }

    @Test
    public void updateNewsTest() throws Exception {
    	//뉴스 불러오기
      	mockMvc.perform(MockMvcRequestBuilders.get("/news/{id}",1))
  			.andExpect(status().isOk())
  			.andDo(print());
      	
    	//뉴스 수정
    	News updateNews = new News();
    	updateNews.setTitle("수정된 1번 뉴스");
    	updateNews.setContents("수정된 뉴스 컨텐츠");
    	updateNews.setDate(new Date());
    	updateNews.setAuthor("Taes-k");
    	updateNews.setType("sports");
    	
      	mockMvc.perform(MockMvcRequestBuilders.put("/news/{id}",1)
		        .contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(updateNews)))
				.andExpect(status().isOk())
      			.andDo(print());
      	
    	//뉴스 불러오기
      	mockMvc.perform(MockMvcRequestBuilders.get("/news/{id}",1))
  			.andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("수정된 1번 뉴스"))
  			.andDo(print());
      	
    }

}

