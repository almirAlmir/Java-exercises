package theHuxley;
//IMPORTS
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;


//Program by: Almir Alves de Souza Cruz
//18/05/2023
//LEMBRE DE COLOCAR A DATA CERTA QUANDO ACABAR
public class Problem4042 {
	
final static int [] horizontal = {-1, 1, 0, 0};	
final static int [] vertical = {0, 0, -1, 1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//input.nextLine();
		String ml = input.nextLine(); //matrix length
		int line = Integer.parseInt(ml.substring(0, 1));
		int column = Integer.parseInt(ml.substring(2));
		char [] [] labyrinth = new char [line] [column];
		Coord [] origemDestino = new Coord[2];
		
		for(int i = 0; i < line; i++) {
			
		
			String str = input.nextLine();
			
			for(int j = 0; j < column; j++) {
				
				labyrinth [i] [j] = str.charAt(j);
				
				if(labyrinth [i][j] == 'o') {
		 
					origemDestino[0] = new Coord(i, j);
				}else if(labyrinth [i][j] == 'd') {
					
					origemDestino[1] = new Coord(i, j);
				}
				
			}
		}
			
		int result = BFS(origemDestino[0], origemDestino[1], labyrinth);
		
		if(result == -1) {
			System.out.println("Poxa... Parece que nao foi dessa vez que Rebeka conseguiu fugir");
		}else {
			System.out.println("Apos correr "+result+" metros e quase desistir por causa da distância, Rebeka conseguiu escapar!");
		}
		
	}
	
	public static int BFS(Coord o, Coord d, char [][] lab) {
		
		BlockingQueue<Coord> coordQueue = new LinkedBlockingQueue<>(); //frontier
		coordQueue.add(o);
		
		int [][] visited = new int [lab.length] [lab[0].length];
		int [][] dist = new int [visited.length] [visited[0].length];
		
		do {
		
			Coord checkingNow = coordQueue.poll();
			if(checkingNow.x == d.x && checkingNow.y == d.y)
				return dist[checkingNow.x][checkingNow.y];
			
			//Here I need to implement the <- ^ -> v moves(left, up, right, down)
			for(int i = 0; i < 4; i++) {
				
				int nextX = checkingNow.x + horizontal[i];
				int nextY = checkingNow.y + vertical[i];
				
				boolean insideMatrix = false;
				
				if(nextX >= 0 && nextY >= 0 && nextX < lab.length && nextY < lab[0].length) {
					insideMatrix = true;
				}
				
				if(insideMatrix && lab[nextX][nextY] != '#' && visited[nextX][nextY] == 0) {
					
					dist[nextX][nextY] = 1 + dist[checkingNow.x][checkingNow.y];
					visited[nextX][nextY] = 1;
					coordQueue.add(new Coord(nextX, nextY));
				}
				
			}
			
			
			//Do this 'til found D or end the matrix
			
		}while(!coordQueue.isEmpty());
		
		return -1;
	}
	
	public static class Coord{
		//representa o ponto X e Y da matriz onde o elemento se encontra
		private int x;
		private int y;
		
		public Coord(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
		
		
	}
	

}
