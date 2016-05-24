package quartz;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class QuartzTest {

	@Test
	@Ignore
	public void job1test() {
		int times = 10 ;
		for (int i = 0; i < times; i++) {
			System.out.println("我是Job1的测试用例++++++++++++++++++");
			try {
				Thread.sleep(i*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
//	@Ignore
	public void job2test() {
		int times = 10 ;
		for (int i = 0; i < times; i++) {
			System.out.println("我是Job2的测试用例++++++++++++++++++");
			try {
				Thread.sleep(i*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
