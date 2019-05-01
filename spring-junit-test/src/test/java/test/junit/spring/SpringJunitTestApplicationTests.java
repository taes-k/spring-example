package test.junit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJunitTestApplicationTests {

	@Autowired
	Calc calc;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void calcTest() {
		//Calc sum(a,b) Test 3+4 = 8
		int sum = calc.sum(3, 4);
		assertEquals(8,sum);
		
		//Calc div(a,b) Test 3-4 = -1
		int sub = calc.sub(3, 4);
		assertEquals(-1,sub);
		
		//Calc multiply(a,b) Test 3*4 = 12
		int mul = calc.mul(3, 4);
		assertEquals(12,mul);

		//Calc multiply(a,b) Test 3/4 = 12
		int div = calc.div(12, 4);
		assertEquals(3,div);
	}
	
	@Test(expected=RuntimeException.class)
	public void exceptionTest() {
		//Calc expected divide by zero exception
		int div2 = calc.div(3, 0);
	}
}
