public class Time {
    private int theHour = 0;
    private int theMinute = 0;
    private int theSecond = 0;

    protected String timeSet(int hour, int minute, int second){
        theHour = hour;
        theMinute = minute;
        theSecond = second;

        if ((hour < 24) && (hour >=0)){
            theHour = hour;
        }
        else {
            return "Invalid input: hour";
        }

        if ((minute < 60) && (minute >= 0)){
            theMinute = minute;
        }
        else {
            return "Invalid input: minute";
        }

        if ((second < 60) && (second >= 0)){
            theSecond = second;
        }
        else {
            return "Invalid input: second";
        }

        return showTime();
    }
    protected String showTime(){
        return String.format(Integer.toString(theHour) + ":" + Integer.toString(theMinute) + ":" + Integer.toString(theSecond));
    }
}
