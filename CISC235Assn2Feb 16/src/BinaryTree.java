/**
 * 
 * 10098522, 12nws, Nicholas Smith
 *	I confirm that this submission is my own work and is consistent with the Queen's regulations on Academic Integrity
 *
 *
 */

public class BinaryTree {

	Node root;
	
	public void addNode(int key){
		//Create a new node and initialize it.
		
		Node newNode = new Node(key);
		// If there is no root, this must become the root
		
		if (root == null){
			
			root = newNode;
			
		} else {
			//Set root as the Node we will start with as we traverse the tree
			Node fNode = root;
			//fNode is the current 'focused node'
			Node parent;
			while (true) {
				
				//root is the top parent so we start there
				
				parent = fNode;
				
				if (key < fNode.key) {
					
					fNode = fNode.leftChild;
					
					if (fNode == null){
						
						//place the new node on the left of it
						
						parent.leftChild = newNode;
						return;
					}
				} else {
					fNode = fNode.rightChild;
					
					if(fNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	
	public Node search(int key){
		
		Node fNode = root;
		
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			BinaryTree theTree = new BinaryTree();
		
		
			int n = 2500;
			int k = 500;
			for (int i = 0; i < n; i++){
				int[] set = new int[n];
				
				for (int j = 0; j < k; j++){
					set[j] = (i*100) - (j*20) - (i*j*5) + (i*j*10);
					theTree.addNode(set[j]);
				}
			}
			
			System.out.print(theTree.totalDepth(theTree.root, 0));
			
		
		
	}
	
	
	public int totalDepth(Node node, int depth){
		
		if (node == null){
			return 0;
		}
		
		return (depth + totalDepth(node.leftChild, depth + 1) + totalDepth(node.rightChild, depth+1));
	}

}

class Node {
	
	int key;
	
	
	Node leftChild;
	Node rightChild;
	
	Node(int key){
		this.key = key;
		
	}
	
	public String toString() {
		
		return "You are at " + key;
	}
	
}




/**
 
 
public void display(Node fNode, int indent=0){
    if (tree == null){
        return null;
    } else {
        display(fNode.rightChild,indent+4);
        System.out.println(' '*indent + str(tree['data']));
        display(tree['left'],indent+4);
        
    }
*/