public class ComplexNumber {
    private int real;
    private int imag;

    ComplexNumber(){
        real =0;
        imag=0;
    }

    ComplexNumber(int real , int imag){
        setReal(real);
        setImag(imag);
    }

    public int getReal(){
        return this.real;
    }

    public int getImag(){
        return this.imag;
    }

    public void setReal(int real){
        this.real=real;
    }

    public void setImag(int imag){
        this.imag=imag;
    }

    //Adding two Complex numbers
    public ComplexNumber add(ComplexNumber c1){
        ComplexNumber result = new ComplexNumber(0,0);
        result.real =this.real+c1.real;
        result.imag=this.imag+c1.imag;
        return result;
    }

    //Subtract two Complex numbers
    public ComplexNumber subtract(ComplexNumber c1){
        ComplexNumber result = new ComplexNumber(0,0);
        result.real = this.real-c1.real;
        result.imag = this.imag-c1.imag;
        return result;
    }

    //Multiply two Complex Numbers
    public ComplexNumber multiply(ComplexNumber c1){
        ComplexNumber res= new ComplexNumber(0,0);
        res.real = (this.real*c1.real) -(this.imag*c1.imag);
        res.imag =(this.real*c1.imag)+(c1.real*this.imag);
        return res;
    }

    @Override
    public String toString(){
        return this.real+" i"+this.imag;
    }
}
