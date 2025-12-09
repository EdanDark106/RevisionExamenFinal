package consultorio;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Medico {
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico() {}

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    // ALTA: guarda como JSON
    public void alta() {
        String ruta = "archivosMedicos/Medico" + idMed + ".json";
        Gson gson = new Gson();
        try (FileWriter w = new FileWriter(ruta)) {
            gson.toJson(this, w);
            System.out.println("Médico " + nombreMed + " " + apellidoMed + " dado de alta.");
        } catch (Exception e) {
            System.out.println("Error alta médico: " + e);
        }
    }

    // CARGA desde JSON
    public void cargar(String ruta) {
        Gson gson = new Gson();
        try (FileReader r = new FileReader(ruta)) {
            Medico temp = gson.fromJson(r, Medico.class);
            this.idMed = temp.idMed;
            this.nombreMed = temp.nombreMed;
            this.apellidoMed = temp.apellidoMed;
            this.aniosExperiencia = temp.aniosExperiencia;
        } catch (Exception e) {
            System.out.println("Error carga médico: " + e);
        }
    }

    // BAJA: elimina el archivo
    public void baja() {
        String ruta = "archivosMedicos/Medico" + idMed + ".json";
        File f = new File(ruta);
        if (f.delete()) {
            System.out.println("Médico eliminado: " + nombreMed + " " + apellidoMed);
        }
    }

    public int getIdMed() { return idMed; }
    public String getNombreMed() { return nombreMed; }
    public String getApellidoMed() { return apellidoMed; }

    @Override
    public String toString() {
        return "Médico{id=" + idMed + ", " + nombreMed + " " + apellidoMed + ", exp=" + aniosExperiencia + " años}";
    }
}