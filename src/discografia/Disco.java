package discografia;

public class Disco implements Comparable {
    
    private String titulo;
    private String artista;
    private int temas;
    private double duracion;

    public Disco(String titulo, String artista, int temas, double duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.temas = temas;
        this.duracion = duracion;
    }

    
    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }


    public int getTemas() {
        return temas;
    }

    public void setTemas(int temas) {
        this.temas = temas;
    }


    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista +" - "+temas+" - "+duracion;
    }

    // Método necesario para poder usar Collections.sort
    @Override
    public int compareTo(Object o) {
        Disco d = (Disco) o;
        return titulo.compareTo(d.getTitulo());
    }
    
    
}
