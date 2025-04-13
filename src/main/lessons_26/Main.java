package main.lessons_26;

public class Main {
    public static void main(String[] args) {
        User user = new User("Vova");
        Address address = new Address("Kolotyshkina, 7", "Chornobl","Kiribaty");
        user.setAddress(address);
        System.out.println("name: " + user.getName()+ ", address: " + user.getAddress());
    }
}
