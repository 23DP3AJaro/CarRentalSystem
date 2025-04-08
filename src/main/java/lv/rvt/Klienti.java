package lv.rvt;


public class Klienti {
    private int Klients_ID;
    private String name;
    private String surname;
    private String phone_number;

    public Klienti (String name, String surname, String phone_number) throws Exception{
        this.Klients_ID = Manager.getLastIdFromCsv("klienti.csv") + 1;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public int getId() {
        return Klients_ID;
    }
}
