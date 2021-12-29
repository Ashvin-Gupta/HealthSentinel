import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main {
    static GraphicsConfiguration gc;
    public static void main(String[] args) throws SQLException {
        System.out.println("Working");
//        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
//        try {
//        // Registers the driver
//            Class.forName("org.postgresql.Driver");
//        } catch (Exception e) {
//        }
//        Connection conn= DriverManager.getConnection(dbUrl, "postgres", "Swamiji812!");

        JFrame frame= new JFrame(gc);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.getContentPane().add(new ButtonPanel());
        frame.setVisible(true);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);






    }





}
