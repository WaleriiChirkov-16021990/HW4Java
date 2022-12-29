package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Interface.Memorable;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MemoryPoint implements Memorable<int[]> {
	private Deque<int[]> memory1 = new LinkedList<>();
	private Deque<int[]> memory2 = new LinkedList<>();
	private ArrayList<Integer> memNumbers;
	
	public ArrayList<Integer> getMemNumbers() {
		return memNumbers;
	}
	
	public void setMemNumbers(ArrayList<Integer> memNumbers) {
		this.memNumbers = memNumbers;
	}
	
	public MemoryPoint() {
	}
	
	public MemoryPoint(Deque<int[]> memory1, Deque<int[]> memory2) {
		this.memory1 = memory1;
		this.memory2 = memory2;
	}
	
	public Deque<int[]> getMemory1() {
		return memory1;
	}
	
	public void setMemory1(Deque<int[]> memory1) {
		this.memory1 = memory1;
	}
	
	public Queue<int[]> getMemory2() {
		return memory2;
	}
	
	public void setMemory2(Deque<int[]> memory2) {
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
