import java.util.*;

/** Busca A*: ordena a fronteira por f(n) = g(n) + h(n). */
public class AEstrela extends Busca {
    public AEstrela(Vertice objetivo) { super(objetivo); }

    @Override
    public Resultado busca(Vertice origem) {
        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt((No n) -> n.g + n.h));
        Map<Vertice, Integer> melhorG = new HashMap<>();
        Set<Vertice> expandidos = new HashSet<>();
        List<String> ordem = new ArrayList<>();
        fronteira.add(new No(origem, null, 0));
        melhorG.put(origem, 0);
        int gerados = 1;

        while (!fronteira.isEmpty()) {
            No atual = fronteira.poll();
            if (expandidos.contains(atual.vertice)) continue;
            expandidos.add(atual.vertice);
            ordem.add(atual.vertice.getRotulo());
            if (ehObjetivo(atual.vertice)) return monta("A*", atual, ordem, gerados);

            for (Adjacente adj : atual.vertice.getAdjacentes()) {
                Vertice v = adj.getVertice();
                int novoG = atual.g + adj.getCusto();
                if (!expandidos.contains(v) && (!melhorG.containsKey(v) || novoG < melhorG.get(v))) {
                    melhorG.put(v, novoG);
                    fronteira.add(new No(v, atual, novoG));
                    gerados++;
                }
            }
        }
        return monta("A*", null, ordem, gerados);
    }
}
