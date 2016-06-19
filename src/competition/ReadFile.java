package competition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	static final int EOF = -1;
	static final int EOL = '\n';
	static final int SP = ' ';
	static final int CR = 13;

	void read(Graph g) {

		String file = "src/competition/graph59a.txt";
		ArrayList<Integer> concats = new ArrayList<>();
		int c, value = 0, key = 0;
		boolean firstLine = true;
		boolean firstChar = true;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			// Scanner sc = new Scanner(fr);

			while ((c = br.read()) != EOF) {

				if (isDigit(c)) {

					concats.add(Character.getNumericValue(c));
				} else {

					if (!isEmpty(concats)) {

						value = concatenate(concats);

						if (firstLine) {

							if (firstChar) {

								g.addStartGoal(value);
								firstChar = false;
							} else {
								g.addStartGoal(value);
								firstChar = true;
								firstLine = false;
							}
						} else {

							if (firstChar) {

								key = value;
								g.addNode(key);
								firstChar = false;
							} else {

								g.addNeighbor(key, value);
							}
							if (isNewLine(c)) {

								firstChar = true;
							}
						}
					} else {

						if (isNewLine(c)) {
							firstChar = true;
						}

					}
					concats = new ArrayList<>();
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!isEmpty(concats)) {

			if (firstChar) {
				key = concatenate(concats);
				g.addNode(key);
			} else {
				value = concatenate(concats);
				g.addNeighbor(key, value);
			}
		}
	}

	private boolean isEmpty(ArrayList<Integer> concats) {
		return concats.size() == 0;
	}

	private boolean isDigit(int c) {
		return (c != SP) && (c != EOL) && (c != CR);
	}

	private boolean isNewLine(int c) {

		if ((c == EOL) || (c == CR)) {

			return true;
		}

		return false;
	}

	private int concatenate(ArrayList<Integer> concats) {

		String s = "";

		for (Integer value : concats) {

			s += value;
		}
		return Integer.parseInt(s);
	}
}
