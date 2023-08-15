package formas;

public class Retangulo extends Forma {
    private double altura;
    private double largura;
    
    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double area() {
        return altura * largura;
    }

    @Override
    public double perimetro() {
        return 2 * (altura + largura);
    }
}