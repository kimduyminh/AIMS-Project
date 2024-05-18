package AIMS.hust.soict.cybersec.aims.media;

public abstract class media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public media(float cost){
        this.cost = cost;
    }
    public media(int id,String title,String category,float cost){
        this.cost = cost;
        this.title = title;
        this.category = category;
        this.id=id;
    }
    public media(String title){
        this.title=title;
    }
    public media(String title,float cost,String category){
        this.cost = cost;
        this.category = category;
        this.title=title;
    }
    public media(){}

    public String getInfo(){
        return "";
    }
    public boolean equals(media media){
        return this.title.equals(media.getTitle());
    }
}
