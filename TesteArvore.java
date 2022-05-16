public class TesteArvore {
    public static void main(String[] args) {
        
            Tree t = new Tree();
            
            No raiz = new No(4);
            t.setRoot(raiz);

            t.insert(t.getRoot() , 1 );
            t.insert(t.getRoot() , 7 );
            t.insert(t.getRoot() , 5 );
            t.insert(t.getRoot() , 8 );
            t.insert(t.getRoot() , 9 );
            t.insert(t.getRoot() , 3 );
            t.insert(t.getRoot() , 2 );
            t.insert(t.getRoot() , 10 );
            
            System.out.println("\n Pre Ordem");
            t.preOrder(t.getRoot());
            
            System.out.println("\n Em Ordem"); 
            t.inOrder(t.getRoot());
            
            System.out.println("\n Pos Ordem");
            t.posOrder(t.getRoot());
    }
}
