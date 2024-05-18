package AIMS.hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class compactDisc extends media implements Playable{
    private String artist;
    private List<track> tracks=new ArrayList<>();

    public String getArtist() {
        return artist;
    }
    public compactDisc(){
        super();
    }
    public void addTrack(track track){
        tracks.add(track);
    }
    public void removeTrack(track track){
        tracks.remove(track);
    }
    public int getLength(){
        int sumLength=0;
        for (track track : tracks){
            sumLength+=track.getLength();
        }
        return sumLength;
    }
    public void play(){
        System.out.println("CD Name: "+this.getTitle());
        for (track track : tracks){
            track.play();
        }
    }
    public String getInfo(){
        return this.getTitle() +" by "+this.artist+"\n"+"Category: "+ this.getCategory() +"\n"+"Length: "+this.getLength()+"\n"+"Price: "+ this.getCost() +"\n";
    }
}
