package Graphs.topologicalSort;

import java.sql.Array;
import java.util.*;

public class CompilationOrer {
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> sortedOrder = new ArrayList<>();
        // Step 1:- Initiliae graph and inDegree Map
        HashMap<Character,Integer> inDegree=new HashMap<>();
        HashMap<Character,List<Character>> graph=new HashMap<>();

        for(int x=0;x<dependencies.size();x++){
            char parent=dependencies.get(x).get(0);
            char child=dependencies.get(x).get(1);
            graph.put(parent,new ArrayList<>());
            graph.put(child,new ArrayList<>());
            inDegree.put(parent,0);
            inDegree.put(child,0);
        }

        //Step 2 Build the Graph
        for(int j=0;j<dependencies.size();j++){
            char parent =dependencies.get(j).get(1);
            char child =dependencies.get(j).get(0);
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);
        }

        //Step 3 is find all the sources and add them in queue
        Queue<Character> source=new LinkedList<>();
        for(Map.Entry<Character,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0){
                source.add(entry.getKey());
            }
        }

        //Step 4 , read source, take its children and reduce inDegree value for the child , if child in degree becomes 0 hen it is a source so add it in the Queue
        while(!source.isEmpty()){
            char vertex=source.poll();
            sortedOrder.add(vertex);
            for(int child=0;child<graph.get(vertex).size();child++){
                inDegree.put(graph.get(vertex).get(child),inDegree.get(graph.get(vertex).get(child))-1);
                if(inDegree.get(graph.get(vertex).get(child)) ==0) {
                    source.add(graph.get(vertex).get(child));
                }
            }
        }

        //Step 5 In case graph has cycle
        if(sortedOrder.size()!=graph.size()){
            return new ArrayList<>();
        }
       return sortedOrder;
    }
        public static void main(String[] args) {
        List<List<List<Character>>> inputs = Arrays.asList(
                Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B')),
                Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'B'), Arrays.asList('E', 'B'), Arrays.asList('E', 'D'),Arrays.asList('E', 'C'), Arrays.asList('F', 'D'), Arrays.asList('F', 'E'), Arrays.asList('F', 'C')),
                Arrays.asList(Arrays.asList('A', 'B'), Arrays.asList('B', 'A')),
                Arrays.asList(Arrays.asList('B', 'C'), Arrays.asList('C', 'A'), Arrays.asList('A', 'F')),
                Arrays.asList(Arrays.asList('C', 'C'))
        );
        ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>();
        for(int j = 0; j < inputs.size(); j++)
        {
            dependencies.add(new ArrayList<ArrayList<Character>>());
            for(int k = 0; k < inputs.get(j).size(); k++)
            {
                dependencies.get(j).add(new ArrayList<Character>());
                for(int g = 0; g < inputs.get(j).get(k).size(); g++)
                {
                    dependencies.get(j).get(k).add(inputs.get(j).get(k).get(g));
                }
            }
        }
        for(int i = 0; i < dependencies.size(); i++){
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
