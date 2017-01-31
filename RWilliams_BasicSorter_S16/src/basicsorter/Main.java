package sortcomparison;

import java.util.*;

public class Main {


	public static void main(String[] args) {
		BasicSorter sorter = new BasicSorter();
		ArrayList<String> list = new ArrayList<>(26);
		for (char i = 'a'; i <= 'z'; i++) {
			list.add(String.valueOf(i));
		}
		Collections.shuffle(list);
		// sorter.insertionSort(list, 0, list.size());
		sorter.mergeSort(list, 0, 26);
		for (String i : list)
			System.out.println(i);

	}
}
