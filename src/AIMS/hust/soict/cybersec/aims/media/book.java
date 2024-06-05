package AIMS.hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class book extends Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors=new ArrayList<>();

    public book(int id,String title,String category,float cost,List<String> authors) {
        super(id,title,category,cost);
        this.authors=authors;
    }

    public void addAuthor(String author){
        this.authors.add(author);
    }
    public void removeAuthor(String author){
        this.authors.remove(author);
    }
    public String getInfo(){
        return this.title+" by "+this.authors.toString()+"\n"+"Category: "+this.category+"\n"+"Price: "+this.cost+"\n";
    }
}