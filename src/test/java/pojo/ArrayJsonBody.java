package pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArrayJsonBody {
	@Test
	public static void bodyConstruct() throws JsonProcessingException
	{
		ArrayJson Sagar=new ArrayJson();
		Sagar.setFirstname("Sagar");
		Sagar.setLastname("Naik");
		Sagar.setEmpnumber(123);
		
		ArrayJson apeksha=new ArrayJson();
		apeksha.setFirstname("Apeksha");
		apeksha.setLastname("Nayak");
		apeksha.setEmpnumber(123);
		
		List<ArrayJson> finalReq=new ArrayList<ArrayJson>();
		finalReq.add(Sagar);
		finalReq.add(apeksha);
		ObjectMapper printReq=new ObjectMapper();
		String res=printReq.writerWithDefaultPrettyPrinter().writeValueAsString(finalReq);
		System.out.println(res);
		
	}

}
