package competition;

import java.util.ArrayList;
import java.util.Collections;

public class TestGraph {

	public static void main(String[] args) {

		Graph g = new Graph();

		ReadFile r = new ReadFile();
		r.read(g);
		// System.out.println(g.toString());

		g.createUndirectedGraph();

		System.out.println();
		// System.out.println(g.toString());

		System.out.println("size map: " + g.getGraph().size());

		System.out.println(g.getDegree(23));
		System.out.println(g.getDistance());

		// sort nodes in nodeList
		Collections.sort(g.getNodes());

		// for (Node node : g.getNodes()) {
		// System.out.println(node.getValue());
		// }

		// sort all neighbor nodes in the map
		for (ArrayList<Node> entry : g.getGraph().values()) {

			Collections.sort(entry);
		}

		// System.out.println(g.toString());
	}
}
