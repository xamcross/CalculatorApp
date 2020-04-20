package acceptance;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import xam.cross.AppRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ContextConfiguration(classes = AppRunner.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class CucumberSpringContextConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);

	/**
	 * Need this method so the cucumber will recognize this class as glue and load spring context configuration
	 */
	@Before
	public void setUp() {
		LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
	}
}
