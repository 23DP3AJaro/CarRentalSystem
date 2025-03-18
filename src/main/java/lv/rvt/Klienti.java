package lv.rvt;


public class Klienti {
    private int Klients_ID;
    private static int nextId = 1;
    private String name;
    private String surname;
    private String birth_date;

    public Klienti (String name, String surname, String birth_date){
        this.Klients_ID = nextId++;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birth_date;
    }

    public int getId() {
        return Klients_ID;
    }
}
