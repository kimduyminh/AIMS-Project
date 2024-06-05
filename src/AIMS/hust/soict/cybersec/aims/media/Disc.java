package AIMS.hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Disc extends Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private int length;
    private List<String> directors=new ArrayList<>();
    public Disc(int id, String title, String category, float cost, int length, List<String> directors) {
        super(id,title,category,cost);
        this.length = length;
        this.directors = directors;
    }
    public Disc(String title) {
        super(title);
    }
    public Disc(String title, String category, float cost) {
        super(title,cost,category);
    }
    public Disc(String title, String category, float cost,List<String> directors) {
        super(title,cost,category);
        this.directors=directors;
    }
    public Disc( String title, String category, float cost, int length, List<String> directors) {
        super(title,cost,category);
        this.length = length;
        this.directors = directors;
    }
}
