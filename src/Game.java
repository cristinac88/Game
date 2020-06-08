import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {

    private static Game instance = new Game();

    public int level = 1;
    public int score = 0;
    public boolean isInGame = false;

    public static Game getInstance() {
        return instance;
    }

    public Player player;
    public Enemy enemy;

    private Game() {
        super();
        player = new Player();
        enemy = new Enemy(level);
        JFrame jFrame = new JFrame("Joc Paoo");
        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 200);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        jFrame.add(this);
        jFrame.addMouseListener(new InputMouse());
        jFrame.addKeyListener(new InputTastatura());
        jFrame.addMouseMotionListener(new InputMouseMove());
        jFrame.setVisible(true);
    }

    @Override
    public void run() {
        while (true){
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        if(isInGame){
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, 1000, 500);
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font("Consolas", Font.PLAIN, 40));
            g.drawString("Score: " + score, 400, 30);
            g.drawString("Level: " + level, 400, 80);
            // ground
            g.setColor(Color.BLACK);
            g.fillRect(0, 450, 1000, 5);
            enemy.draw(g);
            player.draw(g);
        }else{
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, 1000, 500);
            g.setFont(new Font("Consolas", Font.PLAIN, 60));
            int x = InputMouseMove.x;
            int y = InputMouseMove.y;
            if(y >= 190 && y < 240 && x > 370 && x < 630){
                g.setColor(Color.ORANGE);
            }else{
                g.setColor(Color.DARK_GRAY);
            }
            g.drawString("Play", 400, 200);
            if(y >= 240 && y < 290 && x > 370 && x < 630){
                g.setColor(Color.ORANGE);
            }else{
                g.setColor(Color.DARK_GRAY);
            }
            g.drawString("Save", 410, 250);
            if(y >= 290 && y < 340 && x > 370 && x < 630){
                g.setColor(Color.ORANGE);
            }else{
                g.setColor(Color.DARK_GRAY);
            }
            g.drawString("Continue", 360, 300);
            if(y >= 340 && y < 390 && x > 370 && x < 630){
                g.setColor(Color.ORANGE);
            }else{
                g.setColor(Color.DARK_GRAY);
            }
            g.drawString("Quit", 410, 350);
        }
    }

    public static void main(String[] args){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        new Thread(Game.getInstance()).run();
    }

}
