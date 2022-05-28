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
            t.insert(t.getRoot() , 10);
            t.insert(t.getRoot() , 2 );
            
            System.out.print("Pre Ordem = ");
            t.preOrder(t.getRoot());
            System.out.println("\n");

            System.out.print("Em Ordem = "); 
            t.inOrder(t.getRoot());
            System.out.println("\n");
            
            System.out.print("Pos Ordem = ");
            t.posOrder(t.getRoot());
            System.out.println("\n");
    
            No target = t.search(t.getRoot() , 5);
            if(target != null) {
                System.out.println("Target = " + target.getValor());
            } else {
                System.out.println("Não encontrado");
            }

            No max = t.NoMax(t.getRoot());
            System.out.println("Max = " + max.getValor());

            No min = t.NoMin(t.getRoot());
            System.out.println("Min = " + min.getValor());

            int totalNos = t.totalNos(t.getRoot());
            System.out.println("Total de nós = " + totalNos);

            int totalFolhas = t.totalFolhas(t.getRoot());
            System.out.println("Total de folhas = " + totalFolhas);

            System.out.print("Folhas = ");
            t.identificarFolhas(t.getRoot());
            System.out.println("\n");
        
            int nivel = t.nivelNo(t.getRoot() , 10 , 0);
            System.out.println("Nivel = " + nivel);
        
            int altura = t.alturaNo(t.getRoot() , 5);
            System.out.println("Altura = " + altura);
        
        }
}
