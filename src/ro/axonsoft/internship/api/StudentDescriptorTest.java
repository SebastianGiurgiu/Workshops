package ro.axonsoft.internship.api;

import static org.junit.Assert.*;

public class StudentDescriptorTest {

    @org.junit.Test
    public void addDomain() {

        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert(st.getDomains().size()==0);
        st.AddDomain("pictura");
        assert(st.getDomains().size()==1);

    }

    @org.junit.Test
    public void getName() {

        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert (st.getName().equals("name"));

    }

    @org.junit.Test
    public void setName() {
        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert (st.getName().equals("name"));
        st.setName("name1");
        assert (st.getName().equals("name1"));
    }

    @org.junit.Test
    public void getStartHour() {
        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert (st.getStartHour().equals("10:00"));

    }

    @org.junit.Test
    public void setStartHour() {
        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert (st.getStartHour().equals("10:00"));
        st.setStartHour("11:00");
        assert (st.getStartHour().equals("11:00"));
    }

    @org.junit.Test
    public void getFinalHour() {
        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert (st.getFinalHour().equals("12:00"));

    }

    @org.junit.Test
    public void setFinalHour() {
        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert (st.getFinalHour().equals("12:00"));
        st.setStartHour("13:00");
        assert (st.getStartHour().equals("13:00"));
    }

    @org.junit.Test
    public void getDomains() {
        StudentDescriptor st=new StudentDescriptor("name","10:00","12:00");
        assert(st.getDomains().size()==0);
    }


}