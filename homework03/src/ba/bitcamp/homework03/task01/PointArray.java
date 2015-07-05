package ba.bitcamp.homework03.task01;

/**
 * A dynamic array, resizing when required
 *
 */
public class PointArray {

	private Point[] points;
	private int length;
	private int[] undos;
	private int[] redos;
	
	/**
	 * Default constructor.
	 */
	public PointArray() {
		this.points = new Point[10];
		this.length = 0;
		this.undos = new int[1];
		this.redos = new int[0];
	}
	
	/**
	 * Adding next point to the array
	 */
	public void addPoint(Point p){
		if(length == points.length){
			resize();
		}
		this.points[length++] = p;
	}
	
	/**
	 * Returns number of array points. 
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Returns point at given index in an array.
	 */
	public Point elementAt(int index){
		return points[index];
	}

	private void resize() {
		Point[] tmp = new Point[points.length * 2];
		for (int i = 0; i < points.length; i++) {
			tmp[i] = points[i];
		}
		points = tmp;
	}

	/**
	 * Reduces an array
	 */
	public void undoArray() {
			for (int i = 0; i < undos.length - 1; i++) {
				if(length - 1 == undos[i + 1]){
					length = undos[i] + 1;
					updateRedos(undos[i + 1]);
					updateUndos(i);;
				}
			}
			if(length == 1)
				length = 0;
	}
	

	private void updateRedos(int value) {
		int[] tmp = new int[redos.length + 1];
		for (int i = 0; i < redos.length; i++) {
			tmp[i] = redos[i];
		}
		tmp[tmp.length - 1] = value;
		redos = tmp;
		
	}

	private void updateUndos(int index) {
		int[] tmp = new int[index + 1];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = undos[i];
		}
		undos = tmp;
		
	}

	/**
	 * Increases array
	 */
	public void redoArray() {
		if(redos.length != 0){
			length = redos[redos.length - 1] + 1;
			int[] tmp = new int[redos.length - 1];
			for (int i = 0; i < tmp.length; i++) {
				tmp[i] = redos[i];
			}
			redos = tmp;
			breakArray();
		}
	}
	
	public void breakArray(){
		int[] tmp = new int[undos.length + 1];
		for (int i = 0; i < undos.length; i++) {
			tmp[i] = undos[i];
		}
		tmp[tmp.length - 1] = length - 1;
		undos = tmp;
	}
	
}