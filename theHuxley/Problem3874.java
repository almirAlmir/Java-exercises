package theHuxley;
//IMPORTS
import java.util.Scanner;

//Program by: Almir Alves de Souza Cruz
//24/05/2023

public class Problem3874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		CinCabeca c [] = new CinCabeca [2];
		for(int i = 0; i < 2; i++) {
			c[i] = new CinCabeca();
			c[i].setAge(input.nextInt());
			c[i].setId(input.nextInt());
			input.nextLine();
			c[i].setName(input.nextLine());
			
			if (isPrime(c[i].getAge()))
				c[i].addingPts(4);
			
			if(isPerfect(c[i].getId()))
				c[i].addingPts(3);
		}

		if(c[0].getName().compareTo(c[1].getName()) > 0) {
			c[0].addingPts(2);
		}else if(c[0].getName().compareTo(c[1].getName()) < 0) {
			
			c[1].addingPts(2);
		}
		
		if(c[0].getPoints() == c[1].getPoints()) {
			System.out.println("CInCABECAS EMPATADOS");
		}else {
			System.out.println((c[0].getPoints() > c[1].getPoints() ? c[0] : c[1]));
		}
	}
	
	public static boolean isPrime(int p) {
		
		if (p <= 1)	
			return false;
		
		for(int i = 2; i < Math.sqrt(p) ; i++) {
			
			if(p % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static boolean isPerfect(int p) {
		
		return (Math.pow(Math.sqrt(p), 2) == p);
	}
	
	public static class CinCabeca{
		
		private int age;
		private int id;
		private String name;
		private int points;
		
		public CinCabeca() {
			
			this.name = "";
			this.age = -1;
			this.id = -1;
			this.points = 0;
		}
		
		public void addingPts(int x) {
			this.points += x;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPoints() {
			return points;
		}

		@Override
		public String toString() {
			return name + " WINS";
		}
		
		
		
	}

}
