import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class noMoreTickets {

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();
        localRoads roadways = new localRoads();
        System.out.println(roadways.whereNoPark(now));

    }
}

// Granite St,  Odd Side 1st 3Rd Thursday 8Am 12Pm
// Granite St,  Even Side 2nd 4Th Friday 8Am 12Pm
// Knapp St Odd Side 1st 3Rd Thursday 8Am 12Pm
// Knapp St Even Side 2nd 4Th Friday 8Am 12Pm
// School St Odd Side 1st 3Rd Friday 8Am 12Pm
// School St Even Side 2nd 4Th Monday 8Am 12Pm
// Somerville Ave 12AM to 6AM - 2 Even Side Tuesday
// Somerville Ave 12AM to 6AM - 1 Odd Side Thursday
