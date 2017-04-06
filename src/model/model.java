package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class model implements iModel {
    User user;


    public List connectToBD()
    {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11167340";

        String userName = "sql11167340";
        String pass = "6ZquUXTW4B";

        Connection conn = null;
        Statement stmt = null;

        try
        {
            //
            Class.forName("com.mysql.jdbc.Driver");

            //
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, userName, pass);

            //
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Users";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);


             List<User> userList = new ArrayList<>();

              while (rs.next())
              {
                  int id = rs.getInt("user_ID");
                  int numb = rs.getInt("number");
                  String name = rs.getString("name");
                  //public List<User> getUsers();

                  user = new User(id, name, numb);
                  userList.add(user);

                  // Testing
/*                  for( int i = 0; i < userList.size(); i++)
                    {
                        System.out.println(userList.get(i));
                    }*/

                    System.out.println(id + " " + numb + " " + name);
              }

            rs.close();
            stmt.close();
            conn.close();

            return userList;
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2)
            {
                // nothing we can do
            }
            try
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace(); //end finally try
            }
        }
        System.out.println("Goodbye!");

        return null;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
