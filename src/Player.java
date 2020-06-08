import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {

    public int x;
    public int y;

    public BufferedImage playerImage;
    public BufferedImage arc;

    public double angle = 0;

    public Arrow arrow = null;

    public Player(){
        x = 50;
        y = 250;
        try {
            playerImage = ImageIO.read(this.getClass().getResource("/player.png"));
            arc = ImageIO.read(this.getClass().getResource("/arc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        g.drawImage(playerImage, x, y, null);
        angle = Math.atan((double)(InputMouseMove.y - y - 70)/(InputMouseMove.x - x - 65));
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(x + 40 + 25, y + 60);
        g2d.rotate(angle);
        g2d.drawImage(arc, -25, -60, null);
        g2d.rotate(-angle);
        g2d.translate(-(x + 40 + 25), -(y + 60));
        checkCollision();
        if(arrow != null){
            arrow.draw(g2d);
        }
    }

    public void checkCollision(){
        if(arrow != null){
            if(this.arrow.getBounds().intersects(Game.getInstance().enemy.getBounds())){
                Game.getInstance().enemy.hp -= 3;
                Game.getInstance().score += 3;
                this.arrow = null;
            }
            if(Game.getInstance().enemy.hp <= 0){
                Game.getInstance().level++;
                Game.getInstance().enemy = new Enemy(Game.getInstance().level);
            }
        }
    }

    public void fire(){
        arrow = new Arrow(x, y, angle);
    }

}
