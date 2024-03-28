package Aims;

import java.util.ArrayList;

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
    }
    public DigitalVideoDisc(String title,String category,String director,int length,float cost){
        this.title=title;
        this.category=category;
        this.director=director;
        this.length=length;
        this.cost=cost;
    }

    public String getTitle() {

        return this.title;
    }
    public String play(){
        if(this.length<=0){
            return "DVD can't be played";
        }
        else return "lalala";
    }

    public float getCost() {
        return cost;
    }
    public String getInfo(){
        return this.title+" "+this.director+"\n"+"Category: "+this.category+"\n"+"Length: "+this.length+"\n"+"Price: "+this.cost+"\n";
    }

    public String getCategory() {
        return category;
    }


}
