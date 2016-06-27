package competition;

public class DFSItem {

	private int status;
	private int distance;
	private Node pred;
	
	public DFSItem(int status, int distance, Node predecessor) {
	
		this.status = status;
		this.distance = distance;
		this.pred = predecessor;
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
	
	
}
