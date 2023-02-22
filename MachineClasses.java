import java.util.Scanner;
import java.util.*;//java.util.Arrays
import java.lang.*;
import java.io.*;

class A4p1{
  public static final Scanner input = new Scanner(System.in);
Person SetPerson(Person Assigned){
Person p1 = new Person();
System.out.print("Name: ");
p1.name = input.nextLine();
System.out.print("Sex('F' or 'M'): ");
p1.sex = input.next().trim().charAt(0);
input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
System.out.print("Age: ");
p1.age = Integer.parseInt(input.nextLine());
System.out.print("Singer or Dancer('S' or 'D'): ");
p1.ArtType = input.next().charAt(0);
input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


return p1;
}

Person SetRank(Person Assigned){
  if (Assigned.ArtType == 'D')
    {
      System.out.print ("ADA rank(1,2, or 3): ");
      Assigned.rank = Integer.parseInt(input.nextLine());
      System.out.println ("");
    }
    if (Assigned.ArtType == 'S')
      {
        System.out.print ("ASA rank(1,2, or 3): ");
        Assigned.rank = Integer.parseInt(input.nextLine());
        System.out.println ("");
      }

return Assigned;
}


void SetPeople(String [] comargs) {
System.out.println("How many persons do you want to input? ");
int num = Integer.parseInt(input.nextLine());
Person[] people = new Person[num];
String[] favorite = new String[num];
Person Entered = new Person();
Fav[] Favorite = new Fav[num];
Dancer a = new Dancer(Entered);
Singer b = new Singer(Entered);
for (int i = 0; i < num; i++)
    {
        System.out.println("Enter information for person " + (i +1) +":");
        Entered = SetPerson(Entered);
        if (Entered.ArtType == 'S')
        {
        b = b.SetSinger(Entered);
        System.out.print("Favorite song: ");
        b.FavoriteS = input.nextLine();
        Favorite[i] = new Fav(b);
        }
        if (Entered.ArtType == 'D')
        {
        a = a.SetDancer(Entered);
        System.out.print("Favorite dance: ");
        a.FavoriteD = input.nextLine();
        Favorite[i] = new Fav(a);
        }
        Entered = SetRank(Entered);
        people[i] = Entered;

    }
 System.out.println ("The persons you entered are:");
for (int i = 0; i < num; i++)
{
    System.out.print(people[i].name +" is" );
    if (people[i].sex == 'M')
    {
        System.out.print(" male");
    }
    if (people[i].sex == 'F')
    {
        System.out.print(" female");
    }
    System.out.print(" and is " + people[i].age + " years old and is an");
    if (people[i].ArtType == 'S')
    {
        System.out.println(" ASA rank " + people[i].rank + " singer with favorite song " + Favorite[i].PersFav + ".");
    }
    if (people[i].ArtType == 'D')
    {
        System.out.println(" ADA rank " + people[i].rank + " dancer with favorite dance " + Favorite[i].PersFav + ".");
    }
}


System.out.println ("");
Arrays.sort(people, new AgeComparator());
Arrays.sort(Favorite, new FavComparator());
System.out.println ("All the persons sorted by age are:");
for (int i = 0; i < num; i++)
{
    System.out.print(people[i].name +" is" );
    if (people[i].sex == 'M')
    {
        System.out.print(" male");
    }
    if (people[i].sex == 'F')
    {
        System.out.print(" female");
    }
    System.out.print(" and is " + people[i].age + " years old and is an");
    if (people[i].ArtType == 'S')
    {
        System.out.println(" ASA rank " + people[i].rank + " singer with favorite song " + Favorite[i].PersFav + ".");
    }
    if (people[i].ArtType == 'D')
    {
        System.out.println(" ADA rank " + people[i].rank + " dancer with favorite dance " + Favorite[i].PersFav + ".");
    }
}


}
public class Person{
String name;
char sex;
int age;
int rank;
char ArtType;

public int getAge() {
  return age;
}
}

class AgeComparator implements Comparator< Person > {
    public int compare(Person a, Person b) {
        return a.getAge() - b.getAge();
    }
}

class FavComparator implements Comparator< Fav > {
    public int compare(Fav a, Fav b) {
        return a.getAge() - b.getAge();
    }
}
public class Singer extends Person
{
String FavoriteS;
public Singer(Person p1)
{
this.name = p1.name;
this.sex = p1.sex;
this.age = p1.age;
this.rank = p1.rank;
this.ArtType = p1.ArtType;
}

Singer SetSinger(Person p1)
{
 Singer S = new Singer(p1);
 return S;
}

}

public class Dancer extends Person
{
String FavoriteD;
public Dancer(Person p1)
{
this.name = p1.name;
this.sex = p1.sex;
this.age = p1.age;
this.rank = p1.rank;
this.ArtType = p1.ArtType;
}

Dancer SetDancer(Person p1)
{
Dancer D = new Dancer(p1);
 return D;
}
}

public class Fav{
String PersFav;
int Age;

public Fav(Singer p1)
{
this.PersFav = p1.FavoriteS;
this.Age = p1.age;
}

public Fav (Dancer p1)
{
  this.PersFav = p1.FavoriteD;
  this.Age = p1.age;
}

public int getAge() {
  return Age;
}
}



public static void main(String[] args){
A4p1 a = new A4p1();
a.SetPeople(args);
input.close();

}
}
