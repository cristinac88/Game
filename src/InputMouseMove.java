import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class InputMouseMove implements MouseMotionListener {

    public static int x = 0;
    public static int y = 0;

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
