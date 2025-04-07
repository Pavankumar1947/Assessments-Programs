package cognizant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class PrintMaxNumberOfUniqueNumbers {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        int maxUnique = 0;
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
                
                int removed = deque.removeFirst();
                map.put(removed, map.get(removed) - 1);
                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }
        }
        
        System.out.println(maxUnique);
        }
	

}
