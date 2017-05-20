package ge.mziuri.model;

public class Trade {

    private int ownerID;
    
    private int reciverID;
    
    private int senditemID;
    
    private int reciveitemID;
    
    private boolean traded;
    
    private boolean seen;

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getReciverID() {
        return reciverID;
    }

    public void setReciverID(int reciverID) {
        this.reciverID = reciverID;
    }

    public int getSenditemID() {
        return senditemID;
    }

    public void setSenditemID(int senditemID) {
        this.senditemID = senditemID;
    }

    public int getReciveitemID() {
        return reciveitemID;
    }

    public void setReciveitemID(int reciveitemID) {
        this.reciveitemID = reciveitemID;
    }

    public boolean isTraded() {
        return traded;
    }

    public void setTraded(boolean traded) {
        this.traded = traded;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

}
