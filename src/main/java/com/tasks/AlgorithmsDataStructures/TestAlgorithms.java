package com.tasks.AlgorithmsDataStructures;

class TestAlgorithms
{
    // Using continue with a label
    public static void main(String args[]) {
        outer: for (int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                 if(j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
        System.out.println();
    }
}

/* public static void main(String[] args)
    {
        one: for(int i=0; i<10; i++){
            System.out.println(i + " ");
            if(i%2==0)
                continue;
            System.out.println("");
        }
    }*/
// Using break to execute from nested loops
   /* public static void main(String[] args)
    {
        outer: for(int i=0;i<3;i++){
            System.out.println("Pass " + i + ": ");
            for(int j=0; j<100; j++) {
                if(j == 10)
                    break outer; // exit from loops
                System.out.println(j + " ");
            }
            System.out.println("This will not print");
        }
        System.out.println("Loops complete");
    }*/

   /* public static void main(String[] args)
    {
        boolean t = true;
        first:{
            second:
            {
                third:
                {
                    System.out.println("Before the break");
                    if(t)
                        break second;
                }
                System.out.println("This won't execute");
            }
            System.out.println("This is after second block.");
        }
    }*/


   /* public static void main(String[] args)
    {
        int sum = 0;
        int nums[][] = new int[3][5];
        // give nums some values
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 5; j++)
                nums[i][j] = (i + 1) * (j + 1);
        // use for-each for to display and sum the values
        for(int x[] : nums)
        {
            for(int y : x)
            {
                System.out.println("Value is: " + y);
                sum += y;
            }
        }
        System.out.println("Summation: " + sum);
    }*/









      /*  *//**
         * Пример № 1
         * Нахождение максимального и минимального значений
         *//*
        ArrayList<Integer> testValues = new ArrayList();
        testValues.add(0,15);
        testValues.add(1,1);
        testValues.add(2,2);
        testValues.add(3,100);
        testValues.add(4,50);

        Optional<Integer> maxValue = testValues.stream().max(Integer::compareTo);
        System.out.println("MaxValue="+maxValue);
        Optional<Integer> minValue = testValues.stream().min(Integer::compareTo);
        System.out.println("MinValue="+minValue);
*/


    /*HashMap<String,String[]> instruments = new HashMap<String, String[]>() {
        {
            put("EURUSD", new String[]{"4001","EURUSD","10000","0.00001","0.1","USD"});
            put("EUR", new String[]{"4001","EURUSD","10000","0.00001","0.1","USD"});
        }
    };*/
      /*  // A simple example of the switch.
                for(int i=0; i<6; i++)
                    switch(i) {
                        case 0:
                            System.out.println("i is zero.");
                            break;
                        case 1:
                            System.out.println("i is one.");
                            break;
                        case 2:
                            System.out.println("i is two.");
                            break;
                        case 3:
                            System.out.println("i is three.");
                            break;
                        default:
                            System.out.println("i is greater than 3.");
                    }
            }
        }*/
        /*int a[] = {2, 6, 3, 4};
        for (int i = 1; i<4; i++){
            a[0] += a[i]+1;
        }
        System.out.println(a[0]);*/

      /*  int value = Integer.parseInt("10.2");
        System.out.println(value);*/
       /* double a = 295.04;
        int b = 300;
        double c = (b - a);//4.94
        c += a;//4.94+295.04=300
        System.out.println((c-b) == (b-c));*/
       /* String y = "123asdfghj@gmail.com";
        if(y.substring(y.length()-5)
                .equals(".com")){
            System.out.println(y.substring(1));
        }
        else
            System.out.println(y.length());*/
       /* int[] n = {0, 1, 0, -1};
        for(int i = 1; i < n.length; i++)
            if(n[i] == 0 && n[i-1]!=0){
                int x = n[i-1];
                n[i-1]=n[i];
                n[i]=x;
            }
        System.out.println(n[2]);*/
       /* LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();
        String value = it.next();
        System.out.println(value);*/

        /*for(int i=0; i<10; i++)
            if(i%2==1)
               if(i%2==0)
                System.out.println(i);

*/
        /*int x = 42;
        double y = 42.25;
        System.out.println("x mod 10 = " + x % 10);
        System.out.println("y mod 10 = " + y % 10);*/
       /* final int y;
        final int x;
        y =3;
        x =6;
        System.out.println(x%y);*/



      /*  String y = "123asdfghj@gmail.com";
        if(y.substring(y.length()-5)
            .equals(".com")){
        System.out.println(y.substring(1));
    }
    else
        System.out.println(y.length());
*/


      /*  // Manually allocate differing size second dimensions
        int twoD[][] = new int[4][];
        twoD[0] = new int[1];
        twoD[1] = new int[2];
        twoD[2] = new int[3];
        twoD[3] = new int[4];

        int i, j, k = 0;

        for (i=0; i<4; i++)
            for(j=0; j<i+1; j++){
                twoD[i][j] = k;
                k++;
            }
            for(i=0; i<4; i++){
                for(j=0; j<i+1; j++)
                    System.out.println(twoD[i][j] + " ");
                System.out.println();
            }
*/

        /* int x = 20;
        int[] a ={3,9,5};
        for(int j=0; j<3; j++){
            x-=a[j];
        }
        System.out.println(x);*/
      /*  int n = 6;
        for(int i = 0; i<3; ++i){
            try
            {
                n /=i;
            }
            catch(Exception e){
                n+=2;
            }
        }
        System.out.println(n);*/


  /*  class Program{
        private int a = 0;
        public Program(int a){
            this.a=a;
        }
    }

     public static void main(String[] args)
     {
         Program p = new Program(127);
         p.a +=73;
         System.out.println(p.a);

       *//*  int twoD[][] = new int[4][5];
         int i, j, k = 0;

         for(i = 0; i < 4; i++)
             for(j = 0; j < 5; j++)
             {
                 twoD[i][j] = k;
                 k++;
             }

         for(i = 0; i < 4; i++)
         {
             for(j = 0; j < 5; j++)
                 System.out.println(twoD[i][j] + " ");
             System.out.println();
         }*//*
     }*/

 /*public static void main(String[] args)
  {
      double nums[] = {10.1, 11.2, 12.3, 13.4, 14.5}; // 61.5
      double result = 0;
      int i;

      for(i=0; i<5; i++)
          result = result + nums[i]; //
      System.out.println(result/5);
  }*/
     /*  static class A{
           int attr;
       }
       static class Test{
           public static void main(String[] args)
           {
               A a = new A();
               a.attr = 1;
               foo(a);
               System.out.println(a.attr);
           }
       }
       static void foo (A a)
       {
           a = new A();
           a.attr = 2;
       }
  }*/

    /* private static String c(int f, int t)
     {
         String s = "";// 1t loop = 45 //
         while(f <= t)
         {
             s += Integer.toString(f++); // 1t loop: s="", f=4 // 2d loop: s=45, f =6 // 3d loop: s=5 f = 6
             s += String.valueOf(f++); // 1t loop: s=4, f=5 // 2d loop: s=456, f = 7 // 3d loop: f = 8
         }
         return s;
     }

     public static void main(String[] args)
     {
         System.out.println(c(4, 7));
     }
 }*/
   /* public static void main(String[] args)
    {
        int i;
        for(i = 0; i<=5; i++)
            System.out.println(i);
    }*/
   /* // What output this code?
    public static void main(String[] args)
    {
        BitSet obj = new BitSet(5);
        for(int i = 0; i<5; ++i)
            obj.set(i);
        System.out.println(obj.get(3));
    }
*/
   /*public static void main(String[] args)
   {
       String word = "starfish";
       String x = word.substring(4);// r
       String y = word.substring(3, 8);// a and h
       int i = 1;
       if(x==y)
       {
           System.out.println(--i);
       }
       else if(x.equals(y))
       {
           System.out.println(i);
       }
       else
           System.out.println(++i);

   }*/

// Demonstrate lifetime of a variable
   /* public static void main(String[] args)
    {
        int x;

        for(x = 0; x < 3; x++)
        {
            int y = -1; // y is initialized each time block is entered
            System.out.println("y is: " + y);
            y = 100;
            System.out.println(

            );
        }
    }*/
    /*public static void main(String[] args)
    {
        int z;
        Integer a = 1000, b = 1000;
        System.out.println(a == b);
        Integer c = 100, d = 100;
        System.out.println(c == d);
        *//*Ответ:
            false
            true
        Вопрос почему?*//*
    }
}*/
   /* public static void main(String[] args)
    {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++)
        {
            StdDraw.point(i, i);
            StdDraw.point(i, i*i);
            StdDraw.point(i, i*Math.log(i));
        }
*/

/* *//* public static void main(String[] args)
    {
        // Вывод случайныз значений из диапазона (lo, hi)
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++)
        {
            double x = StdtRandom.unifirm(lo, hi);
            System.out.println("%.2f\n", x);
        }
    }*/
 /*  public static void main(String[] args)
   {
       //String s = String.format("%2.4f", (Math.PI));
       *//*System.out.printf("Пи примерно равно %.2f\n", Math.PI);*//*
   }*/
 /*  public static void main(String[] args)
   {
       int arr[]={1,2,3,4,5};
       int x = 4;
       int y = 0;
       for(int i = 0; i<5; i++)
           y+=arr[x-i]*i;
       System.out.println(y);
   }*/
 /*  public static void main(String[] args)
   {
       boolean x = true;
       boolean y = false;
       System.out.println(x+""+!y);
   }*/

