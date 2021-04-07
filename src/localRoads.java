import org.jetbrains.annotations.NotNull;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class localRoads {

    private final HashSet<IRoadwayImpl> roadSet;

    public localRoads() {
        roadSet = (HashSet<IRoadwayImpl>) this.populateRoadSet();
    }

    //TODO: Not hardcode this. Look into pinging https://www.somervillema.gov/sweeping
    // Never heard back when I reached out asking about a public API
    private Set<IRoadwayImpl> populateRoadSet() {
        HashSet<Integer> firstAndThird = new HashSet<>();
        firstAndThird.add(1);
        firstAndThird.add(3);

        HashSet<Integer> secondAndFourth = new HashSet<>();
        secondAndFourth.add(2);
        secondAndFourth.add(4);

        SweepOccurrence thursdayMorning13 = new SweepOccurrence(DayOfWeek.THURSDAY, SweepTime.morningEightToNoon, firstAndThird);
        SweepOccurrence fridayMorning13 = new SweepOccurrence(DayOfWeek.FRIDAY, SweepTime.morningEightToNoon, firstAndThird);
        SweepOccurrence fridayMorning24 = new SweepOccurrence(DayOfWeek.FRIDAY, SweepTime.morningEightToNoon, secondAndFourth);
        SweepOccurrence mondayMorning = new SweepOccurrence(DayOfWeek.MONDAY, SweepTime.morningEightToNoon, secondAndFourth);
        SweepOccurrence mondayNight = new SweepOccurrence(DayOfWeek.TUESDAY, SweepTime.overnightMidnightToSix, null);
        SweepOccurrence wednesdayNight = new SweepOccurrence(DayOfWeek.THURSDAY, SweepTime.overnightMidnightToSix, null);

        IRoadwayImpl somervilleAveOdd = new IRoadwayImpl("Somerville Ave", 1.0, "odd", wednesdayNight);
        IRoadwayImpl somervilleAveEven = new IRoadwayImpl("Somerville Ave", 1.0, "even", mondayNight);
        IRoadwayImpl graniteStOdd = new IRoadwayImpl("Granite St", 1.0, "odd", thursdayMorning13);
        IRoadwayImpl graniteStEven = new IRoadwayImpl("Granite St", 1.0, "even", fridayMorning24);
        IRoadwayImpl knappStOdd = new IRoadwayImpl("Knapp St", 1.0, "odd", thursdayMorning13);
        IRoadwayImpl knappStEven = new IRoadwayImpl("Knapp St", 1.0, "even", fridayMorning24);
        IRoadwayImpl schoolStOdd = new IRoadwayImpl("School St", 1.0, "odd", fridayMorning13);
        IRoadwayImpl schoolStEven = new IRoadwayImpl("School St", 1.0, "even", mondayMorning);

        Set<IRoadwayImpl> localRoads = new HashSet<>();
        localRoads.add(somervilleAveEven);
        localRoads.add(somervilleAveOdd);
        localRoads.add(graniteStOdd);
        localRoads.add(graniteStEven);
        localRoads.add(knappStOdd);
        localRoads.add(knappStEven);
        localRoads.add(schoolStOdd);
        localRoads.add(schoolStEven);

        return localRoads;
    }

    /**
     * Facilitates giving a heads up the day before a midnight-start time
     *
     * @param road roadway object containing all relevant info
     * @return the day of the week in integer form. the DayOfWeek is not the same as Calendar.DAY_OF_WEEK
     */
    private int overnightCheck(IRoadwayImpl road) {
        int dayOfTheWeek = road.getSweepDateAndTime().getDay().getValue();
        if (road.getSweepDateAndTime().getSweepTime() == SweepTime.overnightMidnightToSix) {
            return dayOfTheWeek;
        } else {
            return dayOfTheWeek + 1;
        }
    }


    public String whereNoPark(@NotNull Calendar now) {
        int today = now.get(Calendar.DAY_OF_WEEK);
        for (IRoadwayImpl road : this.roadSet) {
            if (overnightCheck(road) == today) {
                if (road.getSweepDateAndTime().getWeeks() == null) {
                    return ("ALERT DON'T PARK ON THE " + road.getSideOfRoad() + " side of " + road.getRoadwayName());
                } else {
                    if (road.getSweepDateAndTime().getWeeks().contains(now.get(Calendar.WEEK_OF_MONTH))) {
                        return ("ALERT DON'T PARK ON THE " + road.getSideOfRoad() + " side of " + road.getRoadwayName());
                    }
                }
            }
        }
        return "Don't worry about it";
    }
}
