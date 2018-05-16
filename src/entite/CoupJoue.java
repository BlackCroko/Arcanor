package entite;

public class CoupJoue {
	int x1, x2, y1, y2;
	boolean extraire;

	public CoupJoue(int w, int x2, int y, int y2, boolean extraire) {
		this.x1 = w;
		this.y1 = x2;
		this.x2 = y;
		this.y2 = y2;
		this.extraire = extraire;
	}
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public boolean isExtraire() {
		return extraire;
	}

	public void setExtraire(boolean extraire) {
		this.extraire = extraire;
	}

	

}
