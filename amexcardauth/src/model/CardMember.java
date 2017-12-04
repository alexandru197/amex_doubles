 package model;

public class CardMember {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String streetAddr;
    private String city;
    private long post_code;
    private String country;
    private int phone;

    CardMember(){
        id=0;


    }
    public CardMember(int id, String firstName,String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public void addMoreInfo(String email,String streetAddr,String city, long post_code,String country,int phone){
        this.email=email;
        this.streetAddr=streetAddr;
        this.city=city;
        this.post_code=post_code;
        this.country=country;
        this.phone=phone;
    }

}
