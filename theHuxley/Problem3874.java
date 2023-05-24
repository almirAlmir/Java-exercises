package theHuxley;
//IMPORTS
import java.util.Scanner;

//Program by: Almir Alves de Souza Cruz
//24/05/2023

public class Problem3874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CinCabeca c1 = new CinCabeca("Almir", 26, 97);
		
		System.out.println(c1);
	}
	
	public static class CinCabeca{
		
		private int age;
		private int id;
		private String name;
		
		public CinCabeca(String name, int age, int id) {
			
			this.name = name;
			this.age = age;
			this.id = id;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getId() {
			return this.id;
		}
		
		public int getAge() {
			return this.age;
		}
		
	}

}
