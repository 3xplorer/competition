package competition;

public class Node implements Comparable<Node> {

	private int value;
	private int status;
	private int distance; 
	private Node pred;

	public Node(int value) {

		this.value = value;
		setStatus(-1);
		setDistance(0);
		setPred(null);
	}

	public int getValue() {

		return value;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Node getPred() {
		return pred;
	}

	public void setPred(Node pred) {
		this.pred = pred;
	}

	public int compareTo(Node node) {

		return this.getValue() - node.getValue();
	}
}
