package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Interface.Memorable;

import java.util.HashSet;

public class DataBase implements Memorable<MyGameField> {
	private HashSet<MyGameField> MapsCollections;
	
	public DataBase(HashSet<MyGameField> mapsCollections) {
		MapsCollections = mapsCollections;
	}
	
	public DataBase() {
		MapsCollections = new HashSet<>();
	}
	
	public HashSet<MyGameField> getMapsCollections() {
		return MapsCollections;
	}
	
	public void setMapsCollections(HashSet<MyGameField> mapsCollections) {
		MapsCollections = mapsCollections;
	}
	
	
	/**
	 * @param memories
	 */
	@Override
	public void addMemories(MyGameField memories) {
		this.MapsCollections.add(memories);
	}
	
	/**
	 *
	 */
	@Override
	public void clearMemories() {
		this.MapsCollections.clear();
	}
}
