package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1 {
  static final Logger LOG = Logger.getLogger(Lab1.class.getName());
  
  /**
  * 
  *
  * @author George Bush
  */
  public String str;
  
  /**
  * 
  *
  * @author George Bush
  */
  public ArrayList<String[]> list = null;
  
  /**
   * .
   * 
   * @param args
   *          dfd
   * @throws IOException
   *           dfds
   */
  public static void main(String[] args) throws IOException {
    long startTime = System.nanoTime();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    int ttt;
    Lab1 lab = new Lab1();

    do {
      str = br.readLine();
      ttt = lab.expression(str);

    } while (ttt == 1);
    long endTime = System.nanoTime();
    if (LOG.isLoggable(Level.FINE)) {
      LOG.fine("程序运行时间： " + (endTime - startTime) + "ns");
    }
  }

  public Lab1() {
    list = new ArrayList<String[]>();
  }

  /**
   * .
   * 
   * @param xxx
   *          dfd
   * @throws IOException
   *           dfds
   */
  public void derivative(String xxx) {
    final Pattern p6 = Pattern.compile("[\\+\\*]?" + xxx + "[\\+\\*]?");
    Matcher m6;
    String[] add = str.split("\\+");
    int count;
    boolean flag = false;
    for (int i = 0; i < add.length; i++) {
      count = 0;
      m6 = p6.matcher(add[i]);
      while (m6.find()) {
        count++;
      }
      if (count != 0) {
        if (flag == false) {
          flag = true;
        } else {
          LOG.fine("+");
        }
        LOG.fine(add[i].replaceFirst(xxx, String.valueOf(count)));
      }
    }
    LOG.fine("\n");
    ;
  }

  /**
   * .
   * 
   * @param str
   *          dfd
   * @throws IOException
   *           dfds
   */
  public int expression(String str) {
    Pattern pp1 = Pattern.compile("(\\d+|[a-zA-Z]+)([\\+\\*](\\d+|[a-zA-Z]+))*");
    // Pattern p1 =
    Pattern pp2 = Pattern.compile("!simplify((\\s)+[a-zA-Z]*=\\d*)*");
    Pattern pp3 = Pattern.compile("!d/d([a-zA-Z]*)");
    Matcher mm1 = pp1.matcher(str);
    Matcher mm2 = pp2.matcher(str);
    Matcher mm3 = pp3.matcher(str);
    long startTime = 0;
    if (mm1.matches()) {
      this.str = str;
      // System.out.println("True1");
      LOG.fine(str);
      String[] add = str.split("\\+");
      list.clear();
      for (int i = 0; i < add.length; i++) {
        // System.out.println(add[i]);
        list.add(add[i].split("\\*"));
      }
      /*
       * for(int i=0; i < add.length; i++) { for(int j=0; j <
       * list.get(i).length; j++) { System.out.println(list.get(i)[j]); } }
       */
      return 1;
    } else if (mm2.matches()) {
      if (list.isEmpty()) {
        LOG.fine("Error");
        return 0;
      } else {
        startTime = System.nanoTime();
        ArrayList<String> xxx = new ArrayList<String>();
        ArrayList<String> value = new ArrayList<String>();
        Pattern p4 = Pattern.compile("([a-zA-Z]*)=(\\d*)");
        Matcher m4 = p4.matcher(str);
        while (m4.find()) {
          xxx.add(m4.group(1));
          value.add(m4.group(2));
        }
        for (int i = 0; i < list.size(); i++) {
          for (int j = 0; j < list.get(i).length; j++) {
            for (int k = 0; k < xxx.size(); k++) {
              if (xxx.get(k).equals(list.get(i)[j])) {
                list.get(i)[j] = value.get(k);
              }
            }
          }
        }

        simplify(list);
        final long endTime = System.nanoTime();
        if (LOG.isLoggable(Level.FINE)) {
          LOG.fine("求值、化简时间： " + (endTime - startTime) + "ns");
        }
      }
      // System.out.println("True2");
      return 1;
    } else if (mm3.matches()) {
      startTime = System.nanoTime();
      derivative(mm3.group(1));
      long endTime = System.nanoTime();
      if (LOG.isLoggable(Level.FINE)) {
        LOG.fine("求导时间： " + (endTime - startTime) + "ns");
      }
      // System.out.println("True3");
      return 0;
    } else {
      LOG.fine("error");
      return 0;
    }
  }

  /**
   * .
   * 
   * @param list
   *          dfd
   * @throws IOException
   *           dfds
   */
  public void simplify(ArrayList<String[]> list) {
    Pattern p5 = Pattern.compile("[a-zA-Z]*");
    Matcher m5;
    int nnn = 1;
    int sum = 0;
    StringBuffer sb = new StringBuffer();
    StringBuffer strsb = new StringBuffer();

    for (int i = 0; i < list.size(); i++) {
      nnn = 1;
      for (int j = 0; j < list.get(i).length; j++) {
        m5 = p5.matcher(list.get(i)[j]);
        if (m5.matches()) {
          if (sb.length() == 0) {
            sb.append(list.get(i)[j]);
          } else {
            sb.append("*");
            sb.append(list.get(i)[j]);
          }
        } else {
          nnn *= Integer.parseInt(list.get(i)[j]);
        }
      }
      if (sb.length() == 0) {
        sum += nnn;
      } else {
        if (nnn != 1) {
          sb.append("*");
          sb.append(String.valueOf(nnn));
        }
        sb.append("+");
      }
      /*
       * System.out.println(sb.toString()); System.out.println(n);
       * System.out.println(sum);
       */
      strsb.append(sb.toString());
      sb.setLength(0);
    }
    if (sum != 0) {
      strsb.append(String.valueOf(sum));
    } else {
      strsb.deleteCharAt(strsb.length() - 1);
    }
    LOG.fine(strsb.toString());
  }
}
