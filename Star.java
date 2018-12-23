import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

interface WindowInfo{
	int WIDTH = 700;
	int HEIGHT = 700;
}

public class Star
{
	public double x;
	public double y;
	public double z;
	Random rand = new Random();
	
	public Star() {
		
		this.x = rand.nextInt(WindowInfo.WIDTH) - WindowInfo.WIDTH/2;
		this.y = rand.nextInt(WindowInfo.HEIGHT) - WindowInfo.HEIGHT/2;
		this.z = rand.nextInt(WindowInfo.WIDTH);
	}
	
	public void update()
	{
		this.z = this.z - 20;
		if (this.z < 1) {
			this.z = rand.nextInt(WindowInfo.WIDTH);
			this.x = rand.nextInt(WindowInfo.WIDTH) - WindowInfo.WIDTH/2;
			this.y = rand.nextInt(WindowInfo.HEIGHT) - WindowInfo.HEIGHT/2;
		}
	}
	
	public double map(double myNum, double maxNum, double maxMapNum) {
		//Star myStar = new Star();
		return (maxMapNum / maxNum)*myNum;
	}
	
	public void draw(Graphics g) 
	{
		int px = (int) map(this.x / (this.z + 20), 1, WindowInfo.WIDTH);
		int py = (int) map(this.y / (this.z + 20), 1, WindowInfo.WIDTH);
		int sx = (int) map(this.x / this.z, 1, WindowInfo.WIDTH);
		int sy = (int) map(this.y / this.z, 1, WindowInfo.WIDTH);
		
		int r = 8 - (int)(map(this.z, WindowInfo.WIDTH, 8));
		g.setColor(Color.WHITE);
		//g.fillOval(sx, sy, r, r);
		g.drawLine(sx, sy, px, py);
	}
	
}