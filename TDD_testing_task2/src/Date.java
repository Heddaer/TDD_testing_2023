public class Date {
    private int theYear = 2000;
    private int theMonth = 1;
    private int theDay = 1;

    protected String dateSet(int year, int month, int day){
        if (year >= 2000){
            theYear = year;
        }
        else {
            return "Invalid input: year";
        }

        if ((month <= 12) && (month >= 1)){
            theMonth = month;
        }
        else {
            return "Invalid input: month";
        }

        if ((day <= 31) && (day >= 1)){
            theDay = day;
        }
        else {
            return "Invalid input: day";
        }

        return showDate();
    }
    protected String showDate(){
        return String.format(Integer.toString(theYear) + ":" + Integer.toString(theMonth) + ":" + Integer.toString(theDay));
    }
}
