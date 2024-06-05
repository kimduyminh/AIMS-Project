package AIMS.hust.soict.cybersec.aims.media;

import AIMS.hust.soict.cybersec.aims.PlayerException;

import java.util.List;

public class DigitalVideoDisc extends Disc implements Playable{
    private String title;
    private String category;
    private List<String> director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director.toString();
    }

    public void setDirector(String director) {
        this.director.add(director);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title,category,cost);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, List<String> director, float cost) {
        super(title, category,cost,director);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, List<String> director, int length, float cost) {
        super(title,category,cost,length,director);
        nbDigitalVideoDiscs++;
    }
    public String getInfo(){
        return this.title+" by "+this.director.toString()+"\n"+"Category: "+this.category+"\n"+"Length: "+this.length+"\n"+"Price: "+this.cost+"\n";
    }
    public boolean isMatch(String title){
        return this.title.equals(title);
    }
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive");
            throw new PlayerException("Track length is non-positive");
        } else {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
    }
}
