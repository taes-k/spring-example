package start.mvc.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.activation.DataSource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import start.mvc.spring.dao.NewsDao;
import start.mvc.spring.entity.News;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class NewsDaoUnitTest {

	@Autowired private NewsDao newsDao;

    @Test
    public void findAllTest() {
        List<News> newsList = newsDao.findAll();
        assertThat(newsList)
		        .isNotEmpty()
		        .hasSize(3);
    }

}