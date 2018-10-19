package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		int ranne = new Random().nextInt(width);
		int ranna = new Random().nextInt(width);
		Cell r = maze.getCell(ranne, ranna);
		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(r);
		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell
		ArrayList<Cell> visitors_ = getUnvisitedNeighbors(currentCell);
		// C. if has unvisited neighbors,
		if (visitors_ != null && !visitors_.isEmpty()) {
			int rand = new Random().nextInt(visitors_.size());
			uncheckedCells.push(visitors_.get(rand));
			removeWalls(currentCell, visitors_.get(rand));
			selectNextPath(currentCell);
			currentCell = visitors_.get(rand);
			currentCell.setBeenVisited(true);
			//
			if (visitors_.isEmpty() && !uncheckedCells.isEmpty()) {
				currentCell = uncheckedCells.pop();
				selectNextPath(currentCell);
			}
		}

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and mark it as visited

		// D. if all neighbors are visited

		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getY() == c2.getY()) {
			if (c1.getX() < c2.getX()) {
				c1.setEastWall(false);
				c2.setWestWall(false);
			} else if (c1.getX() > c2.getX()) {
				System.out.println("got to west");
				c1.setWestWall(false);
				c2.setEastWall(false);
			}
		} else if (c1.getX() == c2.getX()) {
			if (c1.getY() < c2.getY()) {
				System.out.println("got to north");
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			} else if (c1.getY() > c2.getY()) {
				System.out.println("got to south");
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		}
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> arlc = new ArrayList<>();
		for (int i = 0; i < maze.maza.length; i++) {
			if (true) {
				// check if adjacents visited
			}
		}
		return null;

	}
}