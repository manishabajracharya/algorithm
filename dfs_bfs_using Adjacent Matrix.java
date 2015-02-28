
/*
public class Node
{
char label;
boolean visited;

public Node(char label)
{
this.label = label;
}

}
*/

/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Manisha
 */
public class Graph {
    Node rootnode;
ArrayList nodes = new ArrayList();
int[][] adjacentmatrix;

public void addnode(Node n)
{
nodes.add(n);
}

public void setroot(Node n)
{
this.rootnode = n;
}

public void connectnode(Node start, Node end)
{
if(adjacentmatrix==null)
{
adjacentmatrix = new int[nodes.size()][nodes.size()];
}

adjacentmatrix[nodes.indexOf(start)][nodes.indexOf(end)] = 1;
adjacentmatrix[nodes.indexOf(end)][nodes.indexOf(start)] = 1;

}

public Node getunvisitedchildnode(Node n)
{
int index = nodes.indexOf(n);

for(int i=0;i<nodes.size();i++)
{
if(adjacentmatrix[index][i]==1 && !((Node)nodes.get(i)).visited)
{
return (Node)nodes.get(i);
}
}
return null;

}

public void bfs()
{
if(this.rootnode==null)
{
System.out.println("no graph");
return;
}

Queue q = new LinkedList();
q.add(this.rootnode);
this.rootnode.visited = true;
System.out.println(rootnode.label);
while(!q.isEmpty())
{
Node n = (Node) q.remove();
Node t = getunvisitedchildnode(n);
while(t!=null)
{
t.visited = true;
System.out.println(t.label);
q.add(t);
t = getunvisitedchildnode(n);
}

}
}

public void dfs()
{
if(this.rootnode==null)
{
System.out.println("no graph");
return;
}
Stack s = new Stack();
s.push(this.rootnode);
this.rootnode.visited = true;
System.out.println(rootnode.label);
while(!s.isEmpty())
{
Node n = (Node)s.peek();
Node t = getunvisitedchildnode(n);
if(t!=null)
{
t.visited = true;
System.out.println(t.label);
s.push(t);
}
else
{
s.pop();
}
}

}

}
*/


import static java.lang.reflect.Array.set;

/**
 *
 * @author Manisha
 */

public class Interview {
        
    /**
     * @param args the command line arguments
     */
public static void main(String[] args)
{
Graph g= new Graph();

Node na = new Node('A');
Node nb = new Node('B');
Node nc = new Node('C');
Node nd = new Node('D');
Node ne = new Node('E');
Node nf = new Node('F');

g.addnode(na);
g.addnode(nb);
g.addnode(nc);
g.addnode(nd);
g.addnode(ne);
g.addnode(nf);

g.setroot(na);

g.connectnode(na,nb);
g.connectnode(na,nc);
g.connectnode(na,nd);
g.connectnode(nb,ne);
g.connectnode(nb,nf);
g.connectnode(nc,nf);

//g.dfs();
g.bfs();
}
}