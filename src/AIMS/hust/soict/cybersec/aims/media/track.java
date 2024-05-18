package AIMS.hust.soict.cybersec.aims.media;

public class track implements Playable{
    private String title;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public void play(){
        System.out.println(this.title);
    }
    public boolean equals(track track){
        return this.title.equals(track.title) && this.length ==track.length;
    }
}
