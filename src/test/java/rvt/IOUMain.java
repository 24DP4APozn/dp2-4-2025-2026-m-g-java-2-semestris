package rvt;

public class IOUMain {
    public static void main(String[] args) {
        IOU mattsIOU = new IOU();

        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Michael", 30);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));
        System.out.println(mattsIOU.howMuchDoIOweTo("John"));

        mattsIOU.setSum("Arthur", 10.5);
        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
    }
}   