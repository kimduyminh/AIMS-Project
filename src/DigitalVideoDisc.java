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
        return this.title+" "+this.director+"\n"+"Category: "+this.category+"+\n"+this.length+"\n"+this.cost;
    }

    public String getCategory() {
        return category;
    }

}
