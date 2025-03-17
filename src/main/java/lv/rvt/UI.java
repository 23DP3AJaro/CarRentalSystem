package lv.rvt;

public class UI {
    public static void MainMenu() throws Exception{
        System.out.println("Sakums -> \n");
        System.out.println("1. Mašīnu pārvaldība");
        System.out.println("2. Statistika\n");
        UImethods.ChangePositionMainMenu();
    }

    public static void ShowStatistics() throws Exception{
        

        System.out.println("Sakums -> Statistika -> \n");
        System.out.println("1. Vidējais nobraukums");
        System.out.println("2. Kopēja peļņa");
        System.out.println("3. Peļņa no viena mašīna");
        System.out.println("4. Atpakaļ\n");

        UImethods.ChangePositionStatistics();
    }
}
