package model;

import java.util.ArrayList;
import java.util.List;

public class SummerFlounder extends Animal{

        public SummerFlounder(int xPos, int yPos){

            super("SummerFlounder",xPos, yPos, 4,1, 300, 550, 0 ,850);
        }

        public static Animals createSFList(){
            SummerFlounder sf1 = new SummerFlounder(600,350);
            SummerFlounder sf2 = new SummerFlounder(200,450);
            SummerFlounder sf3 = new SummerFlounder(100,500);

            List<Animal> sfList = new ArrayList<>();
            sfList.add(sf1);
            sfList.add(sf2);
            sfList.add(sf3);
            return new Animals("SummerFlounder",sfList);
        }

        public static Animals createSingleSFList(){
            SummerFlounder sf = new SummerFlounder(480, 550);
            sf.setxInc(0);
            sf.setyInc(0);
            List<Animal> sfList = new ArrayList<>();
            //sfList.add(sf);
            return new Animals("SummerFlounder", sfList);
        }

}
