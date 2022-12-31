package com.wch.waveAlgorithm.Interface;

/**
 * Интерфейс обьектов способных к запоминанию событий и обьектов.
 * @param <U>
 */
public interface Memorable <U> {
	/**
	 * метод добавления воспоминания
	 * @param memories
	 */
	void  addMemories(U memories);
	
	/**
	 * метод удаления воспоминаний
	 */
	void clearMemories();
}
