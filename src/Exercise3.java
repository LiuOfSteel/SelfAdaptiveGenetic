import java.io.IOException;
import java.util.LinkedList;

public class Exercise3 {
    static LinkedList<TSPsolution> newSolutionsSet = new LinkedList<>();    // list for offspring
    static LinkedList<TSPsolution> bestSolutionsSet = new LinkedList<>();   // list for parents
    static String fileName = "usa13509.tsp";    // test file name
    static double[][] initial1;
    static double[][] initial2;

    public static void main(String[] args) throws IOException {
        initial1 = Exercise1.getData(fileName);
        initial2 = Exercise1.getData(fileName);
        TSPsolution s1 = createSolution(initial1);
        TSPsolution s2 = createSolution(initial2);
        s1 = calculateDistance(s1);
        s2 = calculateDistance(s2);
        bestSolutionsSet.add(s1);
        bestSolutionsSet.add(s2);
        System.out.println(bestSolutionsSet.getFirst().totalDistance);
    }
    public static TSPsolution createSolution(double[][] s){
        TSPsolution t = new TSPsolution(s);
        return t;
    }

    public static TSPsolution calculateDistance(TSPsolution t){
        t.totalDistance = 0;
        for(int i = 0; i < t.order.length - 1; i++){
            t.totalDistance += Math.sqrt(Math.pow(t.order[i][1] - t.order[i+1][1],2) + Math.pow(t.order[i][2] - t.order[i+1][2],2));
        }
        return t;
    }

}
