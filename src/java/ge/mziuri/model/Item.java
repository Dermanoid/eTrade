package ge.mziuri.model;

public class Item {

    private int id;
    private User user;
    private String photo;
    private String Name;
    public int Point;
    public ProdType type;
    
    public Item() {
    }

    public Item(int id, User user, String photo, String Name, int Point, ProdType type) {
        this.id = id;
        this.user = user;
        this.photo = photo;
        this.Name = Name;
        this.Point = Point;
        this.type = type;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
