import java.util.*;

public class Salesman
{   
    String name; 
    float sales;
    
    Salesman[] temp = new Salesman[5];
    float[] extraTemp = new float[1];
    int startingTempNum = 0;
    float maxNumber = 0; 
    
    Salesman[] getTopFive(Salesman[] allSales)
    {
        for (int i = 0; i < allSales.length-1; i++)
        {   
            if (allSales[i].sales > maxNumber)
            {
                if (startingTempNum == 5)
                {
                    return temp;
                }
                else if (startingTempNum >= 1)
                {
                    if (allSales[i].sales > allSales[i-1].sales)
                    {
                        extraTemp[0] = allSales[i-1].sales;
                        allSales[i-1].sales = allSales[i].sales;
                        allSales[i].sales = extraTemp[0];
                        startingTempNum++;
                    }
                }
                else if (startingTempNum == 0)
                {
                    temp[startingTempNum] = allSales[i];
                    startingTempNum++;
                }
            }

            maxNumber = allSales[i].sales;
        }
        
        return temp;
    }
}

