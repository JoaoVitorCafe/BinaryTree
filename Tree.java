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
}
