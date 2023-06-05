import java.util.ArrayList;
import java.util.List;

interface ChannelIterator {
    boolean hasNext();
    Channel getNext();
}

class Channel {
    private double number;
    private String type;

    Channel(double num, String t) {
        number = num;
        type = t;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Channel number=" + number + ", type=" + type;
    }
}

class TVChannelIterator implements ChannelIterator {
    private List<Channel> channels;
    private int currentPosition;

    public TVChannelIterator(List<Channel> channels) {
        this.channels = channels;
        currentPosition = 0;
    }

    public boolean hasNext() {
        return currentPosition < channels.size();
    }

    public Channel getNext() {
        if (hasNext()) {
            Channel channel = channels.get(currentPosition);
            currentPosition++;
            return channel;
        }
        return null;
    }
}

class ChannelCollection {
    List<Channel> channels = new ArrayList<>();

    public void addChannel(Channel c) {
        channels.add(c);
    }

    public void removeChannel(Channel c) {
        channels.remove(c);
    }

    public ChannelIterator getIterator() {
        return new TVChannelIterator(channels);
    }
}

public class Iterator1 {
    public static void main(String[] args) {
        ChannelCollection collection = new ChannelCollection();
        collection.addChannel(new Channel(1, "News"));
        collection.addChannel(new Channel(2, "Movies"));
        collection.addChannel(new Channel(3, "Sports"));

        ChannelIterator iterator = collection.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext());
        }
    }
}
