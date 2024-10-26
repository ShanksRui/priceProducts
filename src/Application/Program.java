package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String,Double> map = new TreeMap<>();
		System.out.print("Enter full file path:");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String file;
			Integer sum = 0;
			while((file = br.readLine()) != null) {
				String[] vect = file.split(",");
				map.put(vect[0], Double.parseDouble(vect[1]));	
				sum++;
			}
				Double[] max = {0.0};
				map.entrySet().forEach(mp -> max[0] += mp.getValue());
				Integer quantity = map.size();
			    Double full =  max[0] / quantity;
			    
			    Comparator<String> comp = (x,y) -> x.toUpperCase().compareTo(y.toUpperCase());			    			    
			    map.entrySet().removeIf(P -> P.getValue() > full);
			    
			    List<String> list = new ArrayList<>(map.keySet());		
			    list.sort(comp.reversed());		    
			    list.forEach(System.out::println);
			    System.out.println(String.format("%.2f", full));	
			    	
		}catch(IOException e) {
			System.out.println("Error:"+e.getMessage());
		}
	}
}
