package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * This class implements the Ordered strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Diego Martinez Garcia
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	/**
	 * Method that counts the frequency of a dataSet with a SORTED COPY of dataSet
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Map.Entry<E, Integer>> result = new ArrayList<Map.Entry<E,Integer>>();
		
		dataSet.sort(null); //sorting the dataSet before iteration
		
		if(result.isEmpty())//checking if arrayList is empty
			result.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(0),0));
		
		for(E element : dataSet) {//iterating through dataSet
			//saving current entry in a variable
			Map.Entry<E, Integer> curEntry = result.get(result.size()-1);
			
			if(curEntry.getKey().equals(element)) {//Entry key == element
				curEntry.setValue(curEntry.getValue() + 1);//updating value
			}
			else
				//Creating new Entry and adding it to ArrayList
				result.add(new AbstractMap.SimpleEntry<E, Integer>(element, 1));
			}
		return result;
	}
	

}
