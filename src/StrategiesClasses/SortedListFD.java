package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import DataStructures.SortedList.*;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Diego Martinez Garcia
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Fernando J. Bermudez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V> extends AbstractMap.SimpleEntry<K, V>
																	 implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}

	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a SortedList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @author Diego Martinez Garcia
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		//SortedArrayList where we will organize all elements in dataSet
		SortedArrayList<ComparableEntry<E, Integer>> sortedList = new SortedArrayList<>(dataSet.size());
		//ArrayList that will be returned at the end with all the entries 
		ArrayList<Map.Entry<E, Integer>> result = new ArrayList<Map.Entry<E, Integer>>();
		
		for(E element: dataSet) {
			boolean found = false;//flag
			
			//adding elements of dataSet to sortedList
			for(int i = 0; i<sortedList.size() && !found; i ++) {
				Map.Entry<E, Integer> curEntry = sortedList.get(i);//Saving current Entry on variable.

				if(curEntry.getKey().compareTo(element) >= 0) { //breaking out of loop if element is bigger than key of curEntry 
					if(curEntry.getKey().equals(element)) { // checking if Entry is the Entry of element 
						curEntry.setValue(curEntry.getValue() + 1);
						found = true;
					}
				}
				else break;//breaking out of loop if key is larger than current element
			}
			//Entry not found
			if(!found) {
				//Creating new Entry and adding it to ArrayList
				ComparableEntry<E, Integer> newEntry = new ComparableEntry<E, Integer>(element, 1);
				sortedList.add(newEntry);
			}
		}
		
		for(int i = 0; i<sortedList.size(); i ++) {//Adding entries in sortedList to result array
			result.add(sortedList.get(i));
		}
		return result;
	}

}