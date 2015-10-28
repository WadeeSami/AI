import java.util.ArrayList;
import java.util.List;

public class State {
	int cannibalsLeft = 0;
	int cannibalsRight = 0;
	int missionariesLeft = 0;
	int missionariesRight = 0;
	boolean left;
	boolean visited;
	String description;
	State parent;
	int heuristics;
	int level;

	public int getHeuristics() {
		return this.missionariesLeft + this.cannibalsLeft;
	}

	public void setHeuristics(int heuristics) {
		this.heuristics = heuristics;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// the constructor
	public State(int cannibalsLeft, int cannibalsRight, int missionariesLeft,
			int missionariesRight, Boolean position, String description) {

		this.cannibalsLeft = cannibalsLeft;
		this.cannibalsRight = cannibalsRight;
		this.missionariesLeft = missionariesLeft;
		this.missionariesRight = missionariesRight;
		this.left = position;
		this.description = description;
		this.visited = false;
	}

	private boolean isValid(State state) {
		return (this.cannibalsLeft >= 0 && this.cannibalsRight >= 0
				&& this.missionariesLeft >= 0 && this.missionariesRight >= 0);
	}

	private void verifyAndAdd(List successors, State state) {

		if (isValid(state)) {
			if ((state.getCannibalsLeft() <= state.getMissionariesLeft() || (state
					.getMissionariesLeft() == 0))
					&& (state.getCannibalsRight() <= state
							.getMissionariesRight() || (state
							.getMissionariesRight() == 0))
					&& ((state.getCannibalsLeft() >= 0)
							&& (state.getCannibalsRight() >= 0)
							&& (state.getMissionariesLeft() >= 0) && (state
							.getMissionariesRight() >= 0))
					&&
					((state.getCannibalsLeft() <= 3)
							&& (state.getCannibalsRight() <= 3)
							&& (state.getMissionariesLeft() <= 3) && (state
							.getMissionariesRight() <= 3))
					) {
				// System.out.println("Appears to be accepted " + state);
				successors.add(state);
			} else {
				// System.out.println("Appears not  to be accepted " + state);
			}
		}// isValid
	}

	public List<State> generateSuccessors() {
		List<State> successors = new ArrayList<State>();
		// a method to verify then add the state
		// System.out.println("inside the generate successors " + this);
		if (this.left) {
			this.verifyAndAdd(
					successors,
					new State(this.cannibalsLeft - 1, this.cannibalsRight + 1,
							this.missionariesLeft - 1,
							this.missionariesRight + 1, false,
							"one cannibal from left to right and one miss from left to right"));// one
																								// cannibal
																								// from
																								// left
			// to right and one miss
			// from left to right

			this.verifyAndAdd(successors, new State(this.cannibalsLeft - 2,
					this.cannibalsRight + 2, this.missionariesLeft,
					this.missionariesRight, false,
					"2 cannibals from left to right"));// 2 cannibals from left
														// to
			// right
			this.verifyAndAdd(successors, new State(this.cannibalsLeft,
					this.cannibalsRight, this.missionariesLeft - 2,
					this.missionariesRight + 2, false,
					"2 miss from left to right"));// 2 miss from left to
			// right
			this.verifyAndAdd(successors, new State(this.cannibalsLeft - 1,
					this.cannibalsRight + 1, this.missionariesLeft,
					this.missionariesRight, false,
					"1 cannibal from left to right"));// 1 cannibal from left to
			// right
			this.verifyAndAdd(successors, new State(this.cannibalsLeft,
					this.cannibalsRight, this.missionariesLeft - 1,
					this.missionariesRight + 1, false,
					"1 miss from left to right"));// 1 miss from left to
			// System.out.println("adding nodes to the left"); // right

		} else {
			this.verifyAndAdd(
					successors,
					new State(this.cannibalsLeft + 1, this.cannibalsRight - 1,
							this.missionariesLeft + 1,
							this.missionariesRight - 1, true,
							"one cannibal from right to left and onemiss from right to left"));// one
																								// cannibal
																								// from
			// right to left and one
			// miss from right to
			// left

			this.verifyAndAdd(successors, new State(this.cannibalsLeft + 2,
					this.cannibalsRight - 2, this.missionariesLeft,
					this.missionariesRight, true,
					"2 cannibals from right to left"));// 2 cannibals from right
														// to
			// left
			this.verifyAndAdd(successors, new State(this.cannibalsLeft,
					this.cannibalsRight, this.missionariesLeft + 2,
					this.missionariesRight - 2, true,
					"2 miss from right to left"));// 2 miss from right to
			// left
			this.verifyAndAdd(successors, new State(this.cannibalsLeft + 1,
					this.cannibalsRight - 1, this.missionariesLeft,
					this.missionariesRight, true,
					"1 cannibal from right to left"));// 1 cannibal from right
														// to
			// left
			this.verifyAndAdd(successors, new State(this.cannibalsLeft,
					this.cannibalsRight, this.missionariesLeft + 1,
					this.missionariesRight - 1, true,
					"1 miss from right to left"));// 1 miss from right to
			// left

		}
		return successors;
	}

	/**
	 * @param state
	 * @return
	 */
	public Boolean isGoal() {
		return (this.getCannibalsLeft() == 0 && this.getCannibalsRight() == 3
				&& this.getMissionariesLeft() == 0 && this
					.getMissionariesRight() == 3);
	}

	public int getCannibalsLeft() {
		return cannibalsLeft;
	}

	public void setCannibalsLeft(int cannibalsLeft) {
		this.cannibalsLeft = cannibalsLeft;
	}

	public int getCannibalsRight() {
		return cannibalsRight;
	}

	public void setCannibalsRight(int cannibalsRight) {
		this.cannibalsRight = cannibalsRight;
	}

	public int getMissionariesLeft() {
		return missionariesLeft;
	}

	public void setMissionariesLeft(int missionariesLeft) {
		this.missionariesLeft = missionariesLeft;
	}

	public int getMissionariesRight() {
		return missionariesRight;
	}

	public void setMissionariesRight(int missionariesRight) {
		this.missionariesRight = missionariesRight;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean equals(State state) {
		return ((this.cannibalsLeft == state.getCannibalsLeft())
				&& (this.missionariesLeft == state.getMissionariesLeft())
				&& (this.cannibalsRight == state.getCannibalsRight())
				&& (this.missionariesRight == state.getMissionariesRight()) && this.left == state
					.isLeft());
	}

	public String toString() {
		/*
		 * String str = "This state is where there are "; str +=
		 * this.cannibalsLeft + " cannibals and " + this.missionariesLeft +
		 * " missionaries on the left side and \n"; str += this.cannibalsRight +
		 * " cannibals and " + this.missionariesRight +
		 * " missionaries on the right side and \n";
		 */
		String str2 = " left( " + this.getCannibalsLeft() + " C ,"
				+ this.getMissionariesLeft() + " M )" + " Right ( "
				+ this.getCannibalsRight() + " C , "
				+ this.getMissionariesRight() + " M ) And in the ";
		str2 += this.left ? " Left side" : " Right side";
		return str2;
	}
}
