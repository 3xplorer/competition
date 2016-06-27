package competition;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.glassfish.gmbal.ParameterNames;

public class Graph {

	private HashMap<Integer, ArrayList<Node>> graph;
	private ArrayList<Node> nodesList;
	private ArrayList<Node> startGoal;
	private int totalDistance;
	private int index;

	public Graph() {

		if (graph == null) {

			graph = new HashMap<>();
		}

		index = 0;
	}

	public int getDistance() {

		if (totalDistance < 0) {
			System.out.println("invalid graph");
		}
		return totalDistance;
	}

	public void setDistance(int distance) {
		totalDistance = distance - 1;
	}

	public HashMap<Integer, ArrayList<Node>> getGraph() {

		return graph;
	}

	public ArrayList<Node> getNode(int index) {

		return graph.get(index);
	}

	public ArrayList<Node> getNodes() {

		return nodesList;
	}

	public void addNodesToList(int value) {

		if (nodesList == null) {

			nodesList = new ArrayList<>();
		}
		if (hasNode(nodesList, value) == -1) {

			nodesList.add(new Node(value));
			index++;
		}
	}

	/**
	 * 
	 * @return a list containing the start node & target node
	 */
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

	public void addNeighbor(int key, int node) {

		Node neighbor;
		int idx;

		if ((idx = hasNode(nodesList, node)) != -1) {
			neighbor = nodesList.get(idx);

		} else {
			addNodesToList(node);
			neighbor = nodesList.get(index - 1);
		}

		if (graph.containsKey(key)) {
			graph.get(key).add(neighbor);
		} else {
			addNode(key);
		}
	}

	/**
	 * 
	 * @param key
	 * @return the degree corresponding to this entry
	 */
	public int getDegree(int key) {

		return graph.get(key).size();
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

	public void createUndirectedGraph() {

		for (Map.Entry<Integer, ArrayList<Node>> nodes : graph.entrySet()) {

			int key = nodes.getKey();

			for (Node node : nodes.getValue()) {

				int index = node.getValue();
				ArrayList<Node> currentNode = getNode(index);

				if (hasNode(currentNode, key) == -1) {
					addNeighbor(index, key);
				} else {
					continue;
				}
			}
		}
	}

	/**
	 * 
	 * @param node
	 *            - current list with contained neighbors
	 * @param value
	 *            - element to search for
	 * @return index of the specified element in this list.
	 */
	private int hasNode(List<Node> node, int value) {

		int index = 0;

		for (Node currentNode : node) {

			if (currentNode.getValue() == value) {

				return index;
			}
			index++;
		}
		return -1;
	}
}
