package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.*;
public class Logic_Counts extends Thread implements Para{
	private Random random= new Random();
	private int Total=100;

	private List<Count> countList=new ArrayList<>();
	private final List<Integer> numbers = new ArrayList<>();
	private final List<String> dni = new ArrayList<>();

	public synchronized int CountsGene() {
		int num;
		do {
			num = random.nextInt(900000000) + 100000000;
		}while(numbers.contains(num));
		numbers.add(num);
		return num;

	}
	public synchronized String DniGene() {
		String num;
		do {
			num = String.format("%010d", random.nextInt(1000000000));
		} while (dni.contains(num));
		dni.add(num);
		return num;

	}
	public void CountGenerator() {
		for (int i = 0; i < Total; i++) {
			int id = i + 1;
			int num_count = CountsGene();
			String type_count=switch((int)(Math.random()*3)) {
			case 0->"Ahorros";
			case 1->"Corriente";
			case 2->"empresa";
			default -> "No existe";

			};
			String dni_person = DniGene();
			int currency = (int) (random.nextDouble() * 1000); 
			Count newcount = new Count(id, num_count, type_count, dni_person, currency);
			countList.add(newcount);
			CountDAO dao = new CountDAO(newcount);
			dao.insetCuenta(); 
		}
	}
	public void run() {
		CountGenerator();
	}

}
