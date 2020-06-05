import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class EtchASketch extends Canvas
{
	int x, y;
	Color cur;
	
	public static void main( String[] args )
	{
		JFrame win = new JFrame("Use the arrow keys!");
		win.setSize(1024,768);
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		win.add( new EtchASketch() );
		win.setVisible(true);
	}

	public EtchASketch()
	{
		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
		requestFocus();
		x = 500;
		y = 400;
		cur = Color.black;
	}

	public void paint( Graphics g )
	{
		g.setColor(cur);
		g.fillOval(x, y, 25, 25);
	}

	public void update( Graphics g )
	{
		paint(g);
	}

	public void processKeyEvent(KeyEvent e)
	{
		// this method automatically gets called with they press a key
		if ( e.getID() == KeyEvent.KEY_PRESSED )
		{
			if ( e.getKeyCode() == KeyEvent.VK_UP )
				y -= 10;
			if ( e.getKeyCode() == KeyEvent.VK_DOWN )
				y += 10;
			if ( e.getKeyCode() == KeyEvent.VK_LEFT )
				x -= 10;
			if ( e.getKeyCode() == KeyEvent.VK_RIGHT )
				x += 10;
			if ( e.getKeyCode() == KeyEvent.VK_F1 ) //Change color to red
                cur = Color.red;
            if ( e.getKeyCode() == KeyEvent.VK_F2 ) //Change color to green
                cur = Color.green;
            if ( e.getKeyCode() == KeyEvent.VK_F3 ) //Change color to blue
                cur = Color.blue;
            if ( e.getKeyCode() == KeyEvent.VK_F5 ) //Change color to black
                cur = Color.black;
            if ( e.getKeyCode() == KeyEvent.VK_F4 ) //Change color to black
                cur = Color.white;

			// and we manually call paint() again to redraw
			repaint();
		}
	}
	
	public boolean isFocusable()
	{
		return true;
	}
}