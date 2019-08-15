package ro.axonsoft.internship.main;

import ro.axonsoft.internship.api.ReaderStudentDescriptor;
import ro.axonsoft.internship.api.ReaderWorkShopDescriptor;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkShopDescriptor;
import ro.axonsoft.internship.impl.*;
import java.util.*;

public class Main {

    public static void main(String[] arg) throws Exception {

        ReaderStudentDescriptor readerStudentDescriptor = new ReaderStudentDescriptor();
        List<StudentDescriptor> StudentList = readerStudentDescriptor.readFile("C:\\Users\\Sebastian\\Desktop\\AxonSoft\\src\\ro\\axonsoft\\internship\\api\\students.csv");

        ReaderWorkShopDescriptor r = new ReaderWorkShopDescriptor();
        List<WorkShopDescriptor> WorkShopList = r.readFile("C:\\Users\\Sebastian\\Desktop\\AxonSoft\\src\\ro\\axonsoft\\internship\\api\\whorkshops.csv");

        List<SearchResult> results = new ArrayList<>();


        for (StudentDescriptor s: StudentList) {                        // parcugerea fiecarui student

            StudentDescriptor st = s;
            WorkShopFinderForOne workShopFinderForOne = new WorkShopFinderForOne(WorkShopList);    // caut in lista de workshop-uri
            SearchResult searchResult = workShopFinderForOne.getWorkshops(st);                     // caut workshop-uri pentru un student

            results.add(searchResult);
        }


        Writer writer=new WriterWorkShops();                       // scriu rezultatul pentru fiecare Student
        writer.writeResult(results);


    }
}



