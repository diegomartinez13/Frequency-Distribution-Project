package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class corresponds to the Sequential strategy to count frequencies in an
 * array list.
 * @author Fernando J. Bermudez && Diego Martinez Garcia
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SequentialFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public SequentialFD() {
		super("Sequential");
	}
	/**
	 * Method that counts the frequency of a dataSet with a regular ArrayList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * one by one without any sorting or re-arrangement of the elements
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		//ArrayList where entries will be stored.
		ArrayList<Map.Entry<E, Integer>> resultList = new ArrayList<Map.Entry<E, Integer>>();
		
		//Looping inside dataSet to count frequency of element and adding them to ArrayList in form of a Entry,\.
		for(E element: dataSet) {
			boolean found = false; // flag.
			
			//looping inside of ArrayList to see of Entry of element exist.
			for(int i = 0; i<resultList.size() && !found; i ++) {
				Map.Entry<E, Integer> curEntry = resultList.get(i);//Saving current Entry on variable.
				
				if(curEntry.getKey().equals(element)) {// checking if Entry is the Entry of element 
					curEntry.setValue(curEntry.getValue() + 1);
					found = true;
				}
			}
			
			//Entry not found
			if(!found) {
				//Creating new Entry and adding it to ArrayList
				Map.Entry<E, Integer> newEntry = new AbstractMap.SimpleEntry<E, Integer>(element, 1);
				resultList.add(newEntry);
			}
		}
		
		return resultList;//Returning ArrayList
	}//End of method

}
