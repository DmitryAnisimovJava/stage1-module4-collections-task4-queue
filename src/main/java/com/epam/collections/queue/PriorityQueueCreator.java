package com.epam.collections.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
    	PriorityQueue<String> myPriorityQueue = new PriorityQueue<>(new CompatarotForPriority());
    	myPriorityQueue.addAll(firstList);
    	myPriorityQueue.addAll(secondList);
    	return myPriorityQueue;
    }
}

class CompatarotForPriority implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (o1.compareTo(o2) < 0) {
			return 1;
		}
		if (o1.compareTo(o2) > 0) {
			return -1;
		}
		return 0;
	}
}