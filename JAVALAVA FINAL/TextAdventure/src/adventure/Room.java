package adventure;

/**
 * @constructor public method
 * @param x
 * @keywords 
 * @return VOID, PASSES X
 * @notes THIS INTERFACE IS USED TO EXTEND THROUGHOUT THE FINAL PROGRAM
 */
// may need more
public interface Room{
	public int look(int x);
	public int goNorth(int x);
	public int goSouth(int x);
	public int goEast(int x);
	public int goWest(int x);
	public int take(int x);
	public int items(int x);
	public int open(int x);
	public int push(int x);

}