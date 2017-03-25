package ge.mziuri.model;

public class Item {

    public User user;
    private String photo;
    private String Name;
    public int Point;

    public Item() {
    }

    public Item(String photo, String Name, int Point, User User) {
        this.photo = photo;
        this.Name = Name;
        this.Point = Point;
        this.user = User;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

}
