import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

interface MathProcessing
{
    public void mathFunction(String type, Integer[] data);
}

class  BasicMath implements MathProcessing
{
    public void mathFunction(String type, Integer[] data) 
    {
        switch(type)
        {
            case "add" :
            Integer sum = 0;
            for(Integer i : data )
            {
                sum+=i;
            }
            System.out.println(sum);
            break;

            case "mul" :
            Integer mul = 1;
            for(Integer i : data )
            {
                mul*=i;
            }
            System.out.println(mul);
            break;
            
            default:
            MathProcessing mp = new Math_Adapter();
            mp.mathFunction(type, data);
            
        }
    }
}

//Adaptee
class AdvanceMathProcessing
{
    public int calculateAverage(List <Integer> ls)
    {
        Integer sum =  0;
        for(Integer i : ls)
        {
            sum += i; 
        }
        Integer avg = sum/ls.size();
        return avg;
    }
    public void Sort(List <Integer> ls)
    {
        Collections.sort(ls);
        System.out.print("Sorted");
        for(Integer i : ls)
        {
            System.out.print(i + " ");
        }
    }

    public int searchData(List <Integer> ls, Integer key )
    {
        int index = -1;
        for (int i = 0; i < ls.size(); i++) 
        {
            if (ls.get(i) == key) 
            {
                return i;
            }
        }
        return index;
    }

    public void replaceData(List <Integer> ls, Integer Old, Integer New)
    {
        int index = searchData(ls,Old);
        ls.set(index, New);
    }
}

//Adapter
class Math_Adapter implements MathProcessing
{
    protected AdvanceMathProcessing calculate = new AdvanceMathProcessing();

    public void mathFunction(String type, Integer[] data) 
    {
        List <Integer> ls = Arrays.asList(data);

        switch(type)
        {
            case "average":
            calculate.calculateAverage(Arrays.asList(data));
            System.out.println("The Average = " +  calculate.calculateAverage(ls));    
            break;

            case "sort" :
            calculate.Sort(Arrays.asList(data));
            break;

            case "searchdata" :
            Scanner sc = new Scanner(System.in);
                System.out.print("Enter element to be searched: ");
                Integer elem = sc.nextInt();
                int index = calculate.searchData(Arrays.asList(data), elem);
                System.out.println("Element " + elem + " found at index: " + index);
                break;

            case "replace":
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Enter element to be replaced: ");
                Integer oldElem = sc1.nextInt();
                System.out.print("replace with: ");
                Integer newElem = sc1.nextInt();
                calculate.replaceData(Arrays.asList(data), oldElem, newElem);
                System.out.print("Replaced:");
                for (Integer i : data) 
                {
                    System.out.print(i + " ");
                }
            break;

            default:
                System.out.println(" invalid input " + type );
        }
    }
    
}

class MathAdapterdemo {
    public static void main(String[] args) {
        MathProcessing m = new BasicMath();
        Integer[] data = new Integer[] { 2, 2 , 2 , 2 , 2 };
        m.mathFunction("add", data);
        m.mathFunction("mul", data);
        m.mathFunction("average", data);
        m.mathFunction("sort", data);
        m.mathFunction("search", data);
        m.mathFunction("replace", data);
    }
}