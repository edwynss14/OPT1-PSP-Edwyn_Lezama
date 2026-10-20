
public class Main {
    public static void main(String[] args){
        Buzon buzon = new Buzon();

        HiloEscritor escritor1 = new HiloEscritor(buzon, "Escritor 1");
        HiloEscritor escritor2 = new HiloEscritor(buzon, "Escritor 2");

        HiloLector lector1 = new HiloLector(buzon, "Lector 1");
        HiloLector lector2 = new HiloLector(buzon, "Lector 2");

        escritor1.start();
        escritor2.start();
        lector1.start();
        lector2.start();

        try {
            escritor1.join();
            escritor2.join();
            lector1.join();
            lector2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}