package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Interface.Memorable;

import java.util.ArrayList;
import java.util.Queue;

public class MemoryPoint implements Memorable<int[]> {
	private Queue<int[]> memory1;
	private Queue<int[]> memory2;
	private ArrayList<Integer> memNumbers;
	
	public ArrayList<Integer> getMemNumbers() {
		return memNumbers;
	}
	
	public void setMemNumbers(ArrayList<Integer> memNumbers) {
		this.memNumbers = memNumbers;
	}
	
	public MemoryPoint() {
	}
	
	public MemoryPoint(Queue<int[]> memory1, Queue<int[]> memory2) {
		this.memory1 = memory1;
		this.memory2 = memory2;
	}
	
	public Queue<int[]> getMemory1() {
		return memory1;
	}
	
	public void setMemory1(Queue<int[]> memory1) {
		this.memory1 = memory1;
	}
	
	public Queue<int[]> getMemory2() {
		return memory2;
	}
	
	public void setMemory2(Queue<int[]> memory2) {
		this.memory2 = memory2;
	}
	
	@Override
	public void addMemories(int[] mem) {
		this.memory1.add(mem);
	}
	
	@Override
	public void clearMemories() {
		this.memory1.clear();
		this.memory2.clear();
	}
}
