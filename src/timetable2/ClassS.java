/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable2;

import java.util.Vector;

/**
 *
 * @author Admin
 */
public class ClassS 
{
    String teacher;
    String course;
    String room;
    String cls;    
  
    public static boolean stop = false;  
    
    public String toString()
    {
        String val = "Professor: " + teacher + " Course: " + course + " Room: " + room + " Class: " + cls;                
        return val;
    }
}
