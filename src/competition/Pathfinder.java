package competition;

import java.util.ArrayList;
import java.util.Iterator;

public class Pathfinder {

	public final static int WHITE = 0;
	public final static int GREY = 1;
	public final static int BLACK = 2;
	private static final Graph g = new Graph();
	ArrayList<Node[]> pathList = new ArrayList<>();

	public int findPath() {

		int pathCounter = 0;

		Node[] path = new Node[g.getDistance()];
		Node startNode = g.getStartGoal().get(0);
		path[0] = startNode;

		ArrayList<Node> start = g.getNode(startNode.getValue());
		path[0] = startNode;

		for (Node node : start) {

			path[1] = node;

			if (node.getStatus() == WHITE) {
				node.setPred(startNode);
				DFSVisit(node, path);
			}
		}

		return pathCounter;
	}

	private void DFSVisit(Node node, Node[] path) {

		node.setStatus(GREY);
		node.setDistance(node.getPred().getDistance() + 1);

		for (Node nextNode : g.getNode(node.getValue())) {

			if (nextNode.getStatus() == WHITE) {

				nextNode.setPred(node);
				DFSVisit(nextNode, path);
			}
		}
		node.setStatus(BLACK);
		node.setDistance(node.getPred().getDistance() + 1);
	}

	private boolean hasUnvisitedNodes(Node currentNode) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isHamiltonPath(Node nextNode, Node[] path) {

		Node targetNode = g.getStartGoal().get(1);

		if (nextNode.equals(targetNode) && path.length == g.getDistance()) {

			return true;
		}
		return false;
	}

}
