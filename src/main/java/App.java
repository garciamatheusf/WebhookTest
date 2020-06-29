import jersey.JerseyStart;

public class App {

    public static void main(String... args){
        try {
            System.out.println("Iniciando servidor local");
            JerseyStart.getInstance().start();
        } catch (Exception e) {
            System.out.println("Nao foi possivel iniciar o servidor. A aplicacao nao sera iniciada");
            System.exit(-1);
        }

        System.out.println("\r\n\r\n====================================================================");
        System.out.println("Servidor iniciado com sucesso, escutando porta 8080");
    }
}
