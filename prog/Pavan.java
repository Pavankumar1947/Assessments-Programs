package prog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pavan {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            list.add(scanner.nextInt());
	        }
	        int Queue = scanner.nextInt();
	        scanner.nextLine();
	        for(int i = 0; i < Queue; i++){
	            String Command = scanner.next();
	            if(Command.equals("Insert")) {
	                int a = scanner.nextInt();
	                int b = scanner.nextInt();
	                list.add(a,b);
	            } else if(Command.equals("Delete")) {
	                int pos = scanner.nextInt();
	                list.remove(pos);
	            }
	        }
	        for(int num:list){
	            System.out.print(num+" ");
	        }
	    }
	}


