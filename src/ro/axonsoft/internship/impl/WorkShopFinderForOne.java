package ro.axonsoft.internship.impl;

import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkShopDescriptor;

import java.util.List;

public class WorkShopFinderForOne implements WorkShopFinder {

    List<WorkShopDescriptor> list;

    public WorkShopFinderForOne(List<WorkShopDescriptor> list){
        this.list=list;
    }


    @Override
    public SearchResult getWorkshops(StudentDescriptor studentDescriptor) {
        //return null;

        return new SearchResultForOne(studentDescriptor,list);

    }
}
