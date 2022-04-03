package xml.rpc.app;

import javax.xml.soap.Text;

public class MyData {
    public static String info(){
        String info= "|a) Show                                       " +
                "    |\n|b) Primes                           " +
                "              |\n|c) Distance          " +
                "                             |\n|d) Add            " +
                "                                |\n|e) Minus                                          |";
        return info;
    }
    public static String show(){

        String show = "                    ******* Available Functions' Description *******                        \n| a) show() - returns information about available procedures (procedure name, parameters, short " +
                "\n|      description).\n" +
                "\n| b) primes(..) - returns the number of primes in the given range [min, max] and the largest prime " +
                "\n|      less than or equal to max.\n" +
                "\n| c) distance(..) - returns the distance between two points on the Earth's surface. The parameters of " +
                "\n|      this method are the geographical coordinates of both points.\n" +
                "|      To calculate the distance, use/implement the haversine function (or another one that gives" +
                "\n|      better accuracy).\n" +
                "\n| d) add(..) - Will return Addtion of two numbers recursively" +
                "\n| e) minus(..)  - Will return Minus of two numbers";

        return show;
    }
}
