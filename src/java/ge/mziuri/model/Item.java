package ge.mziuri.model;

import java.util.List;

public class Item {

    private int id;
    
    private User user;

    private List<String> photoes;
    
    private String name;
    
    public int point;
    
    public ProdType type;
    
    public Item() {
    }

    public Item(List<String> photoes) {
        this.photoes = photoes;
    }

    public Item(int id, User user, List<String> photoes , String name, int point, ProdType type) {
        this.id = id;
        this.user = user;
        this.photoes = photoes;
        this.name = name;
        this.point = point;
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

    public List<String> getPhotoes() {
        return photoes;
    }

    public void setPhotoes(List<String> photoes) {
        this.photoes = photoes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
