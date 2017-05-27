package ge.mziuri.model;

public class Trade {

    private Item sendItem;
    
    private Item receiveItem;
    
    private boolean traded;
    
    private boolean seen;

    public Item getSendItem() {
        return sendItem;
    }

    public void setSendItem(Item sendItem) {
        this.sendItem = sendItem;
    }

    public Item getReceiveItem() {
        return receiveItem;
    }

    public void setReceiveItem(Item receiveItem) {
        this.receiveItem = receiveItem;
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
