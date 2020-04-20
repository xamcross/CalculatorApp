package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsDefinitions extends CucumberSpringContextConfiguration {

	private RestTemplate restTemplate = new RestTemplate();
	private String first;
	private String second;
	private String result;
	@LocalServerPort
	protected int port;

	@Given("^I have two numbers: (.+) and (.+)$")
	public void givenTwoNumbers(final String first, final String second) {
		this.first = first;
		this.second = second;
	}

	@When("^the calculator sums them$")
	public void the_calculator_sums_them() throws Throwable {
		String url = String.format("http://localhost:%s/calculator?first=%s&second=%s", port, first, second);
		result = restTemplate.getForObject(url, String.class);
	}

	@Then("^I receive (.+) as a result$")
	public void i_receive_as_a_result(final String expectedResult) throws Throwable {
		assertEquals(expectedResult, result);
	}
}
