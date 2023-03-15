import java.util.Comparator;

/**
 * сортировка ветвей дерева по id второй персоны
 */
public class NodeSecondPersonIdComparator implements Comparator<Node>{
           @Override
        public int compare(Node o1, Node o2){
        return (o1.getP2().getId() - o2.getP2().getId());}
}
