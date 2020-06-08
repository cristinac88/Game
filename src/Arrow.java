import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Arrow {

    public double x;
    public double y;
    public double angle;

    public BufferedImage arrowImage;

    public Arrow(int x, int y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
        try {
            arrowImage = ImageIO.read(this.getClass().getResource("/sageata.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        x += 15 * Math.cos(angle);
        y += 15 * Math.sin(angle);
        g2d.translate(x + 40 + 25, y + 60);
        g2d.rotate(angle);
        g2d.drawImage(arrowImage, -25, -60, null);
        g2d.rotate(-angle);
        g2d.translate(-(x + 40 + 25), -(y + 60));
    }

    public Rectangle getBounds(){
        return new Rectangle((int)(x + 40 + 123*Math.cos(angle)), (int)(y + 60 + 80*Math.sin(angle)), 20, 20);
    }

}
