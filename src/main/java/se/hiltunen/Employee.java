package se.hiltunen;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "user_name")
public class Employee {

    @Id
    private int id;
    private String name;
    private Calendar calendar;

    public void setupCalendar(LocalDate start, LocalDate end) {
        Period p = Period.between(start, end);
        Calendar c = Calendar.from(start, p.getDays());
        calendar = c;
    }
}