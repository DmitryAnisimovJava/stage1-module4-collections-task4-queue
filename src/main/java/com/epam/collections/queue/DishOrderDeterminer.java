package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
    	List<Integer> listOfDishesIntegers = new ArrayList<>();
    	if (numberOfDishes <= 0) {
			return listOfDishesIntegers;
		}
    	PriorityQueue<Integer> resultQueue = new PriorityQueue<>(new DishComparator(everyDishNumberToEat));
    	for (int i = 1; i <= numberOfDishes; i++) {
			resultQueue.add(i);
		}
    	while (resultQueue.peek() != null) {
			listOfDishesIntegers.add(resultQueue.poll());
		}
    	return listOfDishesIntegers;
    }
}

class DishComparator implements Comparator<Integer> {
	int everyDishNumberToEat;
	public DishComparator(int everyDishNumberToEat) {
		this.everyDishNumberToEat = everyDishNumberToEat;
	}
	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 % everyDishNumberToEat == 0 & o2 % everyDishNumberToEat == 0 & o2 > o1) {
			return -1;
		} else if (o2 % everyDishNumberToEat == 0 & o1 % everyDishNumberToEat == 0 & o2 < o1) {
			return 1;
		} else if (o1 % everyDishNumberToEat == 0 & o2 % everyDishNumberToEat != 0) {
			return -1;
		} else if (o1 % everyDishNumberToEat != 0 & o2 % everyDishNumberToEat == 0) {
			return 1;
		}
		return 0;
	}
}