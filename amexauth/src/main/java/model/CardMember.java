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
        firstName="";
        lastName="";

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
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CardMember member = (CardMember) obj;
        if (member.id != id) {
            return false;
        }

        return true;
    }

}
