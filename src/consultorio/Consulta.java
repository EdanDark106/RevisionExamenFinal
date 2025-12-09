package consultorio;

import java.io.*;

public class Consulta {
    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed;
    private int dia;
    private String mes;
    private int anio;

    public Consulta() {}

    public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public void alta() {
        String ruta = "archivosConsultas/Consulta" + ci + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(ci + "\n");
            bw.write(nombrePaciente + "\n");
            bw.write(apellidoPaciente + "\n");
            bw.write(idMed + "\n");
            bw.write(dia + "\n");
            bw.write(mes + "\n");
            bw.write(anio + "");
            System.out.println("Consulta CI=" + ci + " dada de alta.");
        } catch (Exception e) {
            System.out.println("Error alta consulta: " + e);
        }
    }

    public void cargar(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            ci = Integer.parseInt(br.readLine());
            nombrePaciente = br.readLine();
            apellidoPaciente = br.readLine();
            idMed = Integer.parseInt(br.readLine());
            dia = Integer.parseInt(br.readLine());
            mes = br.readLine();
            anio = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Error carga consulta: " + e);
        }
    }

    public void baja() {
        String ruta = "archivosConsultas/Consulta" + ci + ".txt";
        new File(ruta).delete();
    }

    public void cambiarDia(int nuevoDia) {
        this.dia = nuevoDia;
        baja();  
        alta();  
        System.out.println("Consulta CI=" + ci + " cambió al día " + nuevoDia);
    }

    public int getCi() { return ci; }
    public int getIdMed() { return idMed; }
    public int getDia() { return dia; }
    public String getMes() { return mes; }
    public int getAnio() { return anio; }
    public String getNombrePaciente() { return nombrePaciente + " " + apellidoPaciente; }

    @Override
    public String toString() {
        return "Consulta{CI=" + ci + ", Paciente=" + nombrePaciente + " " + apellidoPaciente +
               ", MédicoID=" + idMed + ", Fecha=" + dia + "/" + mes + "/" + anio + "}";
    }
}