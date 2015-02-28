
/*
BFS using Adjacency List
*/


public class Node {

		public String data; // data element
		public boolean visited=false; // flag to track the already visited node
		public List adjacentNodes = new LinkedList(); // adjacency list

		public Node(String data){
			this.data = data;
		}

		public void addAdjacentNode(final Node node){
			adjacentNodes.add(node);
			node.adjacentNodes.add(this);
		}

	}
	
	
	public class Graph {

	private List nodes = new ArrayList();

	public void breadthFirstTraversal(Node rootNode){

		Queue q = new LinkedList();
		q.add(rootNode);
		rootNode.visited=true;
		while(!q.isEmpty()){
			Node n = (Node)q.poll();
			System.out.print(n.data + " ");
			for(Node adj : n.adjacentNodes){
				if(!adj.visited){
					adj.visited=true;
					q.add(adj);
				}
			}
		}

	}

}

public static void main(String[] args) {

		Node frankfurt = new Node("frankfurt");
		Node mannheim = new Node("mannheim");
		Node wurzburg = new Node("wurzburg");
		Node stuttgard = new Node("stuttgard");
		Node kassel = new Node("kassel");
		Node karlsruhe = new Node("karlsruhe");
		Node erfurt = new Node("erfurt");
		Node numberg = new Node("numberg");
		Node augsburg = new Node("augsburg");
		Node munchen = new Node("munchen");

		Graph g = new Graph();

		g.nodes.add(frankfurt);
		g.nodes.add(mannheim);
		g.nodes.add(wurzburg);
		g.nodes.add(stuttgard);
		g.nodes.add(kassel);
		g.nodes.add(karlsruhe);
		g.nodes.add(erfurt);
		g.nodes.add(numberg);
		g.nodes.add(augsburg);
		g.nodes.add(munchen);

		frankfurt.addAdjacentNode(mannheim);
		frankfurt.addAdjacentNode(wurzburg);
		frankfurt.addAdjacentNode(kassel);

		mannheim.addAdjacentNode(karlsruhe);

		karlsruhe.addAdjacentNode(augsburg);

		augsburg.addAdjacentNode(munchen);

		munchen.addAdjacentNode(kassel);
		munchen.addAdjacentNode(numberg);

		wurzburg.addAdjacentNode(erfurt);
		wurzburg.addAdjacentNode(numberg);

		numberg.addAdjacentNode(stuttgard);

		g.breadthFirstTraversal(frankfurt);
	}