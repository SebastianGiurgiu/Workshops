package ro.axonsoft.internship.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkShopDescriptorTest {

    @Test
    public void getDescription() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getDescription().equals("descriere"));
    }

    @Test
    public void setDescription() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getDescription().equals("descriere"));
        w.setDescription("desc");
        assert (w.getDescription().equals("desc"));
    }

    @Test
    public void getDomain() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getDomain().equals("pictura"));
    }

    @Test
    public void setDomain() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getDomain().equals("pictura"));
        w.setDomain("muzica");
        assert (w.getDomain().equals("muzica"));

    }

    @Test
    public void getRoom() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getRoom()==10);
    }

    @Test
    public void setRoom() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getRoom()==10);
        w.setRoom(20);
        assert (w.getRoom()==20);
    }

    @Test
    public void getStartHour() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getStartHour().equals("10:00"));

    }

    @Test
    public void setStartHour() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getStartHour().equals("10:00"));
        w.setStartHour("11:00");
        assert (w.getStartHour().equals("11:00"));
    }

    @Test
    public void getTime() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getTime()==25);

    }

    @Test
    public void setTime() {
        WorkShopDescriptor w=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w.getTime()==25);
        w.setTime(100);
        assert (w.getTime()==100);
    }

    @Test
    public void compareTo() {
        WorkShopDescriptor w1=new WorkShopDescriptor("descriere","pictura",10,"09:00",25);
        WorkShopDescriptor w2=new WorkShopDescriptor("descriere","pictura",10,"10:00",25);
        assert (w1.compareTo(w2)<0);
        assert (w2.compareTo(w1)>0);
        w1.setStartHour("10:00");
        assert (w1.compareTo(w2)==0);

    }
}