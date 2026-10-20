public class Buzon {
    private String mensaje = null;

    public synchronized void escribir (String e) throws InterruptedException{
            while(mensaje != null){
                System.out.println("Escritor está esperando el buzón lleno");
                wait();
            }
            mensaje = e;
            System.out.println("Escritor escribió " + e);
            notifyAll();
    }


    public synchronized String leer () throws InterruptedException{
        while (mensaje == null){
            System.out.println(Thread.currentThread().getName() + " Lector esperando...");
            wait();
        }

        String l = mensaje;
        mensaje = null;
        System.out.println(Thread.currentThread().getName() + " leyó " + l);
        notifyAll();
        return l;
    }

}
