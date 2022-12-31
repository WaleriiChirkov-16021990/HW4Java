package com.wch.waveAlgorithm.Abstract;

/**
 * Абстрактное представление любого поля.
 */
public abstract class Fields {
	private int rows;
	private int columns;
	private int[][] field;
	
	/**
	 * Конструктор по переданным целым числам создает поле в размер.
	 * @param rows - строки
	 * @param columns - столбцы
	 */
	public Fields(int rows, int columns) {
		if(rows > 2 && columns > 2) {
			this.rows = rows;
			this.columns = columns;
		} else {
			System.out.println("\nВы ввели не корректный размер поля. \nСгенерирован шаблон 10х10.");
			this.rows = 10;
			this.columns = 10;
		}
	}
	
	public Fields() {
	}
	
	/**
	 *
	 * @return
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 *
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 *
	 * @return
	 */
	public int getColumns() {
		return columns;
	}
	
	/**
	 *
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	/**
	 *
	 * @return
	 */
	public int[][] getField() {
		return field;
	}
	
	/**
	 *
	 * @param field
	 */
	public void setField(int[][] field) {
		this.field = field;
	}
	
	/**
	 *
	 */
	protected void setNewField(){
		this.field = new int[getRows()+2][getColumns()+2];
	}
	
	/**
	 *
	 */
	protected abstract void fillContourField();
	
	/**
	 *
	 */
	protected abstract void fillGameField();
	
	/**
	 *
	 */
	protected abstract void printField();
}
