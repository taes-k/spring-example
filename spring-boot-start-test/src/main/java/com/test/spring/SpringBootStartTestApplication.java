package com.test.spring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStartTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartTestApplication.class, args);

		String[] participant = new String[]{"a", "b", "c"};
		String[] completion = new String[]{"a", "b"};
		String answer = "";
		for(int i=0; i<participant.length; i++){
			System.out.print(stringcheck(completion, participant[i]));
			if(!stringcheck(completion, participant[i])) {
				answer = participant[i];
				break;
            }
        }
		System.out.print(answer);
		 
//		String answer = "";
//        Stream<String> stream = Arrays.stream(arr).filter(str -> str.contains("a"));
//        
//	    stream.forEach(str->System.out.print(str+" "));
	        
	}
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        //String[] dropper = find(participant, completion);
        
        for(int i=0; i<participant.length; i++){
        if(stringcheck(completion, participant[i]))
            answer = participant[i];
            break;
        }
        //for(String el : dropper)
        //    System.out.println(el);
        
        //answer = dropper[0];
        return answer;
    }
    
	public static boolean stringcheck(String[] arr, String targetValue) {
	
	  Set<String> set = new HashSet<String>(Arrays.asList(arr));
	
	  return set.contains(targetValue);
	
	}
}
