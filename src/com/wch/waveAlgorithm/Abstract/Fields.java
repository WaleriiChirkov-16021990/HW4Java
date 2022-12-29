package com.wch.waveAlgorithm.Abstract;

public abstract class Fields {
	private int rows;
	private int columns;
	private int[][] field;
	
	public Fields(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public Fields() {
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int[][] getField() {
		return field;
	}
	
	public void setField(int[][] field) {
		this.field = field;
	}
	
	protected void setNewField(){
		this.field = new int[getRows()+2][getColumns()+2];
	}
	
	protected abstract void fillContourField();
	protected abstract void fillGameField();
	
	protected abstract void printField();
}
