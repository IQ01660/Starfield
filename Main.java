import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements WindowInfo
{
	public static Star[] stars = new Star[700];
	
	public Main() {
		this.setPreferredSize(new Dimension(WindowInfo.WIDTH, WindowInfo.HEIGHT));
		this.setup();
		Thread myThread = new Thread(new Runner());
		myThread.start();
	}
	public static void main(String[] args) {
		JFrame starFrame = new JFrame("Starfield");
		starFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main starField = new Main();
		starFrame.setContentPane(starField);
		starFrame.pack();
		starFrame.setVisible(true);
	}
	public void setup() {
		//will run just once
		
		for(int i = 0; i < stars.length; i++)
		{
			stars[i] = new Star();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WindowInfo.WIDTH, WindowInfo.HEIGHT);
		//animation
		g.translate(WindowInfo.WIDTH/2, WindowInfo.HEIGHT/2);
		for(int i = 0; i < stars.length; i++)
		{
			stars[i].update();
			stars[i].draw(g);
		}
	}
	
	class Runner implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				repaint();
				try {
					Thread.sleep(1000/60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}