public class HiloEscritor extends Thread{
    private Buzon b;
    private String nombre;

    public HiloEscritor(Buzon b, String nombre){
        this.b = b;
        this.nombre = nombre;
    }

    @Override
    public void run(){
        for(int i = 1; i <= 3; i++){
            try {
                b.escribir("Mensaje " + i + " de " + nombre);
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
