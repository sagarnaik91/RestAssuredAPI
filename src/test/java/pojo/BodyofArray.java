package pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BodyofArray {
	@Test
	public void finalReq() throws JsonProcessingException {
		BodyofArrayPOJO Sagar = new BodyofArrayPOJO();
		Sagar.setFirst_name("Sagar");
		Sagar.setLast_name("Naik");
		Sagar.setEmp_no(123);

		BodyofArrayPOJO Apeksha = new BodyofArrayPOJO();
		Apeksha.setFirst_name("Apeksha");
		Apeksha.setLast_name("Nayak");
		Apeksha.setEmp_no(456);

		List<BodyofArrayPOJO> ArrayReq = new ArrayList<BodyofArrayPOJO>();
		ArrayReq.add(Sagar);
		ArrayReq.add(Apeksha);

		ObjectMapper obj = new ObjectMapper();
		String req = obj.writerWithDefaultPrettyPrinter().writeValueAsString(ArrayReq);
		System.out.println(req);
	}
}
