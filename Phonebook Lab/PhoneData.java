public class PhoneData {
    private String firstname;
    private String lastname;
    private String phoneNum;
    private String address;
    private String city;
    private String state;
    private String zip;
    
    

    public PhoneData(String firstname, String lastname, String phoneNum, String address, String city, String state, String zip) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNum = phoneNum;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String toString() {
        return "Name: " + firstname + " " + lastname + "\nPhone Number: " + phoneNum + "\nAddress: " + address + ", " + city + ", " + state + ", " + zip; 
    }
}
