import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {
	State CurrentState;
	ArrayList<State> explored;
	PriorityQueue<State> frontier;

	public AStar(State InitialState) {
		InitialState.setLevel(0);
		explored = new ArrayList<State>();
		frontier = new PriorityQueue<State>(new MyConparator());
		/*
		 * MyComparator sets the criteria of how to sort the states in the
		 * priority Queue
		 */
		System.out.println("Starting");
		if (InitialState.isGoal()) {
			System.out
					.println("The Goal has been found , it's the initial state");
			return;
		}
		this.frontier.add(InitialState);
		while (!this.frontier.isEmpty()) {
			this.CurrentState = this.frontier.poll();
			// System.out.println("Polled From Frontier" + this.CurrentState);
			if (this.CurrentState.isGoal()) {
				System.out.println("The Goal has been found "
						+ this.CurrentState);
				return;
			}// if the goal
			if (!this.explored.contains(this.CurrentState)) {
				this.CurrentState.visited = true;
				this.explored.add(this.CurrentState);
				List<State> successor = this.CurrentState.generateSuccessors();
				for (int i = 0; i < successor.size(); i++) {
					State child = successor.get(i);
					child.parent = this.CurrentState;
					child.setLevel(this.CurrentState.getLevel() + 1);
					// System.out.println(child);
					if (!frontier.contains(child) && !this.isVisited(child)) {
						if (child.isGoal()) {
							// System.out.println("The solution has been found");
							// System.out.println("*****************/");
							// System.out.println(child);
							// System.out
							// .println("\n********************The explored list is");
							// System.out.println(explored);
							// System.out.println("**********************");
							print(child, InitialState);
							return;
						} else {
							frontier.add(child);
						}// else
					}// if frontier does not contain the child
				}// loop
			}// if current state is not explored
			else {
				System.out.println("It's been explored previously");
			}
		}// while

	}

	public boolean isVisited(State s) {
		for (int i = 0; i < this.explored.size(); i++) {
			State toBeCompared = this.explored.get(i);
			if (s.equals(toBeCompared))
				return true;
		}
		return false;
	}

	public void print(State goal, State InitialState) {
		if (! goal.equals(InitialState)) {
			print(goal.parent, InitialState);
		}
		System.out.println("In the print Function " + goal);

	}
}
