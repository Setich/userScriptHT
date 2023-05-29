package my;

public class Main {
    public static void main(String[] args) {
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.start("C:\\Users\\Aleksey\\IdeaProjects\\userScript\\src\\main\\resources\\users.csv",
                "C:\\Users\\Aleksey\\Desktop\\WebTours\\cgi-bin\\users");
    }
}
