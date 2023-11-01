package org;

import today.edu.MyAppT;

import java.util.Scanner;

public class Main {
    static MyAppT o = new MyAppT();
    static boolean cm=true;
    static boolean cm2=true;

    public static void main(String[] args) {
        System.out.println("The menu of our programme like that:-");
        System.out.println("1:sign up to make a new account");
        System.out.println("2:log in to your previous account");
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        if (n == 1) {
            System.out.println("In order to make a new account you have to enter your information");
            System.out.println("Please enter your Gmail");
            String s1;
            s1 = input.next();
            System.out.println("Please enter your password");
            String s2;
            s2 = input.next();
            System.out.println("Please enter your BirthDate");
            String s3;
            s3=input.next();
            o.adding(s1, s2, s3);
        }
        if (n == 2) {
            System.out.println("Enter the Gmail for your account");
            String s1;
            s1 = input.next();
            System.out.println("Enter the password for your account");
            String s2;
            s2 = input.next();
            int v = o.exf(s1, s2);
            if (s1.equals("-"))
                System.out.println("You have to write your name cant be empty");
            else if (s2.equals("-"))
                System.out.println("You have to write your password cant be empty");
            else if (v == 0)
                System.out.println("There's something wrong there's no account with this information");
            else
            {
                System.out.println("you have logged successfully");
                System.out.println("Now in order to see your permissions you have to enter the specific id for your position");
                int m=input.nextInt();
                if(m==1) {
                    System.out.println("This ID means that you are the ADMIN so your permissions like that:-");
                    while (cm)
                    {
                        System.out.println("1:-You can manage user account");
                        System.out.println("2:-You can manage the products in the company");
                        int hjk=input.nextInt();
                        if(hjk==1)
                        {
                            System.out.println("1:- Change information for previous users");
                            System.out.println("2:- adding new user");
                            System.out.println("3:- See all user accounts");
                            int koiut = input.nextInt();
                            if(koiut==1)
                            {
                                System.out.println("You can change the password for account by giving its gmail");
                                String mg=input.next();
                                System.out.println("Write the new password for the email");
                                String npp=input.next();
                                int f=o.changeInfo(mg,npp);
                                if(f==0)
                                {
                                    System.out.println("No account founded with this gmail");
                                }
                                else {
                                    System.out.println("Password has changed in successfully way");
                                    System.out.println("Do you want to do anther thing ??!");
                                    cm=o.corn();
                                }
                            }
                            else if(koiut==2)
                            {
                                cm=true;
                                System.out.println("Please enter the Gmail for the account that you want to creat it ");
                                String s111;
                                s111 = input.next();
                                System.out.println("Please enter the password for the account that you want to creat it ");
                                String s211;
                                s211 = input.next();
                                System.out.println("Please enter the BirthDate for the user that you want to make account for him");
                                String s333;
                                s333=input.next();
                                o.adding(s111, s211, s333);
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            }
                            else if(koiut==3)
                            {
                                o.seeUser();
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            }
                            else
                            {
                                System.out.println("Sorry no choice as that ...");
                                System.out.println("Please repeat the process again... ");
                            }
                        }
                        else if(hjk==2) {
                            System.out.println("1:- Add a new product .");
                            System.out.println("2:- Make a list for all the products in the company .");
                            System.out.println("3:- Search on a product by entering it's name .");
                            System.out.println("4:- Search on a product by entering it's category .");
                            System.out.println("5:- Search on a product by entering it's price .");
                            int k = input.nextInt();
                            if (k == 1) {
                                System.out.println("Enter the name of the product that you want to add");
                                String name = input.next();
                                System.out.println("Enter the category's name that your product belong to");
                                String category = input.next();
                                System.out.println("Enter the price of the product that you want to add");
                                int y = input.nextInt();
                                System.out.println("Enter how many pieces from this product you want to add");
                                int a = input.nextInt();
                                System.out.println("write a discribtion about the product that you want to add");
                                String de = input.next();
                                o.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(name, category, y, a, de);
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            } else if (k == 2) {
                                cm = true;
                                o.listting();
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            } else if (k == 3) {
                                cm = true;
                                System.out.println("Write the name of the product that you are searching on it??!");
                                String name = input.next();
                                o.iRequestInformationAboutSpecificProductByEnteringItsName(name);
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            } else if (k == 4) {
                                cm = true;
                                System.out.println("Write the category that your product that you are searching on it belong to it??!");
                                String name = input.next();
                                o.iRequestInformationAboutSpecificProductByEnteringItsName2(name);
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            } else if (k == 5) {
                                cm = true;
                                System.out.println("Write the price for the product that you are searching on");
                                int kkk = input.nextInt();
                                int j=o.iRequestInformationAboutSpecificProductByEnteringItsName22(kkk);
                                System.out.println("Do you want to do anther thing ??!");
                                cm=o.corn();
                            }
                            else {
                                System.out.println("Sorry no choice as that ...");
                                System.out.println("Please repeat the process again... ");
                            }
                        }
                        else {
                            System.out.println("Sorry no choice as that ...");
                            System.out.println("Please repeat the process again... ");
                        }
                    }
                }
                else if (m==2)
                {
                    System.out.println("This ID means that you are the INSTALLER so your permissions like that:-");
                }
                else if(m==3)
                {
                    while(cm2) {
                        System.out.println("This ID means that you are the CUSTOMER so your permissions like that:-");
                        System.out.println("you could buy a product so if you want please enter these information");
                        System.out.println("Please enter the name of the product that you want to buy it");
                        String h = input.next();
                        System.out.println("write the date for buying this product");
                        String klj = input.next();
                        System.out.println("Write the number of peaces that you want to buy it from this product");
                        String fff = input.next();
                        int cv = Integer.parseInt(fff);
                        o.buying(h, klj, cv);
                        System.out.println("Do you want to repeat this process ??!");
                        cm2=o.corn();
                    }
                }
                else
                {
                    System.out.println("There's something wrong no number like that");
                }
            }
        }
    }
}
