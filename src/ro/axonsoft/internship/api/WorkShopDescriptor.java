package ro.axonsoft.internship.api;

public class WorkShopDescriptor implements Descriptor,Comparable<WorkShopDescriptor> {
    /**
     * Implmenteaza si Comparable pentru a putea sorta dupa ore si a usura gasirea solutiei
     */

    private String Description;
    private String Domain;
    private Integer Room;
    private String StartHour;
    private Integer Time;


    public WorkShopDescriptor(String description, String domain, Integer room, String startHour, Integer time) {
        Description = description;
        Domain = domain;
        Room = room;
        if(startHour.length()==5) {                         //pastrare consistentei datelor
            StartHour = startHour;
        }
        else {
            StartHour="0"+startHour;
        }
        Time = time;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public Integer getRoom() {
        return Room;
    }

    public void setRoom(Integer room) {
        Room = room;
    }

    public String getStartHour() {
        return StartHour;
    }

    public void setStartHour(String startHour) {
        StartHour = startHour;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "WorkShopDescriptor{" +
                "Description='" + Description + '\'' +
                ", Domain='" + Domain + '\'' +
                ", Room=" + Room +
                ", StartHour='" + StartHour + '\'' +
                ", Time=" + Time +
                '}';
    }

    @Override
    public int compareTo(WorkShopDescriptor o) {
     return StartHour.compareTo(o.getStartHour());
    }
}
