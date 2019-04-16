package rocks.zipcode.io.objectorientation;


public class Television {

    private boolean turnedOn;
    private TVChannel channel;

    public Television(){
        this.turnedOn = false;
        this.channel = null;
    }

    public void turnOn() {
        turnedOn = true;
    }

    public void setChannel(Integer channel) {
        if(!turnedOn){
            throw new IllegalStateException("TV must be turned on to change the channel!");
        }
        this.channel = TVChannel.getByOrdinal(channel);
    }

    public TVChannel getChannel() {
        return channel;
    }
}
