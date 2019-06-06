package start.mvc.spring;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import start.mvc.spring.controller.NewsController;
import start.mvc.spring.service.MainNewsServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainNewsServiceImpl mainNewsServiceImpl;

    @Test
    public void getNewsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/news"))
        .andExpect(status().isOk())
        .andDo(print());
    }
}

