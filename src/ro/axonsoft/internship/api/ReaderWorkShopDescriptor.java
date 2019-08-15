package ro.axonsoft.internship.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderWorkShopDescriptor implements Reader<WorkShopDescriptor> {
    @Override
    public List<WorkShopDescriptor> readFile(String filename) throws ReaderException, FileNotFoundException {
        /**
        * Lista de targuri obtinute dintr-un fisier
        */
        File file = new File(filename);
        Scanner scanner=new Scanner(file);
        List<WorkShopDescriptor> res=new ArrayList<>();

        while(scanner.hasNext()) {

            try {
                String line = scanner.nextLine();
                WorkShopDescriptor w=readLine(line);
                res.add(w);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        return res;
    }

    @Override
    public WorkShopDescriptor readLine(String line) throws ReaderException {
        /**
        * Un targ obitinut dintr-o linie dintr-un fiser
        */
        String[] list = line.split(";|\\,");                          // dublu delimitator
        WorkShopDescriptor wk=new WorkShopDescriptor(list[0],list[1],Integer.valueOf(list[2]),list[3],Integer.valueOf(list[4]));
        return wk;

    }
}
