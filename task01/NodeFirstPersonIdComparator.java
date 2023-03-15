import java.util.Comparator;

/**
 * сортировка ветвей дерева по id первой персоны
 */
public class NodeFirstPersonIdComparator implements Comparator<Node>{
           @Override
        public int compare(Node o1, Node o2){
        return (o1.getP1().getId() - o2.getP1().getId());}
}
