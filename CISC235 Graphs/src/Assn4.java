import java.util.Scanner;


/*
 *  “I confirm that this
	submission is my own work and is consistent with the Queen's regulations on Academic
	Integrity.”
	10098522, 12nws
 */

class Neighbor {
	public int vertexNum;
	public Neighbor next;
	public Neighbor(int vNum, Neighbor nbr){
		this.vertexNum = vNum;
		next = nbr;
	}
}


class Vertex {
	int pos;
	Neighbor adjlist;
	int weight;
	Vertex(int pos, Neighbor neighbors, int w){
		this.pos = pos;
		this.weight = w;
		this.adjlist = neighbors;
	}
}



public class Assn4 {
	public static int[][][] list = new int[5][10][2];
	
	public static void main(String[] args) {
		
		int total = primsAlg();
		int total1 = BFS();
		
		System.out.println("The ratio is " + total/total1);
		
		
		int[] newList = randomGraph();
		
		int total2 = primsAlg();
		int total3 = BFS();
		
		System.out.println("The ratio is " + total2/total3);
	}

	public void testGraph() {
				//First Node
				list[0][0][0] = 2;
				list[0][0][1] = 15;
				list[0][0][2] = 0;
				
				list[0][1][0] = 4;
				list[0][1][1] = 7;
				list[0][1][2] = 0;
				
				list[0][2][0] = 5;
				list[0][2][1] = 10;
				list[0][2][2] = 0;
				
				//2nd Node
				list[1][0][0] = 1;
				list[1][0][1] = 15;
				list[1][0][2] = 0;
				
				list[1][1][0] = 3;
				list[1][1][1] = 9;
				list[1][1][2] = 0;
				
				list[1][2][0] = 4;
				list[1][2][1] = 11;
				list[1][2][2] = 0;
				
				list[1][3][0] = 6;
				list[1][3][1] = 7;
				list[1][3][2] = 0;
				
				//3rd node	
				list[2][0][0] = 2;
				list[2][0][1] = 9;
				list[2][0][2] = 0;
				
				list[2][1][0] = 5;
				list[2][1][1] = 12;
				list[2][1][2] = 0;
				
				list[2][2][0] = 6;
				list[2][2][1] = 7;
				list[2][2][2] = 0;
				
				//4th node
				list[3][0][0] = 1;
				list[3][0][1] = 7;
				list[3][0][2] = 0;
				
				list[3][1][0] = 2;
				list[3][1][1] = 11;
				list[3][1][2] = 0;
				
				list[3][2][0] = 5;
				list[3][2][1] = 8;
				list[3][2][2] = 0;
				
				list[3][3][0] = 6;
				list[3][3][1] = 14;
				list[3][3][2] = 0;
				
				//5th Node
				list[4][0][0] = 1;
				list[4][0][1] = 10;
				list[4][0][2] = 0;
				
				list[4][1][0] = 3;
				list[4][1][1] = 12;
				list[4][1][2] = 0;
				
				list[4][2][0] = 4;
				list[4][2][1] = 8;
				list[4][2][2] = 0;
				
				list[4][3][0] = 6;
				list[4][3][1] = 8;
				list[4][3][2] = 0;
				
				//6th Node
				list[5][0][0] = 2;
				list[5][0][1] = 9;
				list[5][0][2] = 0;
						
				list[5][1][0] = 3;
				list[5][1][1] = 7;
				list[5][1][2] = 0;
						
				list[5][2][0] = 4;
				list[5][2][1] = 14;
				list[5][2][2] = 0;
						
				list[5][3][0] = 5;
				list[5][3][1] = 8;
				list[5][3][2] = 0;
	}
	public static int primsAlg(){
		int startNum = (int)(Math.random()*1) + 6;
		int total = 0;
		int[] Q = new int[10];
		int[] VA = new int[10];
		VA[0] = startNum;
		int[] VR = new int[10];
		int n = 0;
		for (int i = 0; i < list.length;i++  ){
			if (i != startNum){
				VR[n] = i;
				n++;
			}
		}
		
		int j = 0;
		while (Q.length < list.length - 1){
			for(int m = 0; m < 10; m++){
				for(int k = 0; k < VA.length; k++){
					if((VA[k] == m) && (VR[k] == m)){
						Q[j] = m;
						j++;
						total += Q[j];
					}
				}
			}
		}
		
		return total;
		
	}

	
	public static int BFS(){
		int startNum = (int)(Math.random()*1) + 6;
		int total = 0;
		int[] Q = new int[6]; //create empty queue
		
		Q[0] = startNum; //append v to Q
		
		while(Q != null){ //while Q is not empty
			int x = Q[0]; //x is the first vertex in Q
			Q[0] = 0;  //remove x from Q
			int iter = 1;
			for(int i = 0; i < list[x].length; i++){ //for each neighbour y of x
				if(list[x][i][2] != 1){ //such that y isn't marked visited
					list[x][i][2] = 1; //mark y visited
					total += list[x][i][1]; //add edge to total graph weight
					Q[iter] = i; //append y to Q
					iter++; //iterate in Q
					System.out.println("Vertex " + x + " is the parent of Vertex " + "");
				}
			}
		}
		
		return total;
	}
	
	public static int[] randomGraph(){
		Scanner s = new Scanner(System.in);
		
		int answer = s.nextInt();
		System.out.println("How many vertices would you like?");
		int[] set = new int[answer];
		for(int i = 0; i < answer; i++){
			set[i] = i;
		}
		int x = (int)(Math.random()*1) + set.length -1;
		int[] newSet = new int[x];
		for(int k = 2; k < set.length; k++){
			int x1 = (int)(Math.random()*1) + set.length -1;
			for(int m = 0; m < x1; m++){
				newSet[k] = m;
			}
		}
		
		return newSet;
	}
}



/*
 * 
 * Written Portion!
 * 
 * With a lot of the ratios being around 0.2, I would guess that the ratio for when
 * n=2000 would be around 0.15.
 * Seeing as the ratio went down starting at 100, from 0.21(n=100) to 0.17(n=500) the 
 * ratio will not be going down too low. 
 * Seeing as the Weight's for the prims for when N=200 were around 2171, using this
 * to extrapolate we can induce that the ratio will go down to around 0.15
 */
