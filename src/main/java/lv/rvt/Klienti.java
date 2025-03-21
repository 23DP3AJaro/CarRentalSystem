package lv.rvt;


public class Klienti {
    private int Klients_ID;
    private String name;
    private String surname;
    private String birth_date;

    public Klienti (String name, String surname, String birth_date) throws Exception{
        this.Klients_ID = Manager.getLastIdFromCsv("klienti.csv") + 1;
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
