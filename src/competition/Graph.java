package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

	private HashMap<Integer, ArrayList<Node>> graph;
	private ArrayList<Node> nodes;
	private ArrayList<Node> startGoal;

	public Graph() {

		if (graph == null) {

			graph = new HashMap<>();
		}
	}

	public HashMap<Integer, ArrayList<Node>> getGraph() {

		return graph;
	}

	public ArrayList<Node> getNode(int index) {

		return graph.get(index);
	}

	public ArrayList<Node> getNodes() {

		return nodes;
	}

	public ArrayList<Node> getStartGoal() {

		return startGoal;
	}

	public void addStartGoal(int value) {

		if (startGoal == null) {
			startGoal = new ArrayList<>();
		}
		startGoal.add(new Node(value));
	}

	public void addNode(int key) {

		if (graph.containsKey(key)) {
			return;
		} else {
			graph.put(key, new ArrayList<>());
		}
	}

	public void addNeighbor(int key, int value) {

		if (graph.containsKey(key)) {
			graph.get(key).add(new Node(value));
		} else {
			addNode(key);
		}
	}

	public String toString() {

		String s = "";

		for (Map.Entry<Integer, ArrayList<Node>> nodes : graph.entrySet()) {

			s += nodes.getKey() + " ";
			for (Node node : nodes.getValue()) {

				s += node.getValue() + " ";
			}
			s += "\n";
		}

		return s;
	}

	public void createOmnidirectedGraph() {

		for (Map.Entry<Integer, ArrayList<Node>> nodes : graph.entrySet()) {

			int key = nodes.getKey();

			for (Node node : nodes.getValue()) {

				int index = node.getValue();
				ArrayList<Node> currentNode = getNode(index);

				if (hasNode(currentNode, key)) {
					continue;
				} else {
					addNeighbor(index, key);
				}
			}
		}
	}

	private boolean hasNode(ArrayList<Node> node, int value) {

		for (Node currentNode : node) {

			if (currentNode.getValue() == value) {

				return true;
			}
		}
		return false;
	}
}
