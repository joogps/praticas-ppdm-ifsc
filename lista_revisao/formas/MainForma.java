package formas;

public class MainForma {
    public static void main(String[] args) {
        Forma[] formas = new Forma[3];
        formas[0] = new Quadrado(5.0);
        formas[1] = new Retangulo(2.0, 3.0);
        formas[2] = new Circulo(10.0);

        for (Forma forma : formas) {
            System.out.println(forma);
            System.out.println("Área: " + forma.area());
            System.out.println("Perímetro: " + forma.perimetro());
        }
    }
}
