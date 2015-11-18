/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable2;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class Module {

    public static JTextArea jta = null;
    public static JTable jtab = null;
    public static JLabel jl = null;
    
    public static Vector<Prof> professor = new Vector<Prof>();
    public static Vector<Course> course = new Vector<Course>();
    public static Vector<CLS> cls = new Vector<CLS>();
    public static Vector<room> room = new Vector<room>();
    public static Vector<Group> group = new Vector<Group>();
    public static Vector<ClassS> classS = new Vector<ClassS>();    
}
