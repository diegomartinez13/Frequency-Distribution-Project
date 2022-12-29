package StrategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class implements the Map/Hash table strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Diego Martinez Garcia
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {
		super("Map");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a Hash table
	 * It uses a Hash table to count the frequency of each elements inside dataSet instead of Map.Entry
	 * like the previous strategies in this experiment
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		Hashtable<E, Integer> HT = new Hashtable<>();//HashTable where we will store our keys and counts
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<>();//ArrayList that will be returned
		
		for(E element: dataSet) {//Looping through dataSet
			
			if(HT.containsKey(element)) {//if key found 
				HT.put(element, HT.get(element)+1);//Adding to the count
			}
			else {//Not found
				HT.put(element, 1);//creating new pair
			}
		}
		
		for(Map.Entry<E, Integer> e: HT.entrySet()) {//Adding each Entry in HashTable to ArrayList
			results.add(e);
		}
		
		
		return results; //Returning ArrayList with Entries
	}

}
