package management;

public class Owner {
    String name;
    String lastname;
    Role role;

    public Owner(String name, String lastname, Role role) {
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public  String getFullName(){
        return this.name+" "+ this.lastname;
    }
}
