package com.wch.waveAlgorithm.Project;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Поисковик кротчайшего пути от отдной точки до второй, хранит в себе экземпляр продвинутого степпера и линкедлиста для хранения найденного пути и координат найденных выходов.
 */
public class FindShortWayAdvance {
	private AdvanceStepper advanceStepper;
	private LinkedList<int[]> shortWay = new LinkedList<>();
	private LinkedList<int[]> finish = new LinkedList<>();
	
	/**
	 *
	 * @param advanceStepper
	 * @param shortWay
	 * @param finish
	 */
	public FindShortWayAdvance(AdvanceStepper advanceStepper, LinkedList<int[]> shortWay, LinkedList<int[]> finish) {
		this.advanceStepper = advanceStepper;
		this.shortWay = shortWay;
		this.finish = finish;
	}
	
	/**
	 *
	 */
	public FindShortWayAdvance() {
	}
	
	/**
	 *
	 * @return
	 */
	public AdvanceStepper getAdvanceStepper() {
		return advanceStepper;
	}
	
	/**
	 *
	 * @param advanceStepper
	 */
	public void setAdvanceStepper(AdvanceStepper advanceStepper) {
		this.advanceStepper = advanceStepper;
	}
	
	/**
	 *
	 * @return
	 */
	public LinkedList<int[]> getShortWay() {
		return shortWay;
	}
	
	/**
	 *
	 * @param shortWay
	 */
	public void setShortWay(LinkedList<int[]> shortWay) {
		this.shortWay = shortWay;
	}
	
	/**
	 *
	 * @return
	 */
	public LinkedList<int[]> getFinish() {
		return finish;
	}
	
	/**
	 *
	 * @param finish
	 */
	public void setFinish(LinkedList<int[]> finish) {
		this.finish = finish;
	}
	
	/**
	 * Метод продвинутого распространения волны по 8 направлениям.
	 */
	public void advanceWaveScan() {
		int count = 2;
		int[] point;
		LinkedList<int[]> temp = new LinkedList<>();
		LinkedList<int[]> fin = new LinkedList<>();
		int[] start = advanceStepper.getStartPoint();
		Deque<int[]> points = new LinkedList<>();
		points.push(start);
		boolean flag = true;
		while (flag) {
			while (!points.isEmpty()) {
				point = points.pollFirst();
				for (int[] a : advanceStepper.getSteppers()
				) {
					if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == 0) {
						advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
						temp.addLast(new int[]{point[0] + a[0], point[1] + a[1]});
						if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == -2) {
							fin.addFirst(new int[]{point[0] + a[0], point[1] + a[1]});
						}
					}
					if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == -2) {
						fin.addFirst(new int[]{point[0] + a[0], point[1] + a[1]});
						advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
					}
				}
				int num = 1;
				for (int[] a : advanceStepper.getAdvannceSteps()
				) {
					if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == 0) {
						if (num == 1){
							if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] - 1] == count ||
									advanceStepper.getGameField().getField()[point[0] + a[0] + 1 ][point[1] + a[1]] == count){
								advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
								temp.addLast(new int[]{point[0] + a[0], point[1] + a[1]});
							}
						} else if (num == 2) {
							if (advanceStepper.getGameField().getField()[point[0] + a[0] - 1][point[1] + a[1]] == count ||
								advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] - 1] == count) {
								advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
								temp.addLast(new int[]{point[0] + a[0], point[1] + a[1]});
							}
						} else if (num == 3) {
							if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] + 1] == count ||
							advanceStepper.getGameField().getField()[point[0] + a[0]  - 1][point[1] + a[1]] == count) {
								advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
								temp.addLast(new int[]{point[0] + a[0], point[1] + a[1]});
							}
						} else if (num == 4) {
							if (advanceStepper.getGameField().getField()[point[0] + a[0] + 1][point[1] + a[1]] == count ||
									advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] + 1] == count){
							advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
							temp.addLast(new int[]{point[0] + a[0], point[1] + a[1]});
							}
						}
					} else if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == -2) {
						if ((num == 1 &&
								advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] -1 ] == count ||
								num == 1 &&
										advanceStepper.getGameField().getField()[point[0] + a[0] + 1][point[1] + a[1]] == count) ||
								((num == 2 && (advanceStepper.getGameField().getField()[point[0] + a[0] - 1][point[1] + a[1]] == count)) ||
										(num == 2 && advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] - 1] == count)) ||
								(num == 3 && (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] + 1] == count) ||
										(num == 3 && advanceStepper.getGameField().getField()[point[0] + a[0] - 1][point[1] + a[1]] == count)) ||
								((num == 4 && (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1] + 1] == count)) ||
										(num == 4 && advanceStepper.getGameField().getField()[point[0] + a[0] + 1][point[1] + a[1]] == count))) {
							advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
							fin.addFirst(new int[]{point[0] + a[0], point[1] + a[1]});
						}
					}
					num++;
				}
			}
				if (temp.isEmpty()) break;
				else {
					count++;
					for (int[] b : temp
					) {
						points.push(b);
					}
				}
				temp.clear();
		}
		this.setFinish(fin);
	}
	
	/**
	 * Метод поиска обратного кротчайшего пути от первой найденной ранее точки финиша(выхода) с учетом особенностей продвинутого распространения сканирования.
	 * Метод получает координаты точки в виде массива целых чисел.
	 * @param finishe - массив координат положения точки выхода [x,y]
	 */
	public void  getReverseWay(int [] finishe){
		if(finishe != null) {
			int[] point = finishe.clone();
			LinkedList<int[]> shortWay = new LinkedList<>();
			shortWay.push(finishe);
			boolean flag;
			int number;
			while (true) {
				flag = true;
				number = advanceStepper.getGameField().getField()[point[0]][point[1]];
				if (number == 1) break;
				for (int[] a : advanceStepper.getAdvannceSteps()
				) {
					if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == number - 1) {
						shortWay.push(new int[]{point[0] + a[0], point[1] + a[1]});
						point = new int[]{point[0] + a[0], point[1] + a[1]};
						flag = false;
					}
				}
				if (flag){
					for (int[] a : advanceStepper.getSteppers()
					) {
						if (advanceStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == number - 1) {
							shortWay.push(new int[]{point[0] + a[0], point[1] + a[1]});
							point = new int[]{point[0] + a[0], point[1] + a[1]};
						}
					}
				}
			}
			this.setShortWay(shortWay);
		} else {
			System.out.println("На сгенерированном поле нет способа добраться до выхода из этой точки");
		}
	}
}
