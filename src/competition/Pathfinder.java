package competition;

import java.util.ArrayList;

public class Pathfinder {

	public final static int WHITE = 0;
	public final static int GREY = 1;
	public final static int BLACK = 2;
	private static final Graph g = new Graph();
	private static ArrayList<ArrayList<Node>> pathList = new ArrayList<>();
	private static ArrayList<Node> path = new ArrayList<>();
	private static int PathCounter = 0;

	public void findPath() {

		Node startNode = g.getStartGoal().get(0);
		ArrayList<Node> start = g.getNode(startNode.getValue());

		path.add(startNode);

		for (Node node : start) {

			path.add(node);

			if (node.getStatus() == WHITE) {
				node.setPred(startNode);
				DFSVisit(node);
			}
			resetPath();
		}
		
		System.out.println(PathCounter);
	}

	private void DFSVisit(Node node) {

		node.setStatus(GREY);
		node.setDistance(node.getPred().getDistance() + 1);

		for (Node nextNode : g.getNode(node.getValue())) {

			if (nextNode.getStatus() == WHITE) {

				nextNode.setPred(node);
				if (isHamiltonPath(nextNode)) {

					pathList.add(path);
					PathCounter++;
					removeLastNode();
				} else {

				}
				DFSVisit(nextNode);
			}
		}
		node.setStatus(BLACK);
		node.setDistance(node.getPred().getDistance() + 1);
	}

	private boolean isHamiltonPath(Node nextNode) {

		Node targetNode = g.getStartGoal().get(1);

		if (nextNode.equals(targetNode) && path.size() == g.getDistance()) {

			return true;
		}
		return false;
	}

	private static void removeLastNode() {

		path.remove(path.size() - 1);
	}

	private static void resetPath() {

		path.clear();
		Node startNode = g.getStartGoal().get(0);
		path.add(startNode);
	}

}
