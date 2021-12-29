import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage extends JPanel {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    Connection conn= DriverManager.getConnection(dbUrl, "postgres", "Swamiji812!");
    private JButton logBut;
    private JLabel user;
    private JLabel pass;
    private TextField userfield;
    private JPasswordField passfield;
    private JLabel title;
    private double width = 1200;
    private double height = 800;

    public LoginPage() throws SQLException {
        setLayout(null);

        title = new JLabel("Health Sentinel");
        title.setBounds((int) (width*0.37),(int) (height*0.1),900,60);
        title.setFont(new Font("Times New Roman",Font.BOLD, 60));
        title.setForeground(Color.blue);
        add(title);


        user = new JLabel("Username");
        user.setBounds((int) (width*0.32), (int) (height*0.4),150,40);
        user.setForeground(Color.black);
        user.setFont(new Font("Times New Roman",Font.PLAIN, 32));
        add(user);

        userfield = new TextField(20);
        userfield.setBounds((int) (width*0.5),(int) (height*0.4),300,40);
        userfield.setFont(new Font("Times New Roman",Font.PLAIN, 32));
        add(userfield);

        pass = new JLabel("Password");
        pass.setBounds((int) (width*0.32),(int) (height*0.5),150,40);
        pass.setForeground(Color.black);
        pass.setFont(new Font("Times New Roman",Font.PLAIN, 32));
        add(pass);

        passfield = new JPasswordField(20);
        passfield.setBounds((int) (width*0.5),(int) (height*0.5),300,40);
        passfield.setFont(new Font("Times New Roman",Font.PLAIN, 32));
        add(passfield);

        logBut = new JButton("Login");
        logBut.setBounds((int) (width*0.465),(int) (height*0.6),150,60);
        logBut.setFont(new Font("Times New Roman",Font.PLAIN, 32));
        logBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usertext = userfield.getText();
                String passwordtext = String.valueOf(passfield.getPassword());
                System.out.println(passwordtext);
                int valid = 0;

                try {
                    System.out.println("Entered");
                    Statement s = conn.createStatement();
                    String sqlStr = "SELECT * FROM doctors WHERE id =1;";
                    ResultSet rset = s.executeQuery(sqlStr);


                    while (rset.next()) {
                        String usernamedb = rset.getString("username");
                        String passwordnamedb = rset.getString("password");
                        if (usernamedb.equals(usertext)){
                            System.out.println("Username successful");
                            valid ++;
                            if (passwordnamedb.equals(passwordtext)){
                                System.out.println("Password successful");
                                valid++;
                            }
                            else{
                                System.out.println("Password failed");
                            }
                        }
                        else{
                            System.out.println("Username failed");
                        }
                    }
                    rset.close();
                    s.close();
                    conn.close();
                }
                catch (Exception ep){}

                if (valid == 2){
                    System.out.println("Login Successful");
                }
            }
        });
        add(logBut);

    }


}
