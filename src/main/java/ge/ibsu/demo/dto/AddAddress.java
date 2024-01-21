package ge.ibsu.demo.dto;

public class AddAddress {

    private String address;
    private String postalCode;

    private AddCity city;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddCity getCity() {
        return city;
    }

    public void setCity(AddCity city) {
        this.city = city;
    }
}
