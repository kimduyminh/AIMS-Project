package AIMS.hust.soict.cybersec.aims.media;

import AIMS.hust.soict.cybersec.aims.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Media implements Playable{
    private String artist;
    private List<track> tracks=new ArrayList<>();

    public String getArtist() {
        return artist;
    }
    public CompactDisc(){
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
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive");
            throw new PlayerException("CD length is non-positive");
        }

        Iterator<track> iter = tracks.iterator();
        while (iter.hasNext()) {
            track nextTrack = iter.next();
            nextTrack.play();
        }
    }
    public String getInfo(){
        return this.getTitle() +" by "+this.artist+"\n"+"Category: "+ this.getCategory() +"\n"+"Length: "+this.getLength()+"\n"+"Price: "+ this.getCost() +"\n";
    }
}
