package sortcomparison;

import java.util.*;

/**
 * @author rdwilliams1
 *
 */
public class BasicSorter implements Sorter {

	@Override
	public void insertionSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		int properIdx = 0;
		for (int i = 1; i < numberToSort; i++) {
			String tmp = data.get(firstIndex + i);
			if (tmp.compareTo(data.get(firstIndex + i - 1)) < 0) {
				for (int j = i; j > 0; j--) {
					if (tmp.compareTo(data.get(firstIndex + j - 1)) >= 0) {
						properIdx = j;
						break;
					} else if (j == 1) {
						properIdx = 0;
					}
				}
				data.remove(firstIndex + i);
				data.add(firstIndex + properIdx, tmp);
			}
		}
	}


	@Override
	public void quickSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		if (numberToSort > 1) {
			int ret = partition(data, firstIndex, numberToSort);
			quickSort(data, firstIndex, ret - firstIndex);
			quickSort(data, ret + 1, (firstIndex + numberToSort) - ret - 1);
		} else {
			insertionSort(data, firstIndex, numberToSort);
		}
	}


	@Override
	public int partition(ArrayList<String> data, int firstIndex, int numberToPartition) {
		// Mof3 clause
		Random rand = new Random();
		int a = firstIndex + rand.nextInt(numberToPartition);
		int b = firstIndex + rand.nextInt(numberToPartition);
		int c = firstIndex + (numberToPartition / 2);
		int pivIdx;
		if (data.get(a).compareTo(data.get(b)) > 0) {
			if (data.get(b).compareTo(data.get(c)) > 0) {
				pivIdx = b;
			} else if (data.get(a).compareTo(data.get(c)) > 0) {
				pivIdx = c;
			} else {
				pivIdx = a;
			}
		} else {
			if (data.get(a).compareTo(data.get(c)) > 0) {
				pivIdx = a;
			} else if (data.get(b).compareTo(data.get(c)) > 0) {
				pivIdx = c;
			} else {
				pivIdx = b;
			}
		}
		// Set Pivot to left side
		String tmp = data.get(firstIndex);
		data.set(firstIndex, data.get(pivIdx));
		data.set(pivIdx, tmp);
		int bigIdx = firstIndex + 1;
		int smallIdx = firstIndex + numberToPartition - 1;
		// compare and throw
		while (bigIdx < smallIdx) {
			while (bigIdx < smallIdx && data.get(bigIdx).compareTo(data.get(firstIndex)) <= 0)
				bigIdx++;
			while (smallIdx > firstIndex && data.get(smallIdx).compareTo(data.get(firstIndex)) > 0)
				smallIdx--;
			if (bigIdx < smallIdx) {
				tmp = data.get(bigIdx);
				data.set(bigIdx, data.get(smallIdx));
				data.set(smallIdx, tmp);
			}
		}
		if (data.get(firstIndex).compareTo(data.get(smallIdx)) >= 0) {
			tmp = data.get(smallIdx);
			data.set(smallIdx, data.get(firstIndex));
			data.set(firstIndex, tmp);
		}
		return smallIdx;


	}


	/**
	 * Sorts part or all of a list in ascending order.
	 * 
	 * mergeSort() must: - Call the insertionSort() function in this interface for segments of size 15 or less. - Call
	 * the merge() function in this interface to do its merging.
	 * 
	 * @param data
	 *            list of elements to sort
	 * @param firstIndex
	 *            Index of the first element to be sorted.
	 * @param numberToSort
	 *            The number of elements in the section to be sorted.
	 */
	@Override
	public void mergeSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		int half = numberToSort / 2;
		// if (numberToSort > 15) {
		if (half == 0)
			return;
		mergeSort(data, firstIndex, half);
		mergeSort(data, firstIndex + half, numberToSort - half);
		// } else {
		// insertionSort(data, firstIndex, numberToSort);
		// }
		merge(data, firstIndex, half, numberToSort - half);
	}


	/**
	 * Merges two sorted segments into a single sorted segment. The left and right segments are contiguous.
	 * 
	 * @param data
	 *            The list of elements to merge
	 * @param firstIndex
	 *            Index of the first element of the left segment.
	 * @param leftSegmentSize
	 *            The number of elements in the left segment.
	 * @param rightSegmentSize
	 *            The number of elements in the right segment.
	 */
	@Override

	public void merge(ArrayList<String> data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {
		ArrayList<String> tmp = new ArrayList<>();
		if (data.get(firstIndex + leftSegmentSize - 1).compareTo(data.get(firstIndex + leftSegmentSize)) < 0)
			return;
		int left = 0;
		int right = 0;
		while (left < leftSegmentSize && right < rightSegmentSize) {
			if (data.get(firstIndex + left).compareTo(data.get(firstIndex + right + leftSegmentSize)) <= 0) {
				tmp.add(data.get(firstIndex + left));
				left++;
			} else {
				tmp.add(data.get(firstIndex + leftSegmentSize + right));
				right++;
			}
		}
		if (right < rightSegmentSize) {
			for (int i = right; i < rightSegmentSize; i++) {
				tmp.add(data.get(firstIndex + leftSegmentSize + i));

			}
		} else if (left < leftSegmentSize) {
			for (int i = left; i < leftSegmentSize; i++) {
				tmp.add(data.get(firstIndex + i));
			}
		}
		for (int n = 0; n < leftSegmentSize + rightSegmentSize; n++) {
			data.set(firstIndex + n, tmp.get(n));
		}
	}


	public void myMerge(ArrayList<String> data, ArrayList<String> temp, int firstIndex, int leftSegmentSize,
			int rightSegmentSize) {

	}


	/**
	 * EXTRA CREDIT
	 * 
	 * Sorts the list in ascending order.
	 * 
	 * @param data
	 *            The list of elements to sort
	 */
	@Override
	public void heapSort(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}


	/**
	 * EXTRA CREDIT
	 * 
	 * Heapifies the given list.
	 * 
	 * @param data
	 *            The list to heapify.
	 */
	@Override
	public void heapify(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

}