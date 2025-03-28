package indihood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsEx {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Pavan","Pushpa","Raj","Rakshith","Manohar");
		
		// withou Streams
//		List<String> filtNames = new ArrayList<>();
//		for(String pavan : names) {
//			if(pavan.startsWith("P")){
//				filtNames.add(pavan);
//			}
//		}
//		System.out.println(filtNames);
		
		
//		with Streams
		List<String> filtNames = names.stream()
				.filter(name->name.startsWith("P"))
				.collect(Collectors.toList());
		System.out.println(filtNames);
		
		
	
	}
}
