package lv.rvt;

public class UI {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void MainMenu() throws Exception{
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu pārvaldība");
        System.out.println("2. Statistika");
        UImethods.ChangePositionMainMenu();
    }

    public static void ShowStatistics() throws Exception{
        

        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Statistika -> \n" + ANSI_RESET);
        System.out.println("1. Vidējais nobraukums");
        System.out.println("2. Kopēja peļņa");
        System.out.println("3. Peļņa no viena mašīna");
        System.out.println("4. Atpakaļ");

        UImethods.ChangePositionStatistics();
    }

    public static void ShowCarControl() throws Exception{
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Mašīnu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Pievienot mašīnu");
        System.out.println("2. Izdzēst mašīnu");
        System.out.println("3. Rediģēt mašīnu");
        System.out.println("4. Atpakaļ");

        UImethods.ChangePositionCarControl();
    }
}
