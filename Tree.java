public class Tree {

    private No root;
    /**
     * @return the root
     */
    public No getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(No root) {
        this.root = root;
    }
    
    public Tree() {
        this.root = null;
    }
    
    public void inOrder(No atual) {
        if(atual != null) {
            inOrder(atual.getEsq());
            System.out.print(atual.getValor() + " ");
            inOrder(atual.getDir());
        }
    }
        
        public void preOrder(No atual) {
        if(atual != null) {
            System.out.print(atual.getValor() + " ");
            preOrder(atual.getEsq());
            preOrder(atual.getDir());
        }    
    }
        
    public void posOrder(No atual) {
        if(atual != null) {
            posOrder(atual.getEsq());
            posOrder(atual.getDir());
            System.out.print(atual.getValor() + " ");
        }    
    }

    public No insert(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.getValor()) {
            atual.setEsq(insert(atual.getEsq(), valor));
        } 
        
        else if (valor > atual.getValor()) {
            atual.setDir(insert(atual.getDir(), valor));
        } 
        
        else {
            return atual;
        }

        return atual;
    }

    public No search(No atual , int valor) {
        if(atual == null) {
            return atual;
        }

        else if(atual.getValor() == valor){
            return atual;
        }
   
        else if (valor < atual.getValor()) {
            return search(atual.getEsq() , valor);
        } 
        
        else if (valor > atual.getValor()) {
            return search(atual.getDir() , valor);
        }    

        return atual;
    }

    public No NoMax(No atual) {
    // Caso a árvore não esteja em regra binária basta colocar pra ele percorrer à esquerda tbm.

        if(atual != null) {
            No maximo = atual;
            No dir =  NoMax(atual.getDir());
            
            if(dir.getValor() > maximo.getValor())
                maximo = dir;
                return maximo;
            }

        return new No(Integer.MIN_VALUE);
    }

    public No NoMin(No atual) {
        // Caso a árvore não esteja em regra binária basta colocar pra ele percorrer à direita tbm.
        
        if(atual != null) {
            No minimo = atual;
            No esq = NoMin(atual.getEsq());
            
            if(esq.getValor() < minimo.getValor())
                minimo = esq;
                return minimo;
            }

        return new No(Integer.MAX_VALUE);
    }

    public int totalNos(No atual) {
        if(atual == null) {
            return 0;
        }

        return 1 + totalNos(atual.getEsq()) + totalNos(atual.getDir());
    }

    public int totalFolhas(No atual) {
        if(atual == null) {
            return 0;
        }
        
        if(atual.getEsq() == null && atual.getDir() == null) {
            return 1;
        } 

        return totalFolhas(atual.getEsq()) + totalFolhas(atual.getDir());
    }

    public void identificarFolhas(No atual) {
        
        if(atual != null)
        {
            if(atual.getEsq() == null && atual.getDir() == null) {
                System.out.print(atual.getValor() + " ");
            } else {
                identificarFolhas(atual.getEsq());
                identificarFolhas(atual.getDir());
            } 
        }
    }

    public int nivelNo(No atual , int target , int nivel) {

        if(atual == null){
            return -1;
        }

        if(atual.getValor() == target){
            return nivel;
        }

        int n = nivelNo(atual.getEsq() , target , nivel +1);

        if(n != -1){
            return n;
        }

        return nivelNo(atual.getDir() , target , nivel +1);
    }

    public int altura(No atual) {
          
        if(atual == null) {
            return -1;
        }

        int alturaEsq = altura(atual.getEsq());
        int alturaDir = altura(atual.getDir());

        if(alturaEsq > alturaDir) {
            return 1 + alturaEsq;
        } else {
            return 1 + alturaDir;
        }
         
    }

    public int alturaNo(No atual , int valor) {
        No target = search(atual , valor);
        if(target == null){
            return -1;
        } else {
            return altura(target);
        }
    
    }

    public No deleteNo(No atual , int valor) {
        if(atual == null) {
            return atual;
        }

        else if(valor < atual.getValor()){
            atual.setEsq(deleteNo(atual.getEsq(), valor));
        }
    
        else if(valor > atual.getValor()){
            atual.setDir(deleteNo(atual.getDir(), valor));
        }

        else {
            if(atual.getEsq() == null && atual.getDir() == null) {
                atual = null;
            }

            else if(atual.getEsq() == null) {
                No temp = atual;
                atual = atual.getDir();
                temp = null;
            }

            else if(atual.getDir() == null) {
                No temp = atual;
                atual = atual.getEsq();
                temp = null;
            }
            
            else {
                No temp = NoMin(atual.getDir());
                atual.setValor(temp.getValor());
                atual.setDir(deleteNo(atual.getDir(), temp.getValor()));
            }
        }
    
        return atual;
    }


}

    // identificar o nível de nó
    // Altura de um nó    
    // remover um nó
