public class Clock {
    private Time theTime = new Time();
    private Date theDate = new Date();
    State state = State.display_time;

    public String changeMode(){
        if (state == State.display_time){
            state = State.display_date;
            return "Switching to date";
        }
        else if(state == State.display_date){
            state = State.display_time;
            return "Switching to time";
        }
        else {
            return "Error: can't change mode when changing time/date";
        }
    }

    public String ready(){
        if (state == State.display_time){
            state = State.change_time;
            return "Give time:";
        }
        else if (state == State.display_date){
            state = State.change_date;
            return "Give date:";
        }
        else if(state == State.change_date){
            return "Error: already in change date mode";
        }
        else{
            return "Error: already in change time mode";
        }
    }

    public String set(int p1, int p2, int p3){
        if (state == State.change_time){
            state = State.display_time;
            return theTime.timeSet(p1,p2,p3);

        }
        else if (state == State.change_date){
            state = State.display_date;
            return theDate.dateSet(p1, p2, p3);
        }
        else{
            return "Error: Can't set in display mode";
        }
    }
}
