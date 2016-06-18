package competition;

public class TestGraph {

	public static void main(String[] args) {

		Graph g = new Graph();

		ReadFile r = new ReadFile();
		r.read(g);
		System.out.println(g.toString());
	}
}
