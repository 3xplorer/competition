package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

	private HashMap<Integer, ArrayList<Node>> graph;
	private ArrayList<Node> startGoal;

	public Graph() {

		if (graph == null) {

			graph = new HashMap<>();
		}
	}

	public HashMap<Integer, ArrayList<Node>> getGraph() {

		return graph;
	}

	public ArrayList<Node> getNodes(int index) {

		return graph.get(index);
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

		if (graph.get(key) == null) {

			graph.put(key, new ArrayList<>());
		}
	}

	public void addNeighbor(int key, int value) {

		if (graph.get(key) == null) {

			addNode(key);
		}

		ArrayList<Node> nodes = graph.get(key);
		nodes.add(new Node(value));
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
}
