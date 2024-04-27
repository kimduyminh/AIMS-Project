package hust.soict.cybersec.Aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public DigitalVideoDisc(){
        this.title="";
        this.category="";
        this.director="";
        this.length=0;
        this.cost=0;
        nbDigitalVideoDiscs+=1;
    }
    public DigitalVideoDisc(String title){
        this.title=title;
        this.category="";
        this.director="";
        this.length=0;
        this.cost=0;
        nbDigitalVideoDiscs+=1;
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        this.title=title;
        this.category=category;
        this.director=director;
        this.length=length;
        this.cost=cost;
        nbDigitalVideoDiscs+=1;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }
    public String getInfo(){
        return this.title+" by "+this.director+"\n"+"Category: "+this.category+"\n"+"Length: "+this.length+"\n"+"Price: "+this.cost+"\n";
    }

    public String getCategory() {
        return category;
    }
    class nbDigitalVideoDiscs{

    }
    private static int nbDigitalVideoDiscs =0;

}
