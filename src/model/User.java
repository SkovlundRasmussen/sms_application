package model;

/**
 * Created by krist on 31-03-2017.
 */
public class User {

    int user_id;
    String name;
    int number;

    public User(int id, String name, int number )
    {
        this.user_id = id;
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {

        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
