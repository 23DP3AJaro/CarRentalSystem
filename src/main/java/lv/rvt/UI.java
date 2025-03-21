package lv.rvt;

public class UI {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void MainMenu() throws Exception{
        UImethods.clearScreen();
        System.out.println("______      _          ______           _                     _______");
        System.out.println("|  _  \\    (_)         | ___ \\         | |                   //  ||\\ \\");
        System.out.println("| | | |_ __ ___   _____| |_/ /___ _ __ | |_            _____//___||_\\ \\___");
        System.out.println("| | | | '__| \\ \\ / / _ \\    // _ \\ '_ \\| __|           )  _          _    \\");
        System.out.println("| |/ /| |  | |\\ V /  __/ |\\ \\  __/ | | | |_            |_/ \\________/ \\___|");
        System.out.println("|___/ |_|  |_| \\_/ \\___\\_| \\_\\___|_| |_|\\__|          ___\\_/________\\_/______");
        System.out.println();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu pārvaldība");
        System.out.println("2. Statistika");
        UImethods.ChangePositionMainMenu();
    }

    public static void MainMenuIncorrectPosition() throws Exception{
        UImethods.clearScreen();
        System.out.println("______      _          ______           _                     _______");
        System.out.println("|  _  \\    (_)         | ___ \\         | |                   //  ||\\ \\");
        System.out.println("| | | |_ __ ___   _____| |_/ /___ _ __ | |_            _____//___||_\\ \\___");
        System.out.println("| | | | '__| \\ \\ / / _ \\    // _ \\ '_ \\| __|           )  _          _    \\");
        System.out.println("| |/ /| |  | |\\ V /  __/ |\\ \\  __/ | | | |_            |_/ \\________/ \\___|");
        System.out.println("|___/ |_|  |_| \\_/ \\___\\_| \\_\\___|_| |_|\\__|          ___\\_/________\\_/______");
        System.out.println();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu pārvaldība");
        System.out.println("2. Statistika");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionMainMenu();
    }

    public static void ShowStatistics() throws Exception{
        
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Statistika -> \n" + ANSI_RESET);
        System.out.println("1. Vidējais nobraukums");
        System.out.println("2. Kopēja peļņa");
        System.out.println("3. Peļņa no viena mašīna");
        System.out.println("4. Atpakaļ");

        UImethods.ChangePositionStatistics();
    }

    public static void ShowStatisticsIncorrectPosition() throws Exception{
        
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Statistika -> \n" + ANSI_RESET);
        System.out.println("1. Vidējais nobraukums");
        System.out.println("2. Kopēja peļņa");
        System.out.println("3. Peļņa no viena mašīna");
        System.out.println("4. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionStatistics();
    }

    public static void ShowCarControl() throws Exception{
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Mašīnu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu saraksts");
        System.out.println("2. Pievienot mašīnu");
        System.out.println("3. Izdzēst mašīnu");
        System.out.println("4. Rediģēt mašīnu");
        System.out.println("5. Atpakaļ");

        UImethods.ChangePositionCarControl();
    }

    public static void ShowCarControlIncorrectPosition() throws Exception{
        UImethods.clearScreen();
        System.out.println("\n" + ANSI_YELLOW + "Sakums -> Mašīnu pārvaldība -> \n" + ANSI_RESET);
        System.out.println("1. Mašīnu saraksts");
        System.out.println("2. Pievienot mašīnu");
        System.out.println("3. Izdzēst mašīnu");
        System.out.println("4. Rediģēt mašīnu");
        System.out.println("5. Atpakaļ");

        System.out.println(ANSI_RED + "Nav tādu poziciju!" + ANSI_RESET);
        UImethods.ChangePositionCarControl();
    }
}
