package consultorio;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();

        consultorio.cargarDatosDePrueba();

        consultorio.mostrarTodo();

        // b) Dar de baja a medico y sus consultas
        System.out.println("\n--- DANDO DE BAJA A MARÍA GÓMEZ ---");
        consultorio.darDeBajaMedico("María", "Gómez");

        // c) Cambiar consultas del 25/12 y 1/1 al día 27 
        System.out.println("\n--- REPROGRAMANDO NAVIDAD Y AÑO NUEVO AL 27 ---");
        consultorio.cambiarConsultasFestivos(27);

        // d) Opcional: pacientes el día de tu cumple
        consultorio.pacientesEnMiCumple(20, "Mayo");

        consultorio.mostrarTodo();
    }
}