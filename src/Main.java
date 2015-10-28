import java.awt.BorderLayout;
import java.awt.Button;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Main {
	JFrame frame;
	BorderLayout layout;
	Button getSolution;
	JRadioButton BFS;
	JRadioButton AStar;
	ButtonGroup radioGroup;
	JLabel label;
	LinkedList solutionTree;
	public Main() {

		// create the user interface
		frame = new JFrame();
		frame.setSize(500, 200);
		frame.setVisible(true);
		layout = new BorderLayout(5 ,5);
		//this.frame.setLayout(layout);
		BFS = new JRadioButton("BFS");
		AStar = new JRadioButton("A* ");
		radioGroup = new ButtonGroup();
		radioGroup.add(BFS);
		radioGroup.add(AStar);
		label = new JLabel("Welcome to Missionaries and Cannibales"  , SwingConstants.CENTER);
		getSolution = new Button("Generate Solution" );
		getSolution.setSize(500,50);
		
		frame.add(label ,  BorderLayout.NORTH);
		frame.add(BFS , BorderLayout.WEST);
		frame.add(AStar , BorderLayout.EAST);
		frame.add(getSolution , BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		//Main main = new Main();
		LinkedList<State> solutionTree = new LinkedList<State>();
		//DepthFirstSearch DFS = new DepthFirstSearch(new State(3 ,0  , 3 , 0 , true, "The fist case"), solutionTree);
		AStar A = new AStar(new State(3 ,0  , 3 , 0 , true, "The fist case"));
	}
}
