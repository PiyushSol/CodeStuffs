public class ComplexMai {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2,4);
        ComplexNumber c2 = new ComplexNumber(-1,3);
        ComplexNumber res ;
        res = c1.add(c2);
        System.out.println(res);
    }
}
