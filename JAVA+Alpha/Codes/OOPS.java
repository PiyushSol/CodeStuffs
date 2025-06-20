// 4 Pillars of OOPs are 
// 1. Encapsulation 2. Inheritance 3. Abstraction 4. Polymorphism

public class OOPS{
public static void main(String[] args) {
    // Pen p1 = new Pen();
    // p1.setColor("blue");
    // p1.setTip(1);
    // System.out.println(p1.getColor());
    // System.out.println(p1.getTip());
    // BankAccount b= new BankAccount();
    // b.username="Piyush";
    // b.setPassword("Salman Kahn");
    // Student s1 = new Student("Piyush");
    // System.out.println(s1.name);
    // Student s1 = new Student();
    // s1.name="Piyush";
    // s1.roll=123;
    // s1.password="1223";
    // Student s2 = new Student(s1);
    // s2.password="Salman";
    // System.out.println(s1 == s2);
    // Fish shark = new Fish();
    // shark.eat();
    // Dogs doggy = new Dogs();
    // doggy.eat();
    // doggy.legs=4;
    // System.out.println(doggy.legs);
    // Calculator calc= new Calculator();
    // System.out.println(calc.sum(1,2));
    // System.out.println(calc.sum(1.5f,2.5f));
    // System.out.println(calc.sum(1,2,3));
//  Deer d = new Deer();
//  d.eat();
    // Horse h = new Horse();
    // h.eat();
    // h.walk();
    // System.out.println(h.color);
    // Chicken c = new Chicken();
    // c.eat();
    // c.walk();
    // Animal  a = new Horse();
    // a.eat();
    // a.walk();
    // Queen q = new Queen();
    // q.moves();
    // Student s1 = new Student();
    // s1.schoolName = "BSMS";
    // Student s2 = new Student();
    // System.out.println(s2.schoolName);

    // Student s3 = new Student();
    // s3.schoolName="HGI";
    // System.out.println(s1.schoolName);

}
}



// class Student{
//     String name;
//     int roll;
//     static int returnPercentage(int math , int phy,int chem){
//         return (math+phy+chem)/3;
//     }

//     static String schoolName;

//     void setName(String name){
//         this.name = name;
//     }

//     String getName(){
//         return this.name;
//     }
// }

//  interfaces
// interface ChessPlayer{
//     void moves();
// } 

// class Queen implements ChessPlayer{
//   public  void moves(){
//         System.out.println("up, down , left , right, diagonal (in all 4 directions)");
//     }

// }

// class Rook implements ChessPlayer{
//     public  void moves(){
//           System.out.println("up, down , left , right");
//       }
//   }

  
// class King implements ChessPlayer{
//     public  void moves(){
//           System.out.println("up, down , left , right , diagonal by 1 step");
//       }
//   }

//Abstraction
// abstract class Animal{
//     String color;
//     Animal(){
//         color="brown";
//     }

//     void eat(){
//         System.out.println("Animal eats");
//     }

//     abstract  void walk();
// }

// class Horse extends Animal{
//     void walk(){
//         System.out.println("Walks on 4 legs");
//     }

//     void changeColor(){
//         color="dark brown";
//     }
// }

// class Chicken extends Animal{
//     void walk(){
//         System.out.println("Walks on 2 legs");
//     }

//     void changeColor(){
//         color="yellow";
//     }
// }


//Polymorphism
// class Animal{
//     void eat(){
//         System.out.println("eats anything");
//     }
// }


// class Deer extends Animal{
//     void eat(){
//         System.out.println("eats grass");
//     }
// }


// class Calculator{
//     int sum(int a ,int b){
//         return a+b;
//     }

//     float sum(float a, float b){
//         return a+b;
//     }

//     int sum(int a , int b, int c){
//         return a+b+c;
//     }
// }

//Base class
// class Animal{
//     String color;

//     void eat(){
//         System.out.println("eats");
//     }
//     void breathe(){
//         System.out.println("breathes");
//     }
// }

// class Mammals extends  Animal{
//     int legs;
// }

// class Dogs extends Mammals{
//     String breed;
// }

//derived class or subclass
// class Fish extends Animal{
//       int fins;

//       void swim(){
//         System.out.println("Swims in water!");
//       }
// }



// class Student{
//     String name;
//     int roll;
//     String password;

//      Student() {
//     }

//     Student(Student s1){
//         this.name = name;
//         this.roll = roll;
//         // this.password=password;
//     }

//     Student(String name) {
//         this.name =name;
//         System.out.println("Constructor is called");
//     }

// }

// class Pen{
//    private  String color;
//    private  int tip;
    
//     void setColor(String newcolor){
//         color = newcolor;
//     }

//     void setTip(int newTip){
//         tip=newTip;
//     }

//     String getColor(){
//         return this.color;
//     }

//     int getTip(){
//         return this.tip;
//     }
// }

// class BankAccount{
//     public String username;
//     private String password;

//      void setPassword(String pwd){
//         password =pwd;
//     }
// }

// class Student{
//     String name;
//     int age;
//     float cgpa;


//     Student(){

//     }

//     public Student(String name, int age, float cgpa) {
//         this.name = name;
//         this.age = age;
//         this.cgpa = cgpa;
//     }
 
    
//     void calcPercentage(int phy , int chem , int math){
//         cgpa = (phy+chem+math)/3;
//     }
// }