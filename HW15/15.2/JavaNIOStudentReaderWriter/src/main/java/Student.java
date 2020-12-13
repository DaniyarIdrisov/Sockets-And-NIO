import java.time.LocalDate;

public class Student {

    private String name;
    private String gender;
    private LocalDate dateBirth;

    public Student(String name, String gender, LocalDate dateBirth) {
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return name + ", " + gender + ", " + dateBirth;
    }
}
