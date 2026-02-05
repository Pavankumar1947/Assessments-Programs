package eMudhra;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// input = Java is easy and Java is powerful
// output =   java : 2
			//powerful : 1
			//and : 1
			//is : 2
			//easy : 1

public class FrequencyOfWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();
        
        Map<String, Long> wordCount =
                Arrays.stream(input.toLowerCase().split(" "))
                      .collect(Collectors.groupingBy(
                              word -> word,
                              Collectors.counting()
                      ));
        wordCount.forEach((k, v) -> System.out.println(k + " : " + v));
	}

}
