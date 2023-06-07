package theHuxley;
//IMPORTS
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;


//Program by: Almir Alves de Souza Cruz
//24/05/2023
//LEMBRE DE COLOCAR A DATA CERTA QUANDO ACABAR
public class Problem4042 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//input.nextLine();
		String ml = input.nextLine(); //matrix length
		int line = Integer.parseInt(ml.substring(0, 1));
		int column = Integer.parseInt(ml.substring(2));
		char [] [] labyrinth = new char [line] [column];
		
		
		for(int i = 0; i < line; i++) {
			
		
			String str = input.nextLine();
			
			for(int j = 0; j < column; j++) {
				
				labyrinth [i] [j] = str.charAt(j);
				
			}
		}
	
		
	}
	
	public int BFS(Coord o, Coord d, char [][] lab) {
		
		BlockingQueue<Coord> coordQueue = new LinkedBlockingQueue<>();
		coordQueue.add(o);
		
		int [][] visited = new int [lab.length] [lab[0].length];
		int [][] dist = new int [visited.length] [visited[0].length];
		
		do {
		
			Coord checkingNow = coordQueue.poll();
			if(checkingNow.x == d.x && checkingNow.y == d.y)
				return dist[checkingNow.x][checkingNow.y];
			
			//Here I need to implement the <- ^ -> v moves(left, up, right, down)
			
			//each cell I visit I'll mark visited and put in the Queue
			
			//Do this 'til found D or end the matrix
			
		}while(!coordQueue.isEmpty());
		
		return -1;
	}
	
	public class Coord{
		//representa o ponto X e Y da matriz onde o elemento se encontra
		private int x;
		private int y;
		
		public Coord(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
		
	}
	

}
