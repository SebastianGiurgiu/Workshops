package ro.axonsoft.internship.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderStudentDescriptor implements Reader<StudentDescriptor> {


    @Override
    public List<StudentDescriptor> readFile(String filename) throws Exception {
        /**
         * Returnez lista de studenti dintr-un fisier
         */

        File file = new File(filename);
        Scanner scanner=new Scanner(file);

        List<StudentDescriptor> res=new ArrayList<>();

        while(scanner.hasNext()) {

            try {

                String line = scanner.nextLine();
                StudentDescriptor s = readLine(line);
                res.add(s);
            } catch (Exception e) {
                System.out.println("ceva gresit");
            }
        }
        return res;

    }


    @Override
    public StudentDescriptor readLine(String line) throws Exception {
        /**
         * Studentul obitnut dintr-o linie din fisier
         */
        String[] list = line.split(";");
        StudentDescriptor st = new StudentDescriptor(list[0],list[1],list[2]);
            if(list.length!=3)
               for(int i=3;i<list.length;i++)
                   st.AddDomain(list[i]);
        return st;
    }
}
