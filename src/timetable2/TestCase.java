package timetable2;

import com.softtechdesign.ga.Crossover;
import com.softtechdesign.ga.GAException;
import com.softtechdesign.ga.GAString;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;

public class TestCase extends GAString {
int itr = 0;
int flag[];

public String getSub(String tmp,int room)
   {               
        String tchr = "",rum = "",rum1="";
        String teacher = "",course = "",clas="";        
        
        if(tmp.equals("a")){tchr="T01";}
        else if(tmp.equals("b")){tchr="T02";}
        else if(tmp.equals("c")){tchr="T03";}
        else if(tmp.equals("d")){tchr="T04";}
        else if(tmp.equals("e")){tchr="T05";}
        else if(tmp.equals("f")){tchr="T06";}
        else if(tmp.equals("g")){tchr="T07";}
        else if(tmp.equals("h")){tchr="T08";}
        else if(tmp.equals("i")){tchr="T09";}
        else if(tmp.equals("j")){tchr="T10";}
        else if(tmp.equals("k")){tchr="T11";}
        else if(tmp.equals("l")){tchr="T12";}
        else if(tmp.equals("m")){tchr="T13";}
        else if(tmp.equals("n")){tchr="T14";}
        else if(tmp.equals("o")){tchr="T15";}
        
        if(room==0){rum="R01";}
        else if(room==1){rum="R02";}
        else if(room==2){rum="R03";}
        else if(room==3){rum="R04";}
        else if(room==4){rum="R05";}
        else if(room==5){rum="R06";}
        else if(room==6){rum="R07";}
        else if(room==7){rum="R08";}
        else if(room==8){rum="R09";}
        else if(room==9){rum="R10";}
        else if(room==10){rum="R11";}
        else if(room==11){rum="R12";}
        else if(room==12){rum="R13";}
        else if(room==13){rum="R14";}
        else if(room==14){rum="R15";}
        
        for(int i=0; i < Module.classS.size(); i++)
        {
            ClassS cs = Module.classS.elementAt(i);            
            if(cs.teacher.trim().equals(tchr))                
            {                               
                teacher = cs.teacher.toString();
                course = cs.course.toString();
                rum1 = cs.room.toString();
                clas = cs.cls.toString(); 
                                            
                return  "["+teacher+":"+course+":"+rum1+":"+clas+"]";               
            }
        }
        return  "[                   ]";               
        
    }
/*
public String getRoom(String tmp,int room)
   {               
      String tchr = "",rum = "";        
        
      for(int l=01;l<=15;l++)
      {
          if(tmp.equals("a"))
          {
              tchr = "T"+l;
          }
      }
             if(tmp.equals("a")){tchr="T01";}
        else if(tmp.equals("b")){tchr="T02";}
        else if(tmp.equals("c")){tchr="T03";}
        else if(tmp.equals("d")){tchr="T04";}
        else if(tmp.equals("e")){tchr="T05";}
        else if(tmp.equals("f")){tchr="T06";}
        else if(tmp.equals("g")){tchr="T07";}
        else if(tmp.equals("h")){tchr="T08";}
        else if(tmp.equals("i")){tchr="T09";}
        else if(tmp.equals("j")){tchr="T10";}
        else if(tmp.equals("k")){tchr="T11";}
        else if(tmp.equals("l")){tchr="T12";}
        else if(tmp.equals("m")){tchr="T13";}
        else if(tmp.equals("n")){tchr="T14";}
        else if(tmp.equals("o")){tchr="T15";}
          
             if(room==0){rum="R01";}
        else if(room==1){rum="R02";}
        else if(room==2){rum="R03";}
        else if(room==3){rum="R04";}
        else if(room==4){rum="R05";}
        else if(room==5){rum="R06";}
        else if(room==6){rum="R07";}
        else if(room==7){rum="R08";}
        else if(room==8){rum="R09";}
        else if(room==9){rum="R10";}
        else if(room==10){rum="R11";}
        else if(room==11){rum="R12";}
        else if(room==12){rum="R13";}
        else if(room==13){rum="R14";}
        else if(room==14){rum="R15";}
        
        for(int i=0; i < Module.classS.size(); i++)
        {
            ClassS cs = Module.classS.elementAt(i);            
            if(cs.teacher.trim().equals(tchr) && cs.room.trim().equals(rum))                
            {                                                                        
                return  "Y";               
            }
        }
        return  "N";                     
        
    }
  */          
        
    

    /* given the chromosome identified by iChromIndex, calculate and return its fitness */
    protected double getFitness(int iChromIndex) 
    {        
        float fitness = 0;
        float fit = 0;
        int t01=0,t02=0,t03=0,t04=0,t05=0,t06=0,t07=0,t08=0,t09=0,t10=0,t11=0,t12=0,t13=0,t14=0,t15=0;                  
        
        try
        {            
                String s = this.getChromosome(iChromIndex).getGenesAsStr();
                                                
                //System.out.println(s + " " + s.length());

                String toCheck[][] = new String[days][hours];
                for (int j = 0; j < hours; j++) 
                {
                    for (int k = 0; k < days; k++) 
                    {
                        toCheck[k][j] = " ";
                    }
                }

                String arr[][][] = new String[days][hours][rooms];
                int f1[][][] = new int[days][hours][rooms];
                int f2[][][] = new int[days][hours][rooms];
                int f3[][][] = new int[days][hours][rooms];
                String rum = "";
                
                //String array[] = new String[450];
                //String array2[] = new String[450];
                
                int cnt = 0, i = 0;
                String a[] = {"MONDAY", "TUESDAY", "WEDNSDAY", "THURSDAY", "FRIDAY", "SATURDAY","\n"};
                String h[] = {" 9-10", "10-11", "11-12", "12- 1", " 1- 2", " 2- 3"};       
                //System.out.println();
                        
                for(int o=1;o<=15;o++)
                {
                    if(i==o)
                    {
                        rum= "R"+o;
                    }
                }
                /*if(i==0){rum="R01";}
                else if(i== 1){rum="R02";}
                else if(i== 2){rum="R03";}
                else if(i== 3){rum="R04";}
                else if(i== 4){rum="R05";}
                else if(i== 5){rum="R06";}
                else if(i== 6){rum="R07";}
                else if(i== 7){rum="R08";}
                else if(i== 8){rum="R09";}
                else if(i== 9){rum="R10";}
                else if(i==10){rum="R11";}
                else if(i==11){rum="R12";}
                else if(i==12){rum="R13";}
                else if(i==13){rum="R14";}
                else if(i==14){rum="R15";}*/
                

                int y = 0;
                int r = 0;
                for (i = 0; i < rooms; i++) 
                {
                    for (int j = 0; j < hours; j++) 
                    {
                       // System.out.print(h[j] + " ");                        
                        for (int k = 0; k < days; k++) 
                        {                                                                                            
                                arr[k][j][i] = s.charAt(cnt++) + "";     
                                //System.out.print(arr[k][j][i] + " ");                                                                                 
                                
                                // CLASH FOR SAME SLOT FOR SAME TIME
                                
                                for(int aa=1;aa<rooms;aa++)
                                {                                    
                                    if(i>aa)
                                    { 
                                        if(arr[k][j][i].equalsIgnoreCase(arr[k][j][i-aa]))
                                        { 
                                            //System.out.print("w..");
                                            //fitness = fitness - 1;
                                            f1[k][j][i]=0;
                                        }
                                        else 
                                        { 
                                            f1[k][j][i]=1;
                                            //System.out.print("O..");            
                                        }   
                                    }
                                }
                                
                                // CLASH FOR REPEATED ENTRY
                                
                                for(int aa=1;aa<rooms;aa++)
                                {            
                                    for(int b=1;b<hours;b++)
                                    {
                                        for(int c=1;c<days;c++)
                                        {
                                            if(k>c)
                                            {
                                                if(j>b)
                                                {
                                                    if(i>aa)
                                                    { 
                                                        if(arr[k][j][i].equalsIgnoreCase(arr[k-c][j-b][i-aa]))
                                                        { 
                                                            //System.out.print("#");
                                                            //fitness = fitness - 1;
                                                            f2[k][j][i]= 0;
                                                        }
                                                        else 
                                                        { 
                                                            //System.out.print("O..");                                                                           
                                                            f2[k][j][i]= 1;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                
                                if(cycle>4000)
                                {
                                    this.crossoverType = Crossover.ctOnePoint;
                                }
                                else
                                {
                                    this.crossoverType = Crossover.ctRoulette;
                                }
                                
                                String tmp = arr[k][j][i];
                                String rvalue = getSub(tmp,i);
                               // String rms = getRoom(tmp,i);                                                                                                                                           
                                                                
                                
                                
                                // clash for room
                               /* if(rms.equalsIgnoreCase("Y"))
                                {
                                    fitness = fitness + 1;
                                }
                                else if(rms.equalsIgnoreCase("N"))
                                {
                                    fitness = fitness - 1;
                                }
                                */
                                
                                int tt[] = new int[16];
                                
                                //constraint for teaching capacity
                                for(int o=1;o<=15;o++)
                                {
                                    if(rvalue.contains("T"+o))
                                    {
                                        tt[o]++;
                                    }
                                }
                                
                                for(int o=1;o<=15;o++)
                                {
                                    if(tt[o]>=30)
                                    {
                                        f3[k][j][i]=0;
                                    }
                                    else
                                    {
                                        f3[k][j][i]=1;
                                    }
                                }
                                
                                /*
                                     if(rvalue.contains("T01")){t01++;}
                                else if(rvalue.contains("T02")){t02++;}
                                else if(rvalue.contains("T03")){t03++;}
                                else if(rvalue.contains("T04")){t04++;}
                                else if(rvalue.contains("T05")){t05++;}
                                else if(rvalue.contains("T06")){t06++;}
                                else if(rvalue.contains("T07")){t07++;}
                                else if(rvalue.contains("T08")){t08++;}
                                else if(rvalue.contains("T09")){t09++;}
                                else if(rvalue.contains("T10")){t10++;}
                                else if(rvalue.contains("T11")){t11++;}
                                else if(rvalue.contains("T12")){t12++;}
                                else if(rvalue.contains("T13")){t13++;}
                                else if(rvalue.contains("T14")){t14++;}
                                else if(rvalue.contains("T15")){t15++;}
                                
                                if( t01>=30 ){f3[k][j][i]=0;}
                                else if( t02>=30 ){f3[k][j][i]=0;}
                                else if( t03>=30 ){f3[k][j][i]=0;}
                                else if( t04>=30 ){f3[k][j][i]=0;}
                                else if( t05>=30 ){f3[k][j][i]=0;}
                                else if( t06>=30 ){f3[k][j][i]=0;}
                                else if( t07>=30 ){f3[k][j][i]=0;}
                                else if( t08>=30 ){f3[k][j][i]=0;}
                                else if( t09>=30 ){f3[k][j][i]=0;}
                                else if( t10>=30 ){f3[k][j][i]=0;}
                                else if( t11>=30 ){f3[k][j][i]=0;}
                                else if( t12>=30 ){f3[k][j][i]=0;}
                                else if( t13>=30 ){f3[k][j][i]=0;}
                                else if( t14>=30 ){f3[k][j][i]=0;}
                                else if( t15>=30 ){f3[k][j][i]=0;}                                
                                else{f3[k][j][i]=1;}
                                */
                                /*
                                if (toCheck[k][j].equals(arr[k][j][i])) 
                                {
                                    //System.out.println();
                                    fitness = fitness - 1;
                                    itr=itr+1;
                                } 
                                else 
                                {
                                        toCheck[k][j] = arr[k][j][i];
                                        fitness = fitness + 1; 
                                        itr=itr+1;
                                }*/
                            
                        }
                          //System.out.println();
                    }
                    //System.out.println();                    
                }                
                                              
                for(int aa=0;aa<rooms;aa++)
                {            
                    for(int b=0;b<hours;b++)
                    {
                        for(int c=0;c<days;c++)
                        {
                           fit = fit + f1[c][b][aa] + f2[c][b][aa] + f3[c][b][aa];
                        }
                    }
                }          
                
                fitness = fit/1350;
                
                System.out.println("Fitness:"+fitness);
                
                Module.jta.setText("");
                Module.jl.setText("Fiteness: ["+fitness + "]");
           
          do{               
              /*  
                if (fit>900)
                {
                    ClassS.stop = true;
                }
               else      */
                {
                    int y1 = 0;                    
                    Module.jta.append("Fitness: " + fitness + LineSeparator.Windows);
                    Module.jta.append("      ");
                    for (int j = 0; j < days; j++) {
                        Module.jta.append(a[j] + " ");                                                
                    }
                    Module.jta.append(LineSeparator.Windows);
                    for (i = 0; i < rooms; i++) 
                    {
                        for (int j = 0; j < hours; j++) 
                        {
                            Module.jta.append(h[j] + " ");

                            for (int k = 0; k < days; k++) 
                            {
                                String tmp = arr[k][j][i];
                                String rvalue = getSub(tmp,i);
                                
                                Module.jta.append(rvalue);
                                //Module.jta.append(arr[k][j][i] + " ");
                 
                            }
                            Module.jta.append(LineSeparator.Windows);
                        }
                        Module.jta.append(LineSeparator.Windows);
                    }
                    Module.jta.append(LineSeparator.Windows);                              
                    //System.out.println(" RIT:"+t1+" WRG:"+t2+"");
                }                                
          }while(fitness>=1);                                          
          
        }
        catch(Exception e)
        {
            System.out.print("Error: "+e);
        }
        //HERE1:
        return (fitness);
    }

    // 7* room * population
    public TestCase(int chro, int pop, int n, String chromSamples) throws GAException {

        super(chro, //chromosome has 20 chars
                pop, //population of N chromosomes
                0.8, //crossover probability (0.7 = 70%)
                50, //random selection chance % (regardless of fitness)
                n, //stop after N generations
                0, //num prelim runs
                0, //max prelim generations
                0.01, //chromosome mutation prob.
                0, //number of decimal places in chrom (0 means treat chrom as integer)
                chromSamples, //gene space (possible gene values '0' or '1')
                Crossover.ctOnePoint,//ctRoulette, //crossover type
                true); //compute statistics?
    }
    static int days = 5;
    static int hours = 6;
    static int rooms = 15;
    static int population = 50;
    static int cycle = 10000;

    //public static void main(String[] args) {
    public static void exe() 
    {
        try 
        {
            String tmp = "";           
            for (int i = 0; i < 15; i++) 
            {
                tmp += ((char) (97 + i)) + "";
            }            
                    
            TestCase tc = new TestCase(days * hours * rooms, population, cycle, tmp);
            tc.evolve();
        
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex);
        }
    }
}