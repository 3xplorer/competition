package competition;

public class Node {

	private int value;
	private boolean marked;

	public Node(int value) {

		this.value = value;
		marked = false;
	}

	public int getValue() {

		return value;
	}

	public boolean isMarked() {

		return marked;
	}

	public void setMarked() {

		marked = true;
	}
}
