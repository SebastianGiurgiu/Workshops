package ro.axonsoft.internship.api;

import java.util.ArrayList;
import java.util.List;

public class StudentDescriptor implements Descriptor {

    private String Name;
    private String StartHour;
    private String FinalHour;
    private List<String> Domains=new ArrayList<>();


    public StudentDescriptor(String name, String startHour, String finalHour) {
        this.Name = name;
        this.StartHour = startHour;
        this.FinalHour = finalHour;
    }

    public void AddDomain(String Domain){
        this.Domains.add(Domain);

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartHour() {
        return StartHour;
    }

    public void setStartHour(String startHour) {
        StartHour = startHour;
    }

    public String getFinalHour() {
        return FinalHour;
    }

    public void setFinalHour(String finalHour) {
        FinalHour = finalHour;
    }

    public List<String> getDomains() {
        return Domains;
    }


    @Override
    public String toString() {
        return "StudentDescriptor{" +
                "Name='" + Name + '\'' +
                ", StartHour='" + StartHour + '\'' +
                ", FinalHour='" + FinalHour + '\'' +
                ", Domains=" + Domains +
                '}';
    }
}
