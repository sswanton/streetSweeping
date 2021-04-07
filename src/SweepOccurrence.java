import java.time.DayOfWeek;
import java.util.HashSet;

public class SweepOccurrence {

    private final DayOfWeek day;
    private final SweepTime sweepTime;
    private final HashSet<Integer> weeks;

    public SweepOccurrence(DayOfWeek day, SweepTime sweepTime, HashSet<Integer> weeks) {
        this.day = day;
        this.sweepTime = sweepTime;
        this.weeks = weeks;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public SweepTime getSweepTime() {
        return sweepTime;
    }

    public HashSet<Integer> getWeeks() {
        return weeks;
    }

}
