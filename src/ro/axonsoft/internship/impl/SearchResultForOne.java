package ro.axonsoft.internship.impl;


import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkShopDescriptor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;


public class SearchResultForOne implements SearchResult {

    static List<WorkShopDescriptor> rezultat=new ArrayList<>();          // variabile statice de care ma folosesc ca sa retin rezultate
    static int max=-1;                                                   // in urma aplicarii backtracking-ului


    static void powerSet(String str, int index,
                         String curr,List<WorkShopDescriptor> list)
    /**
     * Functie de bakctracking care imi genereaza toate submultimele posbisbile dintr-o lista de workshopuri
     * param: str - string de indici , acesta reprezinta indicii elementelor din lista cu care lucrez
     * param: index - pentru a putea accesa un element dintr-o submultime
     * param: curr - stringul curent de la fiecare operatie
     * param : list - lista de workshopuri in care caut submultimi
     */

    {                                                          // folosesc un algoritm de bakctracking pentru a generare toate
        int n = str.length();                                   // solutiile valide

        if (index == n)
        {
            String[] sir = curr.split(";");

            for(int i =0 ; i < sir.length;i++)

                if(curr!="") {
                    List<WorkShopDescriptor> res = Generate(list, sir);    // res - o lista generare
                    if (ValidList(res) > 0) {                              // verific daca lista generate este valida

                        if(ValidList(res)>max) {                       // salvez lista cu cele mai multe targuri
                            max=ValidList(res);
                            rezultat=res;
                        }
                    }
                }
            return;
        }

        powerSet(str, index + 1, curr + str.charAt(index)+";",list);
        powerSet(str, index + 1, curr,list);

    }


    public static List<WorkShopDescriptor> Generate(List<WorkShopDescriptor> list , String[] indici){
        /**
         * Lista de worksop-uri in care caut elemente
         * indici - string de indici care reprezinta elementele alese din lista
        */
        List<WorkShopDescriptor> res=new ArrayList<>();

        for (int i=0;i<indici.length;i++){                             // Generez lista formata din membrii ce au anumiti indici
            int index=Integer.valueOf(indici[i]);
            res.add(list.get(index));
        }

        return res;

    }


    public static int ValidList(List<WorkShopDescriptor> workshoplist){
        /**
         * Functie care imi returneaza -1 daca lista generata NU e VALIDA
         * Functia imi returneaza numarul de elemente din lista daca e VALIDA
         */

        int i=0;

        while (i<workshoplist.size()-1){                              // verific tot cate 2 targuri consecutive daca sunt valide

            WorkShopDescriptor w1=workshoplist.get(i);                       //verific daca studentul poate sa participe la cele 2 targuri
            WorkShopDescriptor w2=workshoplist.get(i+1);                     // care sunt unul dupa celalalt

            String timeWorkShopStart=w1.getStartHour();
            LocalTime l1 = LocalTime.parse(timeWorkShopStart);               // ora la care incepe primul targ

            String timeWorkShopFinal;

            if(w1.getRoom()!=w2.getRoom())
                timeWorkShopFinal= l1.plusMinutes(w1.getTime()+10).toString();    // daca urmatorul targ e in alta sala adaug 10 minute
            else
                timeWorkShopFinal= l1.plusMinutes(w1.getTime()).toString();

            LocalTime l2 = LocalTime.parse(timeWorkShopFinal);
            LocalTime l3 = LocalTime.parse(w2.getStartHour());

            long difference=l2.until(l3, MINUTES);                    // determin numarul de minute de la terminarea primului targ
                                                                      // pana la inceperea urmatorului
            if(difference<0)                                           // studentul nu poate ajunge la urmatorul targ
                return -1;                                             // returnez faptul ca lista nu e valida
            i++;
        }
        return ++i;                                              // returnez numarul de targuri la care a putut participa
    }


    public static List<WorkShopDescriptor> GenerateValidWorkShops(List<WorkShopDescriptor> list,StudentDescriptor st){
        /**
         * Functie care returneaza lista workshop-urilor un student ar putea ajunge deoarece e un interval de ore ok
         * list - Lista de workshop-uri in care caut
         * st - Studentul pentru care caut workshop-uri
        */

        List<WorkShopDescriptor> rez=new ArrayList<>();          // rez - lista rezultata obtinuta
        List<String> lista_acitivati=new ArrayList<>();

        if(st.getDomains().size()!=0) {
            lista_acitivati = st.getDomains();
        }
        else {
            lista_acitivati.add("pictura");                        // acopar cazul in care un student poate participa la toate targurile
            lista_acitivati.add("muzica");
            lista_acitivati.add("lectura");
            lista_acitivati.add("natura");
        }

        for (int i=0;i<list.size();i++){

            if( lista_acitivati.contains(list.get(i).getDomain())) {

                WorkShopDescriptor w = list.get(i);                            /// Verific daca targurile incep de la o ora la care poate
                String timeStudentStart = st.getStartHour();                    // participa studentul
                String timeWorkshopStart = w.getStartHour();

                LocalTime l1 = LocalTime.parse(timeStudentStart);            // l1 - ora cand studentul poate sa inceapa sa mearga la targ
                LocalTime l2 = LocalTime.parse(timeWorkshopStart);           // l2 - ora cand incepe targul

                String timeStudentFinal= st.getFinalHour();                          //verific daca targurile se termina inainte de ora finala
                String timeWorkShopFinal= l2.plusMinutes(w.getTime()).toString();    // a studentului (sau deodata)

                LocalTime l3=LocalTime.parse(timeStudentFinal);                    // l3 - ora la care studentul nu mai poate sta la vreun targ
                LocalTime l4=LocalTime.parse(timeWorkShopFinal);                   // l4 - ora la care se termina targul

                long difference2=l4.until(l3,MINUTES);
                long difference=l1.until(l2, MINUTES);


                if(difference>=0 && difference2>=0) {
                    rez.add(list.get(i));
                }
            }
        }

        Collections.sort(rez);               //Sortez tot timpul pentru a fii targurile in ordine
        return rez;


    }



    public static List<WorkShopDescriptor> RezolvareForOne(StudentDescriptor st,List<WorkShopDescriptor> list){
        /**
         * Functie care returneaza cea mai lunga lista de workshop-uri la care paote participa un student
         * st - Studentul pentru care returnez lista
         * list - lista tuturor workshop-urilor
         */
        rezultat=new ArrayList<>();                                         // trebuie sa resetez valorile deoarece sunt statice si se pastreaza
        max=-1;                                                             // valorile de dinainte

        List<WorkShopDescriptor> posbile = GenerateValidWorkShops(list, st);    // lista cu workshop-uri posbile la care ar putea ajung

        int lung = posbile.size();
        String sirr = "";
        for (int i = 0; i < lung; i++)                                // generea indicilor listei posbilie
            sirr += String.valueOf(i);

        powerSet(sirr, 0, "", posbile);                  // cautarea listei ce contine cele mai multe workshop-uri

        return rezultat;
    }



    StudentDescriptor st;
    List<WorkShopDescriptor> list;

    public SearchResultForOne(StudentDescriptor st, List<WorkShopDescriptor> list){
        /**
         * st - Studentul pentru care caut workshop-uri
         * list - Lista de workshop-uri in care caut
         */
        this.st=st;
        this.list=list;

    }

    @Override
    public String getStudentName() {
        return st.getName();
    }

    @Override
    public List<WorkShopDescriptor> getWorkshops() {

        return RezolvareForOne(st,list);

    }
}
