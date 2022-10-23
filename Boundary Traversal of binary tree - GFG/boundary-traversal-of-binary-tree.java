//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> res = new ArrayList<>();
	    if(isLeaf(node) == false)
	    res.add(node.data);
	    
	    addLeftBoundary(node, res);
	    addLeaves(node, res);
	    addRightBoundary(node, res);
	    
	    return res;
	}
	
	public boolean isLeaf(Node node) {
	    return (node.left == null && node.right == null);
	}
	
	public void addLeftBoundary(Node node, ArrayList<Integer> res) {
	    Node curr = node.left;
	    
	    while(curr != null) {
	        if(isLeaf(curr) == false) {
	            res.add(curr.data);
	        }
	        
	        if(curr.left != null){
	            curr = curr.left;
	        }
	        else {
	            curr = curr.right;
	        }
	    }
	}
	
	public void addLeaves(Node node, ArrayList<Integer> res) {
	    if(isLeaf(node)) {
	        res.add(node.data);
	        return;
	    }
	    
	    if(node.left != null) {
	        addLeaves(node.left, res);
	    }
	    
	    if(node.right != null) {
	        addLeaves(node.right, res);
	    }
	}
	
	public void addRightBoundary(Node node, ArrayList<Integer> res) {
	    Node curr = node.right;
	    
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    while(curr != null) {
	        if(isLeaf(curr) == false) {
	            list.add(curr.data);
	        }
	        
	        if(curr.right != null) {
	            curr = curr.right;
	        }
	        else {
	            curr = curr.left;
	        }
	    }
	    
	    for(int i=list.size()-1;i>=0;i--) {
	        res.add(list.get(i));
	    }
	}
	
	
}
