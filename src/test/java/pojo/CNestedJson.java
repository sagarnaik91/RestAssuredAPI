package pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CNestedJson {
	@Test
	public static void nestedJson() throws JsonProcessingException {
		CDetailsPOJO details = new CDetailsPOJO();
		details.setName("Sagar");
		details.setLastname("Naik");
		// details.setMobiles(123);

		CAddressPOJO add = new CAddressPOJO();
		add.setLine1("abc");
		add.setLine2("xyz");

		List<Integer> mobiles = new ArrayList<>();
		mobiles.add(123);
		mobiles.add(456);
		details.setMobiles(mobiles);
		CAddressPOJO address = new CAddressPOJO();
		address.setLine1("abc");
		address.setLine2("432");
		details.setAddress(address);
		ObjectMapper obj = new ObjectMapper();
		String jes = obj.writerWithDefaultPrettyPrinter().writeValueAsString(details);
		System.out.println(jes);
	}
}
