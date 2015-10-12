/**
 * 
 * 10098522, 12nws, Nicholas Smith
 *	I confirm that this submission is my own work and is consistent with the Queen's regulations on Academic Integrity
 *
 *
 */


public class RedBlackBinaryTree {
	RBVertex root;
	

	public RBVertex recRBinsert(RBVertex current, int x){
		
		if (current.leftChild == null && current.rightChild == null){
			return new RBVertex(x);
		} else if (current.key < x){
			current.rightChild = recRBinsert(current.rightChild, x);
			//now check for balance
			if (current.color == "R"){
				//we don't have to check, currents parents will
			} else if (current.rightChild.color == "R"){
				//if currents right child is red, check the grandchildren
				if (current.rightChild.hasRedChild()){
					//there are two consectuvies Red vertices. Gotta go fast.
					return RBfixRight(current, x);
				} else {
					return current;
				}
			} else {
				return current;
			}
		} else {
			//current.value < x
			//we recurse down the left side
			//log is the same as for the right side
			current.leftChild = recRBinsert(current.leftChild, x);
			if (current.color == "R"){
				return current;
			} else if (current.leftChild.color == "R"){
				if (current.leftChild.hasRedChild()){
					return RBfixLeft(current, x);
				} else {
					return current;
				}
			} else {
				return current;
			}
		}
		return current;
	}
	
	
	public RBVertex RBfixRight(RBVertex current, int x){
		RBVertex sib = new RBVertex();
		RBVertex child = new RBVertex();
		RBVertex grandChild = new RBVertex();
		child = current.rightChild;
		sib = current.leftChild;
		
		if (sib.color == "R"){
			child.color = "B";
			sib.color = "B";
			current.color = "R";
			return current;
		} else {
			//sib.color == black so we need to rotate 
			if (x < child.key){
				grandChild = child.rightChild;
				current.rightChild = child.leftChild;
				child.leftChild = current;
				child.color = "B";
				current.color = "R";
				return child;
			} else {
				grandChild = child.leftChild;
				child.leftChild = grandChild.rightChild;
				current.rightChild = grandChild.leftChild;
				grandChild.rightChild = child;
				grandChild.leftChild = current;
				grandChild.color = "B";
				current.color = "R";
				return grandChild;
			}
		}
		
		
	}
	
	public RBVertex RBfixLeft(RBVertex current, int x){
		RBVertex sib = new RBVertex();
		RBVertex child = new RBVertex();
		RBVertex grandChild = new RBVertex();
		child = current.leftChild;
		sib = current.rightChild;
		
		if (sib.color == "R"){
			child.color = "B";
			sib.color = "B";
			current.color = "R";
			return current;
		} else {
			//sib.color == black so we need to rotate 
			if (x < child.key){
				grandChild = child.leftChild;
				current.leftChild = child.rightChild;
				child.rightChild = current;
				child.color = "B";
				current.color = "R";
				return child;
			} else {
				grandChild = child.rightChild;
				child.rightChild = grandChild.leftChild;
				current.leftChild = grandChild.rightChild;
				grandChild.leftChild = child;
				grandChild.rightChild = current;
				grandChild.color = "B";
				current.color = "R";
				return grandChild;
			}
		}
		
		
	}
	

	public RBVertex search(int key){
		
		RBVertex fNode = root;
		
		while (fNode.key != key) {
			System.out.print(fNode.key + ", ");
			if (key < fNode.key){
				fNode = fNode.leftChild;
				
			}else {
				fNode = fNode.rightChild;
				
			}
	
			if (fNode == null){
				return null;
			}
			
			
		} 
		
		return fNode;
	}
	
		public int totalDepth(RBVertex node, int depth){
		
		if (node == null){
			return 0;
		}
		
		return (depth + totalDepth(node.leftChild, depth + 1) + totalDepth(node.rightChild, depth+1));
		}
		
		public void main(String args[]){
			int n = 2500;
			int k = 500;
			
			for (int i = 0; i < n; i++){
				int[] set = new int[n];
				for (int j = 0; j < k; j++){
					set[j] = (i*100) - (j*20) - (i*j*5) + (i*j*10);
					
					recRBinsert(null, set[j]);
				}
			}
			
		}
}



class RBVertex {
	
	public Integer key;
	public String color;
	
	public RBVertex leftChild;
	public RBVertex rightChild;
	
	
	public RBVertex(){
		this.key = null;
		this.color = "B";
		this.leftChild = null;
		this.rightChild = null;
		
	}
	
	public RBVertex(Integer x){
		this.key = x;
		this.color = "R";
		this.rightChild = new RBVertex();
		this.leftChild = new RBVertex();
		
		
	}
	public boolean hasRedChild(){
		
		if (rightChild.rightChild.color == "R"){
			return true;
		} else {
			return false;
		}
		
		
	}
	public String toString() {
		
		return "You are at " + key;
	}
	
}



