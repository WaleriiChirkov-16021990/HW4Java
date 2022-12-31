package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Interface.Memorable;

import java.util.HashSet;

/**
 * Класс сущности, которая сохраняет сгенерированные MyGameField, для дальнешей передачи  , хранения и анализа.
 */
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
	 * Данный метод пополняет временную БД.
	 * @param memories - объект класса MyGameField
	 */
	@Override
	public void addMemories(MyGameField memories) {
		this.MapsCollections.add(memories);
	}
	
	/**
	 * Очистка временной БД
	 */
	@Override
	public void clearMemories() {
		this.MapsCollections.clear();
	}
}
