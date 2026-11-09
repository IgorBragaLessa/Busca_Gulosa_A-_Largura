public class No {
    public Vertice vertice;
    public No pai;
    public int g;      // custo real acumulado pela estrada
    public int h;      // heurística (distância em linha reta até Bucareste)

    public No(Vertice v, No pai, int g) {
        this.vertice = v;
        this.pai = pai;
        this.g = g;
        this.h = v.getDistanciaObjetivo();
    }
}
