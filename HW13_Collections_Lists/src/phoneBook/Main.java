package phoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Bob", "39887438324"));
        phoneBook.add(new Record("Bob", "74837338324"));
        phoneBook.add(new Record("Jack", "45674635363"));

        System.out.println(phoneBook.find("Bob"));
        System.out.println(phoneBook.find("Jack"));
        System.out.println(phoneBook.findAll("Bob"));
    }
}
