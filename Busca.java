import java.util.*;

/** Classe base: reconstrói o caminho e monta o Resultado. */
public abstract class Busca {
    protected Vertice objetivo;

    public Busca(Vertice objetivo) { this.objetivo = objetivo; }

    public abstract Resultado busca(Vertice origem);

    protected boolean ehObjetivo(Vertice v) { return v == objetivo; }

    protected Resultado monta(String metodo, No fim, List<String> ordem, int gerados) {
        Resultado r = new Resultado();
        r.metodo = metodo;
        r.ordemExpansao = ordem;
        r.nosExpandidos = ordem.size();
        r.nosGerados = gerados;
        r.achou = fim != null;
        r.caminho = new ArrayList<>();
        if (fim != null) {
            r.custo = fim.g;
            for (No n = fim; n != null; n = n.pai) r.caminho.add(0, n.vertice.getRotulo());
        }
        return r;
    }
}
