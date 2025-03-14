package lv.rvt;


public class Klienti {
    
    private String name;
    private String surname;
    private String birth_date;

    public Klienti (String name, String surname, String birth_date){
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

}
