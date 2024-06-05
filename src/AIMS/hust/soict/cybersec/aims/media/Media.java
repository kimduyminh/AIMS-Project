package AIMS.hust.soict.cybersec.aims.media;

public abstract class Media {
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
    public Media(float cost){
        this.cost = cost;
    }
    public Media(int id, String title, String category, float cost){
        this.cost = cost;
        this.title = title;
        this.category = category;
        this.id=id;
    }
    public Media(String title){
        this.title=title;
    }
    public Media(String title, float cost, String category){
        this.cost = cost;
        this.category = category;
        this.title=title;
    }
    public Media(){}

    public String getInfo(){
        return "";
    }
    public boolean equals(Media media){
        return this.title.equals(media.getTitle());
    }
}
