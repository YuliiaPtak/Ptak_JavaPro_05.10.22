public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("/path/to/file", new FileData("firstApp.java", 1024, "/path/to/file"));
        fileNavigator.add("/path/to/file", new FileData("files.txt", 64, "/path/to/file"));

        System.out.println(fileNavigator.find("/path/to/file"));
        System.out.println(fileNavigator.filterBySize(64L));
        System.out.println(fileNavigator.sortBySize());
        fileNavigator.remove("/path/to/file");
        System.out.println(fileNavigator.sortBySize());
    }
}
