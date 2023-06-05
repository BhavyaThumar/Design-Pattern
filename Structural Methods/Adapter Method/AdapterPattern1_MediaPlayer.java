interface MediaPlayer {
    public void play(String type, String fileName);
}

class AudioPlayer implements MediaPlayer {
    public void play(String type, String fileName) {
        MediaPlayer md = new MediaAdapter();
        md.play(type, fileName);
    }
}

class AdvanceMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC " + " type " + fileName);
    }

    public void playMP4(String fileName) {
        System.out.println("Playing MP4 " + " type " + fileName);
    }

    public void playMP3(String fileName) {
        System.out.println("Playing MP3 " + " type " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer adv = new AdvanceMediaPlayer();

    public void play(String type, String fileName) {
        if (type.equalsIgnoreCase("VLC")) {
            adv.playVlc(fileName);
        } else if (type.equalsIgnoreCase("MP3")) {
            adv.playMP3(fileName);
        }

        else if (type.equalsIgnoreCase("MP4")) {
            adv.playMP4(fileName);
        }
    }
}

class AdapterPattern1_MediaPlayer {
    public static void main(String[] args) {
        MediaPlayer m = new AudioPlayer();
        m.play("VLC", "Music.VLC");
        m.play("MP3", "Music2.MP3");
        m.play("MP4", "Music3.MP4");
    }
}