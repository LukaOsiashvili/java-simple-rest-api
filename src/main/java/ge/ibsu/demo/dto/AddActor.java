package ge.ibsu.demo.dto;

public class AddActor {

    private String firstName;
    private String lastName;
    private Boolean isActive;
    private AddAddress address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public AddAddress getAddress() {
        return address;
    }

    public void setAddress(AddAddress address) {
        this.address = address;
    }
}
