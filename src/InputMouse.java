import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;

public class InputMouse implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(Game.getInstance().isInGame){
            Game.getInstance().player.fire();
        }else {
            int x = InputMouseMove.x;
            int y = InputMouseMove.y;
            if (y >= 190 && y < 240 && x > 370 && x < 630) {
                // Joaca
                Game.getInstance().isInGame = true;
            }
            if (y >= 240 && y < 290 && x > 370 && x < 630) {
                // Save
                try {
                    Connection connection = DriverManager.getConnection("jdbc:sqlite:baza_date_joc.db");
                    Statement statement = connection.createStatement();
                    String query = "CREATE TABLE IF NOT EXISTS Game(score INTEGER, level INTEGER);" +
                            "INSERT INTO Game VALUES (" + Game.getInstance().score + ", " + Game.getInstance().level + ");";
                    statement.executeUpdate(query);
                    statement.close();
                    connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (y >= 290 && y < 340 && x > 370 && x < 630) {
                // Contiuna
                try {
                    Connection connection = DriverManager.getConnection("jdbc:sqlite:baza_date_joc.db");
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM Game";
                    ResultSet resultSet = statement.executeQuery(query);

                    int lastScore = 0;
                    int lastLevel = 0;

                    // cauta pana la ultimul scor
                    while (resultSet.next()) {
                        lastScore = resultSet.getInt("score");
                        lastLevel = resultSet.getInt("level");
                    }

                    Game.getInstance().score = lastScore;
                    Game.getInstance().level = lastLevel;
                    Game.getInstance().enemy = new Enemy(Game.getInstance().level);
                    Game.getInstance().isInGame = true;

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (y >= 340 && y < 390 && x > 370 && x < 630) {
                // Iesi
                System.exit(0);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
