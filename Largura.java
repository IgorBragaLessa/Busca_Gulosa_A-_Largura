import java.util.*;

/** Busca em Largura: fila FIFO, ignora heurística; custo da estrada é acumulado apenas para reportar. */
public class Largura extends Busca {
    public Largura(Vertice objetivo) { super(objetivo); }

    @Override
    public Resultado busca(Vertice origem) {
        Queue<No> fila = new LinkedList<>();
        Set<Vertice> descobertos = new HashSet<>();
        List<String> ordem = new ArrayList<>();
        No inicio = new No(origem, null, 0);
        fila.add(inicio);
        descobertos.add(origem);
        int gerados = 1;

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            ordem.add(atual.vertice.getRotulo());
            if (ehObjetivo(atual.vertice)) return monta("Largura", atual, ordem, gerados);

            for (Adjacente adj : atual.vertice.getAdjacentes()) {
                if (descobertos.add(adj.getVertice())) {
                    fila.add(new No(adj.getVertice(), atual, atual.g + adj.getCusto()));
                    gerados++;
                }
            }
        }
        return monta("Largura", null, ordem, gerados);
    }
}
