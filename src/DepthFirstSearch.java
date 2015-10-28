import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	State currentState;
	ArrayList<State> explored;

	public DepthFirstSearch(State initialState, LinkedList<State> solutionTree) {
		explored = new ArrayList<State>();
		// System.out.println("The constructor of the DFS algorithm");
		if (initialState.isGoal()) {
			System.out.println("The solution has been found , it's the initial state");

			return;
		}
		// System.out.println("The constructor of the DFS algorithm");
		Stack<State> frontier = new Stack<State>();
		frontier.push(initialState);
		while (!frontier.isEmpty()) {
			currentState = frontier.pop();
			if (!explored.contains(currentState)) {
				System.out.println("the current state is " + currentState);
				explored.add(currentState);
				currentState.visited = true;
				List<State> successor = currentState.generateSuccessors();
				//System.out.println(successor);
				// solutionTree.add(currentState);
				//System.out.println("\n\n\n***\n successors has been printed");
				// System.out.println("The frontier is >> \n");
				for (int i = 0; i < successor.size(); i++) {
					State child = successor.get(i);
					child.parent = this.currentState;
					// System.out.println(child);
					if (!frontier.contains(child) && !this.isVisited(child)) {
						if (child.isGoal()) {
							/*
							 * System.out.println("The solution has been found");
							 * System.out.println(""); //
							 * System.out.println(child); System.out
							 * .println("\n********************The explored list is"
							 * ); System.out.println(explored);
							 * System.out.println("**********************");
							 */
							print(child, initialState);
							return;
						} else {
							frontier.push(child);
						}
					}
				}
				System.out.println("Go back to the while loop");
			}// if explored
			else {
				System.out
						.println("it's been explored previously or it has replications ***");
			}
		}// while

	}// the constructor

	public boolean isVisited(State s) {
		for (int i = 0; i < this.explored.size(); i++) {
			State toBeCompared = this.explored.get(i);
			if (s.equals(toBeCompared))
				return true;
		}
		return false;
	}

	public boolean hasReplicatedSuccessor(State s) {
		System.out.println("5555555555555555555555555555555555555555");
		List<State> successors = s.generateSuccessors();
		for (int i = 0; i < successors.size(); i++) {
			State child = successors.get(i);
			if (s.equals(child))
				return true;
		}
		return false;
	}

	public void print(State goal, State InitialState) {
		if (!goal.equals(InitialState)) {
			print(goal.parent, InitialState);
		}
		System.out.println("In the print Function " + goal);

	}
}
