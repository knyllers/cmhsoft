package se.hiltunen;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Calendar {

    private Map<LocalDate, Boolean> calendar = new HashMap<LocalDate, Boolean>();

    public void add(LocalDate date, Boolean enabled) {
        calendar.put(date, enabled);
    }

    public Boolean isEnabled(LocalDate date) {
        return calendar.get(date);
    }

    public List<LocalDate> get(Boolean enabled) {
        if (Objects.isNull(enabled)) return Collections.emptyList();

        Set<Map.Entry<LocalDate, Boolean>> s = calendar.entrySet().stream().filter(
                e -> enabled.equals(e.getValue())).collect(Collectors.toSet());

        List<LocalDate> l = new ArrayList<>();
        s.forEach(e -> {
                l.add(e.getKey());
        });

        return l;
    }

    public Map<LocalDate, Boolean> getCalendar() {
        return calendar;
    }

    public static Calendar from(LocalDate start, int days) {
        Calendar c = new Calendar();
        for (long i = 0L; i < days; i++) {
            c.add(start.plusDays(i), Boolean.TRUE);
        }

        return c;
    }
}
