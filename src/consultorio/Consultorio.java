package consultorio;

import java.io.File;
import java.util.ArrayList;

public class Consultorio {
    private final String carpetaMedicos = "archivosMedicos";
    private final String carpetaConsultas = "archivosConsultas";

    public Consultorio() {
        new File(carpetaMedicos).mkdirs();
        new File(carpetaConsultas).mkdirs();
    }

    public ArrayList<Medico> cargarMedicos() {
        ArrayList<Medico> lista = new ArrayList<>();
        File[] archivos = new File(carpetaMedicos).listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                if (f.getName().endsWith(".json")) {
                    Medico m = new Medico();
                    m.cargar(f.getPath());
                    lista.add(m);
                }
            }
        }
        return lista;
    }

    public ArrayList<Consulta> cargarConsultas() {
        ArrayList<Consulta> lista = new ArrayList<>();
        File[] archivos = new File(carpetaConsultas).listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                if (f.getName().endsWith(".txt")) {
                    Consulta c = new Consulta();
                    c.cargar(f.getPath());
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    //a) Dar de alta 3 médicos y 9 consultas
    public void cargarDatosDePrueba() {
        
        new Medico(1, "Juan", "Pérez", 10).alta();
        new Medico(2, "María", "Gómez", 8).alta();
        new Medico(3, "Carlos", "López", 15).alta();

        new Consulta(11111111, "Ana", "Torres", 1, 25, "Diciembre", 2025).alta();
        new Consulta(22222222, "Luis", "Ramírez", 2, 1, "Enero", 2026).alta();
        new Consulta(33333333, "Pedro", "Sosa", 1, 15, "Mayo", 2025).alta();
        new Consulta(44444444, "Laura", "Vera", 3, 25, "Diciembre", 2025).alta();
        new Consulta(55555555, "José", "Mendoza", 2, 10, "Enero", 2026).alta();
        new Consulta(66666666, "Carla", "Ruiz", 1, 5, "Febrero", 2026).alta();
        new Consulta(77777777, "Miguel", "Díaz", 3, 20, "Marzo", 2026).alta();
        new Consulta(88888888, "Sofia", "Ortiz", 2, 1, "Enero", 2026).alta();
        new Consulta(99999999, "Elena", "Morales", 1, 12, "Abril", 2026).alta();
    }

    //Dar de baja médico + todas sus consultas
    public void darDeBajaMedico(String nombre, String apellido) {
        ArrayList<Medico> medicos = cargarMedicos();
        ArrayList<Consulta> consultas = cargarConsultas();

        boolean encontrado = false;
        for (Medico m : medicos) {
            if (m.getNombreMed().equalsIgnoreCase(nombre) && 
                m.getApellidoMed().equalsIgnoreCase(apellido)) {
                
                for (Consulta c : consultas) {
                    if (c.getIdMed() == m.getIdMed()) {
                        c.baja();
                    }
                }
               
                m.baja();
                encontrado = true;
                System.out.println("Médico " + nombre + " " + apellido + " y todas sus consultas eliminadas.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Médico no encontrado: " + nombre + " " + apellido);
        }
    }

    //Cambiar día de consultas en Navidad o Año Nuevo
    public void cambiarConsultasFestivos(int nuevoDia) {
        ArrayList<Consulta> consultas = cargarConsultas();
        for (Consulta c : consultas) {
            boolean esNavidad = c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre");
            boolean esAnioNuevo = c.getDia() == 1 && c.getMes().equalsIgnoreCase("Enero");

            if (esNavidad || esAnioNuevo) {
                c.cambiarDia(nuevoDia);
            }
        }
    }

    //d) pacientes de tu cumpleaños 
    public void pacientesEnMiCumple(int diaCumple, String mesCumple) {
        System.out.println("\n--- Pacientes atendidos el " + diaCumple + " de " + mesCumple + " ---");
        ArrayList<Consulta> consultas = cargarConsultas();
        boolean hay = false;
        for (Consulta c : consultas) {
            if (c.getDia() == diaCumple && c.getMes().equalsIgnoreCase(mesCumple)) {
                System.out.println(c.getNombrePaciente() + " (CI: " + c.getCi() + ")");
                hay = true;
            }
        }
        if (!hay) System.out.println("Ningún paciente ese día.");
    }

    public void mostrarTodo() {
        System.out.println("\n=== MÉDICOS ===");
        cargarMedicos().forEach(System.out::println);

        System.out.println("\n=== CONSULTAS ===");
        cargarConsultas().forEach(System.out::println);
    }
}