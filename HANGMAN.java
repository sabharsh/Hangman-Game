import java.io.*;
public class HANGMAN
{
    public static void main()throws IOException//; throws InteruptedException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\f");
        CoolName2("welcome");
        System.out.println();
        CoolName2("to");
        System.out.println();
        CoolName2("hangman!!!");
        try 
        {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("\f");

        CoolName2("  Instructions");
        System.out.println("***********************************************************************************************************************************************************************************************************");
        System.out.println("1) Enter the number of the option which you want to choose in a menu.");
        System.out.println("2) Enter ONLY ONE CHARACTER at a time while playing.");
        System.out.println("3) Enter all characters in LOWER CASE while playing(OTHERWISE YOU LOSE!!!).");
        System.out.println("4) Enter only FIRST NAME when playing double player.");
        System.out.println("5) Enter each wrong character ONLY ONCE while playing, otherwise it will be counted as a penalty(it will be counted as a chance).");
        System.out.println("6) DO NOT press enter at any point of entry unless asked to.");
        System.out.println("7) After entering words, check spellings of the word and then confirm entry.");
        System.out.println();
        char z;
        System.out.print("Press enter after reading to continue");
        z=(char)br.read();

        System.out.println("\f");

        int ch;
        do
        {
            System.out.println('\f');

            CoolName2("   MAIN MENU"  );
            System.out.println("                              _____________________________________________________________________________________________________________________");
            System.out.println("***********************************************************************************************************************************************************************************************************");
            CoolName2("1)Play Game");
            System.out.println();
            CoolName2("2)Word List");
            System.out.println();
            CoolName2("3)Enter Words");
            System.out.println();
            CoolName2("4)Reenter all");
            System.out.println();
            CoolName2("5)Exit");
            System.out.print("ENTER CHOICE(1,2,3,4 or 5):");
            ch=Integer.parseInt(br.readLine());
            System.out.println("\f");
            int chgame;
            if(ch==1)//play game
            {
                do
                {
                    System.out.println("\f");
                    CoolName2("   Game Menu");
                    System.out.println("                              _____________________________________________________________________________________________________________________");
                    System.out.println("***********************************************************************************************************************************************************************************************************");
                    CoolName2("1) 1 Player");
                    System.out.println();
                    CoolName2("2) 2 Player");
                    System.out.println();
                    CoolName2("3) Main Menu");
                    System.out.println();
                    System.out.print("ENTER CHOICE(1,2 or 3):");
                    chgame=Integer.parseInt(br.readLine());

                    if(chgame==1)//1 player
                    {
                        int decision;
                        do
                        {
                            System.out.println('\f');
                            String file;
                            CoolName2("  1 Player Menu");
                            System.out.println("                   ___________________________________________________________________________________________________________________________________________________________________");
                            System.out.println("***********************************************************************************************************************************************************************************************************");
                            CoolName2("1)-Bollywood Mov.");
                            System.out.println();
                            CoolName2("2)-Hollywood Mov.");
                            System.out.println();
                            CoolName2("3)-English Words");
                            System.out.println();
                            CoolName2("4)-Songs");
                            System.out.println();
                            CoolName2("5)-Exit");
                            System.out.println();
                            System.out.print("ENTER CHOICE(1,2,3,4 or 5): ");
                            decision=Integer.parseInt(br.readLine());
                            if(decision==1)file="bollywood_mov.txt";
                            else if(decision==2)file="hollywood_mov.txt";
                            else if(decision==3)file="english_dictionary.txt";
                            else if(decision==4)file="songs.txt";
                            else break;

                            System.out.println('\f');
                            int n=0;//no. of words in array
                            int arrcount=0;//to change the element in the array - random

                            BufferedReader ifile;
                            ifile= new BufferedReader(new FileReader(file));
                            while(ifile.readLine()!=null)//incrimate value of no. of words
                            {
                                n++;
                            }
                            ifile.close();
                            n=n/2;
                            int random[]=new int[n];

                            random[0]=(int)(Math.random() * (n));
                            int i=1;//incrimate value of random
                            int temp;//temperarely store the value of the random number
                            boolean flag;//if true-random number is unique, else not
                            do
                            {
                                flag =true;//when true the random value will be stored
                                temp=(int)(Math.random() * (n));
                                for(int j=0; j<i; j++)
                                {
                                    if(temp==random[j])flag=false;
                                }
                                if(flag==true)//random number is unique
                                {
                                    random[i]=temp;
                                    //System.out.print("hi"+random[i]);
                                    i++;
                                }
                                //n is the number of elements in array-random
                                //elements in random are from 0 to n-1
                            }while(i<n);

                            char d;
                            do
                            {
                                System.out.println("\f");
                                if(arrcount>=n)
                                {
                                    char c;
                                    CoolName2("You have ");
                                    System.out.println();
                                    CoolName2("completed the ");
                                    System.out.println();
                                    CoolName2("word list!!! ");
                                    System.out.println();
                                    System.out.print("You will now enter the main menu(Please press any key and then enter): ");
                                    c=(char)br.read();br.read();
                                    break;
                                }
                                Player1(random[arrcount], file);
                                arrcount++;
                                System.out.println();
                                System.out.print("PLAY AGAIN (y/n)?:");
                                d=(char)br.read();br.read();
                            }while(d=='y' || d=='Y');
                        }while(decision!=5);
                    }
                    else if(chgame==2)//2 player
                    {
                        System.out.println('\f');
                        Player2();
                        /*char d;
                        do
                        {
                        System.out.println("\f");
                        Player2();
                        System.out.println();
                        System.out.print("PLAY AGAIN (y/n)?:");
                        d=(char)br.read();br.read();
                        }while(d=='y' || d=='Y');*/
                    }
                }while(chgame!=3);
            }

            else if(ch==2)//word list
            {
                System.out.println('\f');
                char d;
                read();
                do
                {
                    System.out.print("Return to Main Menu(y/n)? :");
                    d=(char)br.read(); br.read();
                }while(d!='y' && d!='Y');
            }

            else if(ch==3)//enter words
            {
                System.out.println('\f');
                append();
            }

            else if(ch==4)//reenter all
            {
                char clearch;
                System.out.println('\f');
                System.out.println("Warning! You are about to delete all data from the file.\nConfirm(y/n)");
                clearch=(char)br.read();br.read();
                if(clearch=='y' || clearch=='Y') write();
            }

        }while(ch!=5);
        System.out.println("\f");
        CoolName2("THANKS");
        System.out.println();
        CoolName2("FOR");
        System.out.println();
        CoolName2("PLAYING!!!");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                                                                                                       Copyright - Sabharsh Singh Sidhu");

        try 
        {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {Thread.currentThread().interrupt();}

        System.exit(0);
    }

    
    void Player1(int r, String file)throws IOException
    {
        int n=0;//no. of words in array

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader ifile = new BufferedReader(new FileReader(file));
        while(ifile.readLine()!=null)//incrimate value of no. of words
        {
            n++;
        }
        ifile.close();
        n=n/2;
        String wordarr[]=new String[n];
        String meaningarr[]=new String[n];

        ifile=new BufferedReader(new FileReader(file));
        for(int i=0; i<n; i++)
        {
            wordarr[i]=ifile.readLine();
            meaningarr[i]=ifile.readLine();
        }
        ifile.close();

        // NOT TO BE USED UNLESS R IS REMOVED FROM PARINTHESIS - int r=0 + (int)(Math.random() * (n));//to find a random word
        int mistakes=0;
        String word=wordarr[r];
        word=word.toLowerCase();
        String meaning=meaningarr[r];
        String blank="";
        String a;
        String wrong="";
        String previous;

        for(int i=0; i<word.length(); i++)
        {
            if(word.charAt(i)!=' ')
            {
                blank=blank+"-";
            }
            else
            {
                blank=blank+" ";
            }
        }
        previous=blank;
        int count=0;
        do
        {
            if(mistakes==0)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /             \\        *");
                System.out.println("*       |               |       *");
                System.out.println("*       |               |       *");
                System.out.println("*       |               |       *");
                System.out.println("*        \\             /        *");
                System.out.println("*          \\ _______ /          *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
            }
            else if(mistakes==1)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /    * * *    \\        *");
                System.out.println("*       |   * o   o *   |       *");
                System.out.println("*       |  *    |    *  |       *");
                System.out.println("*       |   * /---\\ *   |       *");
                System.out.println("*        \\    * * *    /        *");
                System.out.println("*          \\ __ * __ /          *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
            }
            else if(mistakes==2)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /    * * *    \\        *");
                System.out.println("*       |   * o   o *   |       *");
                System.out.println("*       |  *    |    *  |       *");
                System.out.println("*       |   * /---\\ *   |       *");
                System.out.println("*        \\    * * *    /        *");
                System.out.println("*          \\ __ * __ /          *");
                System.out.println("*         H H * * * H H         *");
                System.out.println("*       H  H H H H H H  H       *");
                System.out.println("*          H H H H H H          *");
                System.out.println("*          H H H H H H          *");
                System.out.println("*          H H H H H H          *");
                System.out.println("*          H H H H H H          *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
            }
            else if(mistakes==3)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /    * * *    \\        *");
                System.out.println("*       |   * o   o *   |       *");
                System.out.println("*       |  *    |    *  |       *");
                System.out.println("*       |   * /---\\ *   |       *");
                System.out.println("*        \\    * * *    /        *");
                System.out.println("*          \\ __ * __ /          *");
                System.out.println("*         H H * * * H H         *");
                System.out.println("*       H  H H H H H H  H       *");
                System.out.println("*      *   H H H H H H          *");
                System.out.println("*      *   H H H H H H          *");
                System.out.println("*      *   H H H H H H          *");
                System.out.println("*      *   H H H H H H          *");
                System.out.println("*     /|\\                       *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
            }
            else if(mistakes==4)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /    * * *    \\        *");
                System.out.println("*       |   * o   o *   |       *");
                System.out.println("*       |  *    |    *  |       *");
                System.out.println("*       |   * /---\\ *   |       *");
                System.out.println("*        \\    * * *    /        *");
                System.out.println("*          \\ __ * __ /          *");
                System.out.println("*         H H * * * H H         *");
                System.out.println("*       H  H H H H H H  H       *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*     /|\\               /|\\     *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
            }
            else if(mistakes==5)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /    * * *    \\        *");
                System.out.println("*       |   * o   o *   |       *");
                System.out.println("*       |  *    |    *  |       *");
                System.out.println("*       |   * /---\\ *   |       *");
                System.out.println("*        \\    * * *    /        *");
                System.out.println("*          \\ __ * __ /          *");
                System.out.println("*         H H * * * H H         *");
                System.out.println("*       H  H H H H H H  H       *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*     /|\\  = = =M= = =  /|\\     *");
                System.out.println("*          A  A A A  A          *");
                System.out.println("*          A A                  *");
                System.out.println("*          A A                  *");
                System.out.println("*          A A                  *");
                System.out.println("*          A A                  *");
                System.out.println("*          A A                  *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
            }

            System.out.println("WORD:   "+blank);
            System.out.println("HINT/MEANING - "+meaning);
            System.out.println("Wrong alphabets used - "+wrong);
            System.out.println("Number of mistakes left - "+(6-mistakes));
            System.out.print("Enter Alphabet(in lower case) - ");
            a=br.readLine();
            System.out.println();
            System.out.println();

            int mistak=0;//for incrimenting the value of number of mistakes(by checking if the alphabet is present in the string or not)
            blank="";
            for(int i=0; i<word.length(); i++)
            {
                if(a.charAt(0)==word.charAt(i))
                {
                    blank=blank+a.charAt(0);
                }
                else
                {
                    mistak++;
                    if(previous.charAt(i)!=' ')
                    {
                        blank=blank+previous.charAt(i);
                    }
                    else
                    {
                        if(word.charAt(i)!=' ')blank=blank+"-";
                        else blank=blank+' ';
                    }
                }
            }

            if(mistak==word.length())
            {
                mistakes++;
                wrong=wrong+a.charAt(0)+", ";
            }

            if(blank.equalsIgnoreCase(wordarr[r]))break;
            previous=blank;
            System.out.println('\f');

        }while(mistakes<6);

        if(blank.equalsIgnoreCase(wordarr[r]))
        {
            System.out.println('\f');
            CoolName2("YOU WIN!!!");
            System.out.println();
            System.out.println();
            System.out.println("WORD - "+word);
            System.out.println("HINT/MEANING - "+meaning);
            if(wrong.equals(""))wrong="None";
            System.out.println("Wrong alphabets used - "+wrong);

        }

        if(mistakes==6)
        {
            System.out.println("* * * * * * * * * * * * * * * * *");
            System.out.println("*               |               *");
            System.out.println("*               |               *");
            System.out.println("*            ___|___            *");
            System.out.println("*          /         \\          *");
            System.out.println("*        /    * * *    \\        *");
            System.out.println("*       |   * o   o *   |       *");
            System.out.println("*       |  *    |    *  |       *");
            System.out.println("*       |   * /---\\ *   |       *");
            System.out.println("*        \\    * * *    /        *");
            System.out.println("*          \\ __ * __ /          *");
            System.out.println("*         H H * * * H H         *");
            System.out.println("*       H  H H H H H H  H       *");
            System.out.println("*      *   H H H H H H   *      *");
            System.out.println("*      *   H H H H H H   *      *");
            System.out.println("*      *   H H H H H H   *      *");
            System.out.println("*      *   H H H H H H   *      *");
            System.out.println("*     /|\\  = = =M= = =  /|\\     *");
            System.out.println("*          A  A A A  A          *");
            System.out.println("*          A A     A A          *");
            System.out.println("*          A A     A A          *");
            System.out.println("*          A A     A A          *");
            System.out.println("*          A A     A A          *");
            System.out.println("*          A A     A A          *");
            System.out.println("*                               *");
            System.out.println("* * * * * * * * * * * * * * * * *");
            System.out.println();
            System.out.println();
            CoolName2("YOU LOSE!!!");
            System.out.println();
            System.out.println();
            System.out.println("WORD - "+word);
            System.out.println("Meaning/Info - "+meaning);
        }
    }

    
    
    void Player2()throws IOException
    {
        System.out.println("\f");
        int n=0;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String player;

        String p1name;
        int p1lose=0;
        int p1win=0;

        String p2name;
        int p2lose=0;
        int p2win=0;

        System.out.print("ENTER THE NAME OF PLAYER 1: ");
        p1name=br.readLine();
        System.out.print("ENTER THE NAME OF PLAYER 2: ");
        p2name=br.readLine();
        System.out.println();
        System.out.print("ENTER THE PLAYER WHO WOULD LIKE TO START FIRST(p1 or p2):");
        player=br.readLine();

        String word="";
        String meaning="";

        char d;
        do
        {
            System.out.println("\f");

            if(player.equalsIgnoreCase("p1"))
            {
                System.out.print(p1name+", please enter word which you want "+p2name+" to guess: ");
                word=br.readLine();
                System.out.print("Enter meaning of/info about the word: ");
                meaning=br.readLine();
            }
            else if(player.equalsIgnoreCase("p2"))
            {
                System.out.print(p2name+", please enter word which you want "+p1name+" to guess: ");
                word=br.readLine();
                System.out.print("Enter meaning of/info about the word: ");
                meaning=br.readLine();
            }
            else break;

            System.out.println('\f');
            word=word.toLowerCase();
            int mistakes=0;
            String blank="";
            String a;
            String wrong="";
            String previous;

            for(int i=0; i<word.length(); i++)
            {
                if(word.charAt(i)!=' ')
                {
                    blank=blank+"-";
                }
                else
                {
                    blank=blank+" ";
                }
            }
            previous=blank;
            int count=0;
            do
            {
                if(mistakes==0)
                {
                    System.out.println("* * * * * * * * * * * * * * * * *");
                    System.out.println("*               |               *");
                    System.out.println("*               |               *");
                    System.out.println("*            ___|___            *");
                    System.out.println("*          /         \\          *");
                    System.out.println("*        /             \\        *");
                    System.out.println("*       |               |       *");
                    System.out.println("*       |               |       *");
                    System.out.println("*       |               |       *");
                    System.out.println("*        \\             /        *");
                    System.out.println("*          \\ _______ /          *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("* * * * * * * * * * * * * * * * *");
                }
                else if(mistakes==1)
                {
                    System.out.println("* * * * * * * * * * * * * * * * *");
                    System.out.println("*               |               *");
                    System.out.println("*               |               *");
                    System.out.println("*            ___|___            *");
                    System.out.println("*          /         \\          *");
                    System.out.println("*        /    * * *    \\        *");
                    System.out.println("*       |   * o   o *   |       *");
                    System.out.println("*       |  *    |    *  |       *");
                    System.out.println("*       |   * /---\\ *   |       *");
                    System.out.println("*        \\    * * *    /        *");
                    System.out.println("*          \\ __ * __ /          *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("* * * * * * * * * * * * * * * * *");
                }
                else if(mistakes==2)
                {
                    System.out.println("* * * * * * * * * * * * * * * * *");
                    System.out.println("*               |               *");
                    System.out.println("*               |               *");
                    System.out.println("*            ___|___            *");
                    System.out.println("*          /         \\          *");
                    System.out.println("*        /    * * *    \\        *");
                    System.out.println("*       |   * o   o *   |       *");
                    System.out.println("*       |  *    |    *  |       *");
                    System.out.println("*       |   * /---\\ *   |       *");
                    System.out.println("*        \\    * * *    /        *");
                    System.out.println("*          \\ __ * __ /          *");
                    System.out.println("*         H H * * * H H         *");
                    System.out.println("*       H  H H H H H H  H       *");
                    System.out.println("*          H H H H H H          *");
                    System.out.println("*          H H H H H H          *");
                    System.out.println("*          H H H H H H          *");
                    System.out.println("*          H H H H H H          *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("* * * * * * * * * * * * * * * * *");
                }
                else if(mistakes==3)
                {
                    System.out.println("* * * * * * * * * * * * * * * * *");
                    System.out.println("*               |               *");
                    System.out.println("*               |               *");
                    System.out.println("*            ___|___            *");
                    System.out.println("*          /         \\          *");
                    System.out.println("*        /    * * *    \\        *");
                    System.out.println("*       |   * o   o *   |       *");
                    System.out.println("*       |  *    |    *  |       *");
                    System.out.println("*       |   * /---\\ *   |       *");
                    System.out.println("*        \\    * * *    /        *");
                    System.out.println("*          \\ __ * __ /          *");
                    System.out.println("*         H H * * * H H         *");
                    System.out.println("*       H  H H H H H H  H       *");
                    System.out.println("*      *   H H H H H H          *");
                    System.out.println("*      *   H H H H H H          *");
                    System.out.println("*      *   H H H H H H          *");
                    System.out.println("*      *   H H H H H H          *");
                    System.out.println("*     /|\\                       *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("* * * * * * * * * * * * * * * * *");
                }
                else if(mistakes==4)
                {
                    System.out.println("* * * * * * * * * * * * * * * * *");
                    System.out.println("*               |               *");
                    System.out.println("*               |               *");
                    System.out.println("*            ___|___            *");
                    System.out.println("*          /         \\          *");
                    System.out.println("*        /    * * *    \\        *");
                    System.out.println("*       |   * o   o *   |       *");
                    System.out.println("*       |  *    |    *  |       *");
                    System.out.println("*       |   * /---\\ *   |       *");
                    System.out.println("*        \\    * * *    /        *");
                    System.out.println("*          \\ __ * __ /          *");
                    System.out.println("*         H H * * * H H         *");
                    System.out.println("*       H  H H H H H H  H       *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*     /|\\               /|\\     *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("*                               *");
                    System.out.println("* * * * * * * * * * * * * * * * *");
                }
                else if(mistakes==5)
                {
                    System.out.println("* * * * * * * * * * * * * * * * *");
                    System.out.println("*               |               *");
                    System.out.println("*               |               *");
                    System.out.println("*            ___|___            *");
                    System.out.println("*          /         \\          *");
                    System.out.println("*        /    * * *    \\        *");
                    System.out.println("*       |   * o   o *   |       *");
                    System.out.println("*       |  *    |    *  |       *");
                    System.out.println("*       |   * /---\\ *   |       *");
                    System.out.println("*        \\    * * *    /        *");
                    System.out.println("*          \\ __ * __ /          *");
                    System.out.println("*         H H * * * H H         *");
                    System.out.println("*       H  H H H H H H  H       *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*      *   H H H H H H   *      *");
                    System.out.println("*     /|\\  = = =M= = =  /|\\     *");
                    System.out.println("*          A  A A A  A          *");
                    System.out.println("*          A A                  *");
                    System.out.println("*          A A                  *");
                    System.out.println("*          A A                  *");
                    System.out.println("*          A A                  *");
                    System.out.println("*          A A                  *");
                    System.out.println("*                               *");
                    System.out.println("* * * * * * * * * * * * * * * * *");
                }

                System.out.println("WORD:   "+blank);
                System.out.println("HINT/MEANING - "+meaning);
                System.out.println("Wrong alphabets used - "+wrong);
                System.out.println("Number of mistakes left - "+(6-mistakes));
                System.out.print("Enter Alphabet(in lower case) - ");
                a=br.readLine();
                System.out.println();
                System.out.println();

                int mistak=0;//for further counting mistakes
                blank="";
                for(int i=0; i<word.length(); i++)
                {
                    if(a.charAt(0)==word.charAt(i))
                    {
                        blank=blank+a.charAt(0);
                    }
                    else
                    {
                        mistak++;
                        if(previous.charAt(i)!=' ')
                        {
                            blank=blank+previous.charAt(i);
                        }
                        else
                        {
                            if(word.charAt(i)!=' ')blank=blank+"-";
                            else blank=blank+' ';
                        }
                    }
                }

                if(mistak==word.length())
                {
                    mistakes++;
                    wrong=wrong+a.charAt(0)+", ";
                }

                if(blank.equalsIgnoreCase(word))break;
                previous=blank;
                System.out.println('\f');

            }while(mistakes<6);

            if(blank.equalsIgnoreCase(word))
            {
                System.out.println('\f');

                if(player.equalsIgnoreCase("p1"))
                {
                    p2win++;
                    CoolName2(p2name);
                }
                else if(player.equalsIgnoreCase("p2"))
                {
                    p1win++;
                    CoolName2(p1name);
                }

                System.out.println();
                CoolName2("WON!!!");
                System.out.println();
                System.out.println();
                System.out.println("WORD - "+word);
                System.out.println("HINT/MEANING - "+meaning);
                if(wrong.equals(""))wrong="None";
                System.out.println("Wrong alphabets used - "+wrong);

            }

            if(mistakes==6)
            {
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println("*               |               *");
                System.out.println("*               |               *");
                System.out.println("*            ___|___            *");
                System.out.println("*          /         \\          *");
                System.out.println("*        /    * * *    \\        *");
                System.out.println("*       |   * o   o *   |       *");
                System.out.println("*       |  *    |    *  |       *");
                System.out.println("*       |   * /---\\ *   |       *");
                System.out.println("*        \\    * * *    /        *");
                System.out.println("*          \\ __ * __ /          *");
                System.out.println("*         H H * * * H H         *");
                System.out.println("*       H  H H H H H H  H       *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*      *   H H H H H H   *      *");
                System.out.println("*     /|\\  = = =M= = =  /|\\     *");
                System.out.println("*          A  A A A  A          *");
                System.out.println("*          A A     A A          *");
                System.out.println("*          A A     A A          *");
                System.out.println("*          A A     A A          *");
                System.out.println("*          A A     A A          *");
                System.out.println("*          A A     A A          *");
                System.out.println("*                               *");
                System.out.println("* * * * * * * * * * * * * * * * *");
                System.out.println();
                System.out.println();

                if(player.equalsIgnoreCase("p1"))
                {
                    p2lose++;
                    CoolName2(p2name);
                }
                else if(player.equalsIgnoreCase("p2"))
                {
                    p1lose++;
                    CoolName2(p1name);
                }

                System.out.println();
                String s="LOST!!!";
                CoolName2(s);
                System.out.println();
                System.out.println();
                System.out.println("WORD - "+word);
                System.out.println("Meaning/Info - "+meaning);
            }

            if(player.equalsIgnoreCase("p1"))
            {
                player="p2";
            }
            else if(player.equalsIgnoreCase("p2"))
            {
                player="p1";
            }

            System.out.print("PLAY AGAIN (y/n)?:");
            d=(char)br.read();br.read();
        }while(d=='y' || d=='Y');
        System.out.println("\f");

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        if(p1name.length()<7) System.out.println("\t\t"+p1name+" \t\t\t"+p2name);
        else if(p1name.length()<15)System.out.println("\t\t"+p1name+" \t\t"+p2name);
        else System.out.println("\t\t"+p1name+" \t"+p2name);
        System.out.println("Losses\t\t"+p1lose+" \t\t\t"+p2lose);
        System.out.println("Wins\t\t"+p1win+" \t\t\t"+p2win);
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        char cho;
        do
        {
            System.out.println("RETURN TO GAME MENU(y/n):");
            cho=(char)br.read();br.read();
        }while(cho!='y' && cho!='Y');

        //System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        //System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    
    void write()throws IOException //output mode
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int decision;
        do
        {
            System.out.println('\f');
            String file;
            CoolName2("   Re_enter Menu");
            System.out.println("***********************************************************************************************************************************************************************************************************");
            CoolName2("1)-Bollywood Mov.");
            System.out.println();
            CoolName2("2)-Hollywood Mov.");
            System.out.println();
            CoolName2("3)-English Words");
            System.out.println();
            CoolName2("4)-Songs");
            System.out.println();
            CoolName2("5)-Exit ");
            System.out.println();
            System.out.print("ENTER CHOICE(1,2,3,4 or 5): ");
            decision=Integer.parseInt(br.readLine());
            if(decision==1)file="Bollywood_Mov.dox";
            else if(decision==2)file="Hollywood_Mov.dox";
            else if(decision==3)file="English_Dictionary.dox";
            else if(decision==4)file="Songs.dox";
            else break;
            System.out.println('\f');

            //FileWriter file= new FileWriter("aform.dat");
            //PrintWriter ofile= new PrintWriter(file);
            PrintWriter ofile=new PrintWriter(new FileWriter(file));
            //opening file in Output mode
            String word;
            String meaning;
            char ch;

            do
            {
                System.out.print("Enter Word: ");
                word=br.readLine();
                System.out.print("Meaning of/Info about '"+word+"': ");
                meaning=br.readLine();

                char c;
                System.out.println("Are you sure you want to enter this word(y/n)?");
                c=(char)br.read();br.read();
                if(c=='y' || c=='Y')
                {
                    ofile.println(word);
                    ofile.println(meaning);
                }

                System.out.println("Continue entering words?(y/n)");
                ch=(char)br.read();
                br.read();
                System.out.println("   ___   ___   ___");
                System.out.println();
            }while(ch=='Y' || ch=='y');
            ofile.close();
            //Whenever you open a file, always remember to close it
        }while(decision!=5);
    }

    
    void append()throws IOException //output mode
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int decision;
        do
        {
            System.out.println('\f');
            String file;
            CoolName2("    Enter Menu");
            System.out.println("***********************************************************************************************************************************************************************************************************");
            CoolName2("1)-Bollywood Mov.");
            System.out.println();
            CoolName2("2)-Hollywood Mov.");
            System.out.println();
            CoolName2("3)-English Words");
            System.out.println();
            CoolName2("4)-Songs");
            System.out.println();
            CoolName2("5)-Exit ");
            System.out.println();
            System.out.print("ENTER CHOICE(1,2,3,4 or 5): ");
            decision=Integer.parseInt(br.readLine());
            System.out.println('\f');

            if(decision==1)file="Bollywood_Mov.dox";
            else if(decision==2)file="Hollywood_Mov.dox";
            else if(decision==3)file="English_Dictionary.dox";
            else if(decision==4)file="Songs.dox";
            else break;

            //FileWriter file= new FileWriter("aform.dat");
            //PrintWriter ofile= new PrintWriter(file);
            PrintWriter ofile=new PrintWriter(new FileWriter(file,true));
            //opening file in Output mode
            String word;
            String meaning;
            char ch;

            do
            {
                System.out.print("Enter Word: ");
                word=br.readLine();
                System.out.print("Meaning of/Info about '"+word+"': ");
                meaning=br.readLine();

                char c;
                System.out.println("Are you sure you want to enter this word(y/n)?");
                c=(char)br.read();br.read();
                if(c=='y' || c=='Y')
                {
                    ofile.println(word);
                    ofile.println(meaning);
                }

                System.out.println("Continue entering words?(y/n)");
                ch=(char)br.read();
                br.read();
                System.out.println("   ___   ___   ___");
                System.out.println();
            }while(ch=='Y' || ch=='y');
            ofile.close();
            //Whenever you open a file, always remember to close it
        }while(decision!=5);
    }

    
    void read()throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String file="";
        String filename="";
        for(int decision=1; decision<=4; decision++)
        {
            if(decision==1)filename="Bollywood Mov.";
            else if(decision==2)filename="Hollywood Mov.";
            else if(decision==3)filename="English Words";
            else if(decision==4)filename="Songs";

            if(decision==1)file="Bollywood_Mov.dox";
            else if(decision==2)file="Hollywood_Mov.dox";
            else if(decision==3)file="English_Dictionary.dox";
            else if(decision==4)file="Songs.dox";

            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
            CoolName2(filename);
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.println();
            System.out.println();

            BufferedReader ifile = new BufferedReader(new FileReader(file));
            // Input Mode/Read Mode
            String w;
            String m;
            int count=1;
            while(true)
            {
                w=ifile.readLine();
                if(w==null)
                    break;
                m=ifile.readLine();
                System.out.println(count+") "+w+" - "+m);
                count++;
            }
            System.out.println();
            ifile.close();
        }
    }

    
    void CoolName2(String s)
    {
        //1111111111111111111111111111
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='A'||s.charAt(i)=='a')System.out.print("A A A A A ");
            else if(s.charAt(i)=='B'||s.charAt(i)=='b')System.out.print("B B B B   ");
            else if(s.charAt(i)=='C'||s.charAt(i)=='c')System.out.print("  C C C C ");
            else if(s.charAt(i)=='D'||s.charAt(i)=='d')System.out.print("D D D D   ");
            else if(s.charAt(i)=='E'||s.charAt(i)=='e')System.out.print("E E E E E ");
            else if(s.charAt(i)=='F'||s.charAt(i)=='f')System.out.print("F F F F F ");
            else if(s.charAt(i)=='G'||s.charAt(i)=='g')System.out.print("  G G G G ");
            else if(s.charAt(i)=='H'||s.charAt(i)=='h')System.out.print("H       H ");
            else if(s.charAt(i)=='I'||s.charAt(i)=='i')System.out.print("I I I I I ");
            else if(s.charAt(i)=='J'||s.charAt(i)=='j')System.out.print("J J J J J ");
            else if(s.charAt(i)=='K'||s.charAt(i)=='k')System.out.print("K       K ");
            else if(s.charAt(i)=='L'||s.charAt(i)=='l')System.out.print("L         ");
            else if(s.charAt(i)=='M'||s.charAt(i)=='m')System.out.print("M       M ");
            else if(s.charAt(i)=='N'||s.charAt(i)=='n')System.out.print("N       N ");
            else if(s.charAt(i)=='O'||s.charAt(i)=='o')System.out.print("O O O O O ");
            else if(s.charAt(i)=='P'||s.charAt(i)=='p')System.out.print("P P P P P ");
            else if(s.charAt(i)=='Q'||s.charAt(i)=='q')System.out.print("  Q Q Q   ");
            else if(s.charAt(i)=='R'||s.charAt(i)=='r')System.out.print("R R R R R ");
            else if(s.charAt(i)=='S'||s.charAt(i)=='s')System.out.print("S S S S S ");
            else if(s.charAt(i)=='T'||s.charAt(i)=='t')System.out.print("T T T T T ");
            else if(s.charAt(i)=='U'||s.charAt(i)=='u')System.out.print("U       U ");
            else if(s.charAt(i)=='V'||s.charAt(i)=='v')System.out.print("V       V ");
            else if(s.charAt(i)=='W'||s.charAt(i)=='w')System.out.print("W       W ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("X       X ");
            else if(s.charAt(i)=='Y'||s.charAt(i)=='y')System.out.print("Y       Y ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("Z Z Z Z Z ");
            else if(s.charAt(i)=='1')System.out.print("  1  ");
            else if(s.charAt(i)=='2')System.out.print("  2 2 2  ");
            else if(s.charAt(i)=='3')System.out.print("3 3 3  ");
            else if(s.charAt(i)=='4')System.out.print("      4  ");
            else if(s.charAt(i)=='5')System.out.print("  5 5 5 5");
            else if(s.charAt(i)=='6')System.out.print("   6 6 6");
            else if(s.charAt(i)=='7')System.out.print("7 7 7 7 7");
            else if(s.charAt(i)=='8')System.out.print("  8 8 8  ");
            else if(s.charAt(i)=='9')System.out.print("  9 9 9  ");
            else if(s.charAt(i)=='0')System.out.print(" 0 0 0 0 ");
            else if(s.charAt(i)=='.')System.out.print("    ");
            else if(s.charAt(i)==')')System.out.print(")   ");
            else if(s.charAt(i)=='!')System.out.print(" |");
            else if(s.charAt(i)=='/')System.out.print("        * ");
            else if(s.charAt(i)==' '||s.charAt(i)==' ')System.out.print("        ");
            System.out.print("   ");
        }
        System.out.println();

        //2222222222222222222222222222

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='A'||s.charAt(i)=='a')System.out.print("A       A ");
            else if(s.charAt(i)=='B'||s.charAt(i)=='b')System.out.print("B      B  ");
            else if(s.charAt(i)=='C'||s.charAt(i)=='c')System.out.print("C         ");
            else if(s.charAt(i)=='D'||s.charAt(i)=='d')System.out.print("D       D ");
            else if(s.charAt(i)=='E'||s.charAt(i)=='e')System.out.print("E         ");
            else if(s.charAt(i)=='F'||s.charAt(i)=='f')System.out.print("F         ");
            else if(s.charAt(i)=='G'||s.charAt(i)=='g')System.out.print("G         ");
            else if(s.charAt(i)=='H'||s.charAt(i)=='h')System.out.print("H       H ");
            else if(s.charAt(i)=='I'||s.charAt(i)=='i')System.out.print("    I     ");
            else if(s.charAt(i)=='J'||s.charAt(i)=='j')System.out.print("    J     ");
            else if(s.charAt(i)=='K'||s.charAt(i)=='k')System.out.print("K    K    ");
            else if(s.charAt(i)=='L'||s.charAt(i)=='l')System.out.print("L         ");
            else if(s.charAt(i)=='M'||s.charAt(i)=='m')System.out.print("M M   M M ");
            else if(s.charAt(i)=='N'||s.charAt(i)=='n')System.out.print("N N     N ");
            else if(s.charAt(i)=='O'||s.charAt(i)=='o')System.out.print("O       O ");
            else if(s.charAt(i)=='P'||s.charAt(i)=='p')System.out.print("P       P ");
            else if(s.charAt(i)=='Q'||s.charAt(i)=='q')System.out.print("Q       Q ");
            else if(s.charAt(i)=='R'||s.charAt(i)=='r')System.out.print("R       R ");
            else if(s.charAt(i)=='S'||s.charAt(i)=='s')System.out.print("S         ");
            else if(s.charAt(i)=='T'||s.charAt(i)=='t')System.out.print("    T     ");
            else if(s.charAt(i)=='U'||s.charAt(i)=='u')System.out.print("U       U ");
            else if(s.charAt(i)=='V'||s.charAt(i)=='v')System.out.print(" V     V  ");
            else if(s.charAt(i)=='W'||s.charAt(i)=='w')System.out.print("W   W   W ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("  X   X   ");
            else if(s.charAt(i)=='Y'||s.charAt(i)=='y')System.out.print("  Y   Y   ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("      Z   ");
            else if(s.charAt(i)=='1')System.out.print("1 1  ");
            else if(s.charAt(i)=='2')System.out.print("2       2");
            else if(s.charAt(i)=='3')System.out.print("      3");
            else if(s.charAt(i)=='4')System.out.print("    4 4  ");
            else if(s.charAt(i)=='5')System.out.print(" 5       ");
            else if(s.charAt(i)=='6')System.out.print(" 6      ");
            else if(s.charAt(i)=='7')System.out.print("       7 ");
            else if(s.charAt(i)=='8')System.out.print("8       8");
            else if(s.charAt(i)=='9')System.out.print("9       9");
            else if(s.charAt(i)=='0')System.out.print("0       0");
            else if(s.charAt(i)=='.')System.out.print("    ");
            else if(s.charAt(i)==')')System.out.print("  ) ");
            else if(s.charAt(i)=='!')System.out.print(" |");
            else if(s.charAt(i)=='/')System.out.print("      *   ");
            else if(s.charAt(i)==' '||s.charAt(i)==' ')System.out.print("        ");
            System.out.print("   ");
        }
        System.out.println();

        //33333333333333333333

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='A'||s.charAt(i)=='a')System.out.print("A A A A A ");
            else if(s.charAt(i)=='B'||s.charAt(i)=='b')System.out.print("B B B B   ");
            else if(s.charAt(i)=='C'||s.charAt(i)=='c')System.out.print("C         ");
            else if(s.charAt(i)=='D'||s.charAt(i)=='d')System.out.print("D       D ");
            else if(s.charAt(i)=='E'||s.charAt(i)=='e')System.out.print("E E E E   ");
            else if(s.charAt(i)=='F'||s.charAt(i)=='f')System.out.print("F F F F   ");
            else if(s.charAt(i)=='G'||s.charAt(i)=='g')System.out.print("G     G G ");
            else if(s.charAt(i)=='H'||s.charAt(i)=='h')System.out.print("H H H H H ");
            else if(s.charAt(i)=='I'||s.charAt(i)=='i')System.out.print("    I     ");
            else if(s.charAt(i)=='J'||s.charAt(i)=='j')System.out.print("    J     ");
            else if(s.charAt(i)=='K'||s.charAt(i)=='k')System.out.print("K K       ");
            else if(s.charAt(i)=='L'||s.charAt(i)=='l')System.out.print("L         ");
            else if(s.charAt(i)=='M'||s.charAt(i)=='m')System.out.print("M  M M  M ");
            else if(s.charAt(i)=='N'||s.charAt(i)=='n')System.out.print("N   N   N ");
            else if(s.charAt(i)=='O'||s.charAt(i)=='o')System.out.print("O       O ");
            else if(s.charAt(i)=='P'||s.charAt(i)=='p')System.out.print("P P P P P ");
            else if(s.charAt(i)=='Q'||s.charAt(i)=='q')System.out.print("Q       Q ");
            else if(s.charAt(i)=='R'||s.charAt(i)=='r')System.out.print("R R R R R ");
            else if(s.charAt(i)=='S'||s.charAt(i)=='s')System.out.print("S S S S S ");
            else if(s.charAt(i)=='T'||s.charAt(i)=='t')System.out.print("    T     ");
            else if(s.charAt(i)=='U'||s.charAt(i)=='u')System.out.print("U       U ");
            else if(s.charAt(i)=='V'||s.charAt(i)=='v')System.out.print("  V   V   ");
            else if(s.charAt(i)=='W'||s.charAt(i)=='w')System.out.print("W   W   W ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("    X     ");
            else if(s.charAt(i)=='Y'||s.charAt(i)=='y')System.out.print("    Y     ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("    Z     ");
            else if(s.charAt(i)=='1')System.out.print("  1  ");
            else if(s.charAt(i)=='2')System.out.print("     2   ");
            else if(s.charAt(i)=='3')System.out.print("   3 3 ");
            else if(s.charAt(i)=='4')System.out.print("  4   4  ");
            else if(s.charAt(i)=='5')System.out.print("5 5 5 5  ");
            else if(s.charAt(i)=='6')System.out.print("6 6 6 6 ");
            else if(s.charAt(i)=='7')System.out.print("      7  ");
            else if(s.charAt(i)=='8')System.out.print("  8 8 8  ");
            else if(s.charAt(i)=='9')System.out.print("  9 9 9 9");
            else if(s.charAt(i)=='0')System.out.print("0       0");
            else if(s.charAt(i)=='.')System.out.print("    ");
            else if(s.charAt(i)==')')System.out.print("   )");
            else if(s.charAt(i)=='!')System.out.print(" |");
            else if(s.charAt(i)=='/')System.out.print("    *     ");
            else if(s.charAt(i)==' '||s.charAt(i)==' ')System.out.print("        ");
            System.out.print("   ");
        }
        System.out.println();

        //444444444444444444444

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='A'||s.charAt(i)=='a')System.out.print("A       A ");
            else if(s.charAt(i)=='B'||s.charAt(i)=='b')System.out.print("B      B  ");
            else if(s.charAt(i)=='C'||s.charAt(i)=='c')System.out.print("C         ");
            else if(s.charAt(i)=='D'||s.charAt(i)=='d')System.out.print("D       D ");
            else if(s.charAt(i)=='E'||s.charAt(i)=='e')System.out.print("E         ");
            else if(s.charAt(i)=='F'||s.charAt(i)=='f')System.out.print("F         ");
            else if(s.charAt(i)=='G'||s.charAt(i)=='g')System.out.print("G       G ");
            else if(s.charAt(i)=='H'||s.charAt(i)=='h')System.out.print("H       H ");
            else if(s.charAt(i)=='I'||s.charAt(i)=='i')System.out.print("    I     ");
            else if(s.charAt(i)=='J'||s.charAt(i)=='j')System.out.print("J   J     ");
            else if(s.charAt(i)=='K'||s.charAt(i)=='k')System.out.print("K    K    ");
            else if(s.charAt(i)=='L'||s.charAt(i)=='l')System.out.print("L         ");
            else if(s.charAt(i)=='M'||s.charAt(i)=='m')System.out.print("M   M   M ");
            else if(s.charAt(i)=='N'||s.charAt(i)=='n')System.out.print("N     N N ");
            else if(s.charAt(i)=='O'||s.charAt(i)=='o')System.out.print("O       O ");
            else if(s.charAt(i)=='P'||s.charAt(i)=='p')System.out.print("P         ");
            else if(s.charAt(i)=='Q'||s.charAt(i)=='q')System.out.print("Q     Q Q ");
            else if(s.charAt(i)=='R'||s.charAt(i)=='r')System.out.print("R    R    ");
            else if(s.charAt(i)=='S'||s.charAt(i)=='s')System.out.print("        S ");
            else if(s.charAt(i)=='T'||s.charAt(i)=='t')System.out.print("    T     ");
            else if(s.charAt(i)=='U'||s.charAt(i)=='u')System.out.print("U       U ");
            else if(s.charAt(i)=='V'||s.charAt(i)=='v')System.out.print("   V V    ");
            else if(s.charAt(i)=='W'||s.charAt(i)=='w')System.out.print("W   W   W ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("  X   X   ");
            else if(s.charAt(i)=='Y'||s.charAt(i)=='y')System.out.print("    Y     ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("  Z       ");
            else if(s.charAt(i)=='1')System.out.print("  1  ");
            else if(s.charAt(i)=='2')System.out.print("  2      ");
            else if(s.charAt(i)=='3')System.out.print("      3");
            else if(s.charAt(i)=='4')System.out.print("4 4 4 4 4");
            else if(s.charAt(i)=='5')System.out.print("       5 ");
            else if(s.charAt(i)=='6')System.out.print("6      6");
            else if(s.charAt(i)=='7')System.out.print("     7   ");
            else if(s.charAt(i)=='8')System.out.print("8       8");
            else if(s.charAt(i)=='9')System.out.print("       9 ");
            else if(s.charAt(i)=='0')System.out.print("0       0");
            else if(s.charAt(i)=='.')System.out.print("* * ");
            else if(s.charAt(i)==')')System.out.print("  ) ");
            else if(s.charAt(i)=='!')System.out.print(" |");
            else if(s.charAt(i)=='/')System.out.print("  *       ");
            else if(s.charAt(i)==' '||s.charAt(i)==' ')System.out.print("        ");
            System.out.print("   ");
        }
        System.out.println();

        //555555555555555555555555555555

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='A'||s.charAt(i)=='a')System.out.print("A       A ");
            else if(s.charAt(i)=='B'||s.charAt(i)=='b')System.out.print("B B B B   ");
            else if(s.charAt(i)=='C'||s.charAt(i)=='c')System.out.print("  C C C C ");
            else if(s.charAt(i)=='D'||s.charAt(i)=='d')System.out.print("D D D D   ");
            else if(s.charAt(i)=='E'||s.charAt(i)=='e')System.out.print("E E E E E ");
            else if(s.charAt(i)=='F'||s.charAt(i)=='f')System.out.print("F         ");
            else if(s.charAt(i)=='G'||s.charAt(i)=='g')System.out.print("  G G G G ");
            else if(s.charAt(i)=='H'||s.charAt(i)=='h')System.out.print("H       H ");
            else if(s.charAt(i)=='I'||s.charAt(i)=='i')System.out.print("I I I I I ");
            else if(s.charAt(i)=='J'||s.charAt(i)=='j')System.out.print("  J       ");
            else if(s.charAt(i)=='K'||s.charAt(i)=='k')System.out.print("K       K ");
            else if(s.charAt(i)=='L'||s.charAt(i)=='l')System.out.print("L L L L L ");
            else if(s.charAt(i)=='M'||s.charAt(i)=='m')System.out.print("M       M ");
            else if(s.charAt(i)=='N'||s.charAt(i)=='n')System.out.print("N       N ");
            else if(s.charAt(i)=='O'||s.charAt(i)=='o')System.out.print("O O O O O ");
            else if(s.charAt(i)=='P'||s.charAt(i)=='p')System.out.print("P         ");
            else if(s.charAt(i)=='Q'||s.charAt(i)=='q')System.out.print("  Q Q Q QQ");
            else if(s.charAt(i)=='R'||s.charAt(i)=='r')System.out.print("R       R ");
            else if(s.charAt(i)=='S'||s.charAt(i)=='s')System.out.print("S S S S S ");
            else if(s.charAt(i)=='T'||s.charAt(i)=='t')System.out.print("    T     ");
            else if(s.charAt(i)=='U'||s.charAt(i)=='u')System.out.print("  U U U   ");
            else if(s.charAt(i)=='V'||s.charAt(i)=='v')System.out.print("    V     ");
            else if(s.charAt(i)=='W'||s.charAt(i)=='w')System.out.print("W W W W W ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("X       X ");
            else if(s.charAt(i)=='Y'||s.charAt(i)=='y')System.out.print("    Y     ");
            else if(s.charAt(i)=='X'||s.charAt(i)=='x')System.out.print("Z Z Z Z Z ");
            else if(s.charAt(i)=='1')System.out.print("1 1 1");
            else if(s.charAt(i)=='2')System.out.print("2 2 2 2 2");
            else if(s.charAt(i)=='3')System.out.print("3 3 3  ");
            else if(s.charAt(i)=='4')System.out.print("      4  ");
            else if(s.charAt(i)=='5')System.out.print("5 5 5 5  ");
            else if(s.charAt(i)=='6')System.out.print(" 6 6 6  ");
            else if(s.charAt(i)=='7')System.out.print("    7    ");
            else if(s.charAt(i)=='8')System.out.print("  8 8 8  ");
            else if(s.charAt(i)=='9')System.out.print(" 9 9 9   ");
            else if(s.charAt(i)=='0')System.out.print(" 0 0 0 0 ");
            else if(s.charAt(i)=='.')System.out.print("* * ");
            else if(s.charAt(i)==')')System.out.print(")   ");
            else if(s.charAt(i)=='!')System.out.print(" *");
            else if(s.charAt(i)=='/')System.out.print("*         ");
            else if(s.charAt(i)==' '||s.charAt(i)==' ')System.out.print("        ");
            System.out.print("   ");
        }
        System.out.println();
    }
}