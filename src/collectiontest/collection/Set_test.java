package collectiontest.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;



//import com.fasterxml.jackson.databind.ObjectMapper;

public class Set_test {
	
	public static void main(String[] args) {
		
//		List<Long> l1 = Arrays.asList(1l,2l,3l,0l,1l ) ;
//		System.out.println(l1);
//		Set<Long> s1 = new HashSet<>(l1);
//		System.out.println(s1);
//		
//		List<String> l2 = Arrays.asList("220001","220002","220004","220001" ) ;
//		System.out.println(l2);
//		Set<String> s2 = new HashSet<>(l2);
//		System.out.println(s2);
//		
	
		List<MapObject> mapObjects = new ArrayList<>();
		int i =0;
		while(i < 2)
		{
			MapObject mapObject = new MapObject("1002"+i,"123456789"+i);
			MapObject mapObject2 = new MapObject("1002"+i,"123456788"+i);
					mapObjects.add(mapObject);
					mapObjects.add(mapObject2);
					i++;
		}
		System.out.println(mapObjects);
		
		List<Long> collect = mapObjects.stream().filter(Objects::nonNull).filter(o -> StringUtils.equalsIgnoreCase("10021", o.getKey()))
				.map(o -> {
					return Long.valueOf(o.getCustomerId());
				}).collect(Collectors.toList());
		
		System.out.println(collect);
		
		Response response = new Response();
		CustomerDomestic domestic1 = new CustomerDomestic(true, 1234567891L);
		CustomerDomestic domestic2 = new CustomerDomestic(false, 1234567881L);
		response.setCustomers(Arrays.asList(domestic1,domestic2));
		System.out.println(response);
		
		List<MapObject> mapObjects2 = new ArrayList<>();
		
		response.getCustomers().stream().filter(Objects::nonNull)
		.forEach(customerPlan -> {
			mapObjects.stream().filter(Objects::nonNull).filter(o -> StringUtils.equalsIgnoreCase("10021", o.getKey()))
			.map(o -> {
				MapObject mapObject = new MapObject("22000",customerPlan.getIsDomestic()? "Y" :"N");
				mapObjects2.add(mapObject);
				mapObjects2.add(o);
				return mapObjects2;
			}).collect(Collectors.toList());
		});
		System.out.println("!!!!!!!!!");
		System.out.println(mapObjects2);
		
//		ObjectMapper obj = new ObjectMapper();
//		obj.writeValueAsString(mapObjects2);
	}
	
	
}
