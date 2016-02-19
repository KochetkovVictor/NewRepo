package com.javarush.test.level34.lesson02.home01;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
       // solution.recursion("sin(2*(-5+1.5*4)+28)", 0);
       // solution.recursion("-sin(2*(-5+1.5*4)+28)", 0);
        solution.recursion("tan(45)", 0);

        solution.recursion("(1+2*4+2^4-50)",0);
        //solution.recursion("(sin(2*(-5+1.5*4)+28)+1)+2*cos(24.3+(3*1))+77",0);
        //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        //convert degreese to radians x=gr*pi/180
        int numberOfOperations=0;
        String operationString=expression.replace(" ","");
        for (int i=0; i<operationString.length()-1; i++)
        {
            if(expression.substring(i,i+1).matches("\\+")
                    ||operationString.substring(i,i+1).matches("\\-")
                    ||operationString.substring(i,i+1).matches("\\*")
                    ||operationString.substring(i,i+1).matches("/")
                    ||operationString.substring(i,i+1).matches("\\^")
                    ||operationString.substring(i,i+1).matches("i")
                    ||operationString.substring(i,i+1).matches("a")
                    ||operationString.substring(i,i+1).matches("o"))
            {
                numberOfOperations++;
            }
        }
        String result;
        int count=0;
        if (operationString.substring(0,1).equals("("))
        {
            int start=1;
            int end=0;
            count=1;
            while (count<operationString.length() && start!=end)
            {
                String temp=operationString.substring(count,count+1);
                if (temp.equals("("))
                {
                    start++;
                }
                if (temp.equals(")"))
                {
                    end++;
                }
                count++;
            }
        }
        if (count!=operationString.length() && !operationString.substring(0,1).equals("("))
        {
            //разбиваем выражения на подвыражения
            List<String> symbols=new ArrayList<>();
            for (int i=0; i<operationString.length()-1;)
            {
                String temp=operationString.substring(i,i+1);
                if ("+-*/^".contains(temp))
                {
                    symbols.add(temp);
                    i++;
                }
                if(temp.equals("s") || temp.equals("t") || temp.equals("c"))
                {
                    symbols.add(operationString.substring(i,i+3));
                    i=i+3;
                }
                if (temp.matches("\\d"))
                {
                    int k=i+1;
                    StringBuilder sb=new StringBuilder(temp);
                    while (k<operationString.length()&&(operationString.substring(k,k+1).matches("\\d")||operationString.substring(k,k+1).matches("\\.")))
                    {
                        sb.append(operationString.substring(k,k+1));
                        k++;
                    }
                    i=k;
                    symbols.add(new String(sb));
                }
                if (temp.equals("("))
                {
                    int start=1;
                    int end=0;
                    int k=i+1;
                    while(k<operationString.length() && start!=end)
                    {
                        if (operationString.substring(k,k+1).equals("("))
                        {
                            start++;
                        }
                        if(operationString.substring(k,k+1).equals(")"))
                        {
                            end++;
                        }
                        k++;
                    }
                    PrintStream oldOut=System.out;
                    String recTemp;
                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
                    PrintStream ps=new PrintStream(baos);
                    System.setOut(ps);
                    recursion(operationString.substring(i,k),++countOperation);
                    recTemp=baos.toString();
                    System.setOut(oldOut);
                    symbols.add(recTemp);
                    i=k;
                }
            }

            for (int i=0; i<symbols.size(); i++)
            {
                if (symbols.get(i).startsWith("s"))
                {
                    symbols.set(i,""+Math.sin(Double.parseDouble(symbols.remove(i+1))*Math.PI/180));
                }
                if (symbols.get(i).startsWith("t"))
                {
                    symbols.set(i,""+Math.tan(Double.parseDouble(symbols.remove(i+1))*Math.PI/180));
                }
                if (symbols.get(i).startsWith("c"))
                {
                    symbols.set(i,""+Math.cos(Double.parseDouble(symbols.remove(i+1))*Math.PI/180));
                }
            }
            for (int i=0; i<symbols.size();)
            {
                if (symbols.get(i).equals("^"))
                {
                    symbols.set(i-1, Math.pow(Double.parseDouble(symbols.get(i - 1)), Double.parseDouble(symbols.get(i + 1))) + "");
                    symbols.remove(i);
                    symbols.remove(i);
                    i--;
                }
                i++;
            }
            for (int i=0; i<symbols.size();)
            {
                if (symbols.get(i).equals("/"))
                {
                    symbols.set(i-1, Double.parseDouble(symbols.get(i - 1))/ Double.parseDouble(symbols.get(i + 1)) + "");
                    symbols.remove(i);
                    symbols.remove(i);
                    i--;
                }
                if (symbols.get(i).equals("*"))
                {
                    symbols.set(i-1, Double.parseDouble(symbols.get(i - 1))*Double.parseDouble(symbols.get(i + 1)) + "");
                    symbols.remove(i);
                    symbols.remove(i);
                    i--;
                }
                i++;
            }
            for (int i=0; i<symbols.size(); i++)
            {
                if (symbols.get(i).equals("-"))
                {
                    symbols.set(i,"-"+symbols.remove(i+1));
                }
                if (symbols.get(i).equals("+"))
                {
                    symbols.remove(i);
                    i--;
                }
            }
            double answer=0;
            for (String s:symbols)
            {
                answer=answer+Double.parseDouble(s);
            }
            result=answer+"";
        }
        else
        {
            //отбрасываем начальные и конечные скобки
            operationString=operationString.substring(1,operationString.length()-1);
            PrintStream oldOut=System.out;
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            PrintStream ps=new PrintStream(baos);
            System.setOut(ps);
            recursion(operationString,++countOperation);
            result=baos.toString();
            System.setOut(oldOut);
        }
        if (countOperation==0)
        {
            System.out.println(result+" "+numberOfOperations);
        }
        else
        {
            System.out.println(result);
        }
    }
    public Solution() {
        //don't delete
    }
}
