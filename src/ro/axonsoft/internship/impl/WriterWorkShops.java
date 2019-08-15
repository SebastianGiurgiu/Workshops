package ro.axonsoft.internship.impl;

import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkShopDescriptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterWorkShops implements Writer {


    @Override
    public void writeResult(List<SearchResult> results) throws IOException {
    /**
    *  Functie de scrierea a rezultatului in fisiere consform cerintei
    */
        for(int j=0;j<results.size();j++){

            SearchResult searchResult=results.get(j);                         // pentru fiecare result trebuie sa scriu intr-un fisier
            List<WorkShopDescriptor> list = searchResult.getWorkshops();     // list3 - lista de workshop-uri

            String NumeStudent = searchResult.getStudentName();
            BufferedWriter output = null;

            try {
                //String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"pankaj"+fileSeparator+"file.txt";
                //File file = new File(NumeStudent);                                // creare fisier cu numele studentului
                File file = new File("C:\\Users\\Sebastian\\Desktop\\AxonSoft\\src\\ro\\axonsoft\\internship\\"+NumeStudent);
                output = new BufferedWriter(new FileWriter(file));

                for(int i=0;i<list.size();i++)
                    output.write(String.valueOf(list.get(i))+"\n");    // scrierea unui workshop si trecerea pe linia urmatoare
            } catch ( IOException e ) {
                e.printStackTrace();
            } finally {
                if ( output != null ) {
                    output.close();
                }
            }
        }
    }
}
