import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputTastatura implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            Game.getInstance().isInGame = !Game.getInstance().isInGame;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
