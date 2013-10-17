package app.model;

public class Campo {
    private long id;
    private String descripcion;
    private int estado;
    private int tipo;
    private double costo_Hora;
    private Local local;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getCosto_Hora() {
        return costo_Hora;
    }

    public void setCosto_Hora(double costo_Hora) {
        this.costo_Hora = costo_Hora;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    
}