package Aims;

import java.util.ArrayList;

public class database {
    DigitalVideoDisc disc1 = new DigitalVideoDisc(
            "The Lion King",
            "Animation",
            "Roger Allers",
            87,
            19.95f
    );

    DigitalVideoDisc disc2 = new DigitalVideoDisc(
            "Star Wars",
            "Science Fiction",
            "George Lucas",
            87,
            24.95f
    );

    DigitalVideoDisc disc3 = new DigitalVideoDisc(
            "Aladin",
            "Animation",
            "hieu",
            20,
            18.99f
    );
    DigitalVideoDisc disc4 = new DigitalVideoDisc(
            "Maniac",
            "KPOP",
            "Viviz",
            189,
            21.99f
    );
    DigitalVideoDisc disc5 = new DigitalVideoDisc(
            "Flashbang dance",
            "USUK",
            "The Vekkars",
            253,
            5.99f
    );
    DigitalVideoDisc disc6=new DigitalVideoDisc(
            "Perfect Night",
            "KPOP",
            "LE SERRAFIM",
            326,
            7.99f
    );
    public String searchByKeyword(ArrayList<DigitalVideoDisc> data,String searchKeyword){
        StringBuilder message=new StringBuilder();
        for (int i=0;i<data.size();i++){
            if(data.get(i).getTitle().contains(searchKeyword)){
                message.append(data.get(i).getInfo());
            }
        }
        return message.toString();
    }

}
