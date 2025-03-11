package lv.rvt;


public class Klients {
    
    private String name;
    private String surname;
    private int birth_date;

    public Klients (String name, String surname, int birth_date){
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

    public int getBirthDate() {
        return birth_date;
    }

}
