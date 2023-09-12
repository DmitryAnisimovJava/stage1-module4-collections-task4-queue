package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
    	ArrayDeque<Integer> finalArrayDeque = new ArrayDeque<>();
    	finalArrayDeque.add(firstQueue.remove());
    	finalArrayDeque.add(firstQueue.remove());
    	finalArrayDeque.add(secondQueue.remove());
    	finalArrayDeque.add(secondQueue.remove());
    	while (firstQueue.peek() != null && secondQueue.peek() != null ) {
			firstQueue.add(finalArrayDeque.removeLast());
			for (int i = 0; i < 2; i++) finalArrayDeque.add(firstQueue.remove());
			secondQueue.add(finalArrayDeque.removeLast());
			for (int i = 0; i < 2; i++) finalArrayDeque.add(secondQueue.remove());
		}
    	return finalArrayDeque;
    }
}
