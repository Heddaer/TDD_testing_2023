import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClockTest {
    Clock clock;

    @BeforeEach
    void init(){
        clock = new Clock();
        System.out.println("============================");
    }


    @Test
    void DTtoDD(){
        assertEquals("Switching to date", clock.changeMode());
    }

    @Test
    void DDtoDT(){
        clock.changeMode();
        assertEquals("Switching to time", clock.changeMode());
    }

    @Test
    void DDtoCD(){
        clock.changeMode();
        assertEquals("Give date:", clock.ready());
    }
    @Test
    void CDtoDD(){
        clock.changeMode();
        clock.ready();
        assertEquals("2023:10:11", clock.set(2023, 10, 11));
    }

    @Test
    void DTtoCT() {
        assertEquals("Give time:", clock.ready());
    }

    @Test
    void CTtoDT(){
        clock.ready();
        assertEquals("14:30:30", clock.set(14, 30, 30));
    }

    @Test
    void incorrectTransitionCTtoCT(){
        clock.ready();
        assertEquals("Error: already in change time mode", clock.ready());
    }

    @Test
    void incorrectTransitionCDtoCD(){
        clock.changeMode();
        clock.ready();
        assertEquals("Error: already in change date mode", clock.ready());
    }

    @Test
    void incorrectTransitionsSet(){
        assertEquals("Error: Can't set in display mode", clock.set(0,0,0));
    }

    @Test
    void incorrectTransitionsChangeMode(){
        clock.ready();
        assertEquals("Error: can't change mode when changing time/date", clock.changeMode());
    }

    /*---------------- BVA TIME --------------*/

    @Test
    void hourUpperBVA(){
        clock.ready();
        assertEquals("Invalid input: hour", clock.set(24, 30, 30));
    }
    @Test
    void hourLowerBVA(){
        clock.ready();
        assertEquals("Invalid input: hour", clock.set(-1, 30, 30));
    }
    @Test
    void hourUpperValidBVA(){
        clock.ready();
        assertEquals("23:30:30", clock.set(23, 30, 30));
    }
    @Test
    void hourLowerValidBVA(){
        clock.ready();
        assertEquals("0:30:30", clock.set(00, 30, 30));
    }
    @Test
    void minuteUpperBVA(){
        clock.ready();
        assertEquals("Invalid input: minute", clock.set(23, 60, 30));
    }
    @Test
    void minuteLowerBVA(){
        clock.ready();
        assertEquals("Invalid input: minute", clock.set(23, -1, 30));
    }
    @Test
    void minuteUpperValidBVA(){
        clock.ready();
        assertEquals("23:59:30", clock.set(23, 59, 30));
    }
    @Test
    void minuteLowerValidBVA(){
        clock.ready();
        assertEquals("0:0:30", clock.set(00, 00, 30));
    }

    @Test
    void secondUpperBVA(){
        clock.ready();
        assertEquals("Invalid input: second", clock.set(23, 59, 60));
    }
    @Test
    void secondLowerBVA(){
        clock.ready();
        assertEquals("Invalid input: second", clock.set(23, 59, -1));
    }
    @Test
    void secondUpperValidBVA(){
        clock.ready();
        assertEquals("23:59:59", clock.set(23, 59, 59));
    }
    @Test
    void secondLowerValidBVA(){
        clock.ready();
        assertEquals("0:0:0", clock.set(00, 00, 00));
    }

    /*---------------- BVA DATE --------------*/
    @Test
    void yearLowerBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("Invalid input: year", clock.set(1999, 1, 1));
    }
    @Test
    void yearValidBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("2023:1:1", clock.set(2023, 1, 1));
    }

    @Test
    void monthUpperBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("Invalid input: month", clock.set(2023, 13, 1));
    }
    @Test
    void monthLowerBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("Invalid input: month", clock.set(2023, 0, 1));
    }
    @Test
    void monthUpperValidBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("2023:12:1", clock.set(2023, 12, 1));
    }
    @Test
    void monthLowerValidBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("2023:1:2", clock.set(2023, 1, 2));
    }

    @Test
    void dayUpperBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("Invalid input: day", clock.set(2023, 12, 32));
    }
    @Test
    void dayLowerBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("Invalid input: day", clock.set(2023, 12, 0));
    }
    @Test
    void dayUpperValidBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("2023:12:31", clock.set(2023, 12, 31));
    }
    @Test
    void dayLowerValidBVA(){
        clock.changeMode();
        clock.ready();
        assertEquals("2023:1:1", clock.set(2023, 1, 1));
    }


}