import java.awt.*;

public class Enemy {

    public float x;
    public float y;

    public float speed;
    public int size;

    private float angle;

    public Color color;

    public int hp;

    public Enemy(int level){
        this.x = 800;
        this.y = 250;
        this.speed = 0.02F + 0.01F*level;
        this.size = 100 - 5 * level;
        if(size < 20){
            size = 20;
        }
        this.hp = 6 + 3*level;
        int random = (int) (Math.random() * 4);
        if(random == 0){
            color = Color.RED;
        }else if(random == 1){
            color = Color.BLACK;
        }else if(random == 2){
            color = Color.GREEN;
        }else{
            color = Color.BLUE;
        }
    }

    public void draw(Graphics g){
        angle += speed;
        this.y = 200 + 130*(float)Math.sin(angle);
        g.setColor(Color.BLACK);
        g.drawString("Enemy hp: " + hp, 700, 30);
        g.setColor(color);
        g.fillRect((int)x, (int)y, size, size);
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, size, size);
    }

}
