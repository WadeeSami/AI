import java.util.Comparator;


public class MyConparator implements Comparator<State> {

	@Override
	public int compare(State o1, State o2) {
		// TODO Auto-generated method stub
		if(o1.getHeuristics() + o1.getLevel() < o2.getHeuristics() + o1.getLevel())return -1;
		else if(o1.getHeuristics()+ o1.getLevel() > o2.getHeuristics() + o1.getLevel())return 1;
		return 0;
	}

}
