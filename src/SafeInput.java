import java.util.Scanner;
public class  SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner pipe, String prompt) {
        int getInt = 0;//initialize variable
        Boolean done = false;//initialize variable
        String trash = "";//initialize variable

        do {//do this block of code while !done
            System.out.println("\n" + prompt + " : ");//prompt to user for their int
            if (pipe.hasNextInt())//if a integer is input run this block of code
            {
                getInt = pipe.nextInt();
                pipe.nextLine();
                done = true;//change done to true, which will stop do while from being looped
            }
            else//if int not given run this
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);//end loop
        return getInt;//get return value


    }
    public static double getDouble(Scanner pipe, String prompt){
        double getDouble = 0;//initialize variable
        Boolean done = false;//initialize variable
        String trash = "";//initialize variable

        do {//do this block while !done
            System.out.println("\n" + prompt + " : ");//prompt to user for double
            if (pipe.hasNextDouble())//check input if double, run this block
            {
                getDouble = pipe.nextDouble();//store user input as getDouble
                pipe.nextLine();
                done = true;
            }
            else//if double not given, run this block
            {
                trash = pipe.nextLine();//store user input as trash
                System.out.println("You must enter an double: " + trash);//tell user to enter a double, output what their answer was
            }
        } while (!done);//loop until this condition is met
        return getDouble;

    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int rangedInt = 0;//initialize variable
        String trash = "";//initialize variable
        boolean done = false;//initialize variable
        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");//prompt user for ranged int
            if (pipe.hasNextInt()) {//if valid int is given run this
                rangedInt = pipe.nextInt();
                if (rangedInt >= low && rangedInt <= high) {//if input is within range change done to true, end loop.
                    done = true;
                } else {//if input is not within range run this code block
                    System.out.println("\n number is out of range [" +low + "-" + high + "]: " + rangedInt  );
                }
            } else {//if none of these conditions are met output to user
                trash = pipe.nextLine();
                System.out.println("you must enter an int: " + trash);
            }
        } while (!done);
        return rangedInt;


    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double rangedDouble = 0;//initialize variable
        String trash = "";//initialize variable
        boolean done = false;//initialize variable
        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");//prompt user for double within range
            if (pipe.hasNextDouble()) {//if input is a double run this
                rangedDouble = pipe.nextDouble();
                if (rangedDouble >= low && rangedDouble <= high) {//if input is within range run this
                    done = true;
                } else {//if double is given but not within range, run this
                    System.out.println("\n number is out of range [" +low + "-" + high + "]: " + rangedDouble  );
                }
            } else {//if double not given run this code block
                trash = pipe.nextLine();
                System.out.println("you must enter an int: " + trash);
            }
        } while (!done);
        return rangedDouble;

    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean  yes = true;//initialize variable
        String YNResp = "";//initialize variable
        boolean no = false;//initialize variable
        do {
            System.out.print("\n" + prompt + "[Y/N] ");//output to user
            YNResp = pipe.nextLine();//store user input as YNResp
            if (YNResp.equalsIgnoreCase("Y")) {//if y response given then run this block
                yes = true;
                no = true;
            } else if (YNResp.equalsIgnoreCase("N")) {//if n response is given run this code block
                yes = false;
                no = true;
            }
            else//if y or n is not given run this code block
            {
                System.out.println("You must answer [Y/N] " + YNResp);
            }
        }while (!no);
        return yes;

    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;//initialize variable
        String match = "";//initialize variable
        String trash = "";//initialize variable
        do {
            System.out.print("\n" + prompt + ": " );//prompt to user
            match = pipe.nextLine();//save user input as match
            if (match.matches(regEx))//if pattern matches run this block
            {

                done = true;//ends program
            } else//if pattern does not match run this
            {
                System.out.print("\n" + match + " must match the pattern " + regEx);
                System.out.println(" try again!");
            }
        }while (!done);
        return match;
    }
    public static void prettyHeader(String msg)
    {
        int LINE = 60;//initialize variable


        if(msg.length() < 54)//run this if there are 54 or characters less  entered
        {
            for (int row = 0 ; row <= LINE; row++)//create * on one row by 1 until 60
            {
                System.out.print("*");
            }
            System.out.print("\n***");//create 3 stars on new line
            int whiteSpace = ( (54 - msg.length())/2);// subtract the 54 available characters by the amount in msg. length then divide by 2

            for (int row = 0; row <= whiteSpace; row++)//while row is less than the whitespace add a star all the way up
            {
                System.out.print(" ");
            }
            System.out.print(msg);//output of user message

            for (int row =0 ; row <= whiteSpace; row++)
            {
                System.out.print(" ");//adds empty space until last 3 *s
            }
            System.out.println("***");//out of 3 stars on right side of heading
            for (int row = 0; row <=LINE; row++)
            {
                System.out.print("*");
            }

            System.out.println(" ");
        } else if (msg.length()>54) {//if msg.length is more then 54 output to user too many characters
            System.out.println("That was too many characters " + msg.length() + " Try again");


        }


        return ;
    }
}