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
    
        // Vai apenas pra direita pressupondo que a árvore esteja seguindo a regra binária.
            if(atual != null) {
                No maximo = atual;
                No dir = NoMax(atual.getDir());
                
                if(dir.getValor() > maximo.getValor())
                    maximo = dir;
                    return maximo;
                }
            
            // Precisava retornar um nó com valor mínimo para fazer a comparação quando a recursividade chegasse no nó mais distante.
            return new No(Integer.MIN_VALUE);
        }

    public No NoMin(No atual) {
        // Caso a árvore não esteja em regra binária basta colocar pra ele percorrer à direita tbm.
        
        // Vai apenas pra direita pressupondo que a árvore esteja seguindo a regra binária.
        if(atual != null) {
            No minimo = atual;
            No esq = NoMin(atual.getEsq());
            
            if(esq.getValor() < minimo.getValor())
                minimo = esq;
                return minimo;
            }

        return new No(Integer.MAX_VALUE);
        // Precisava retornar um nó com valor máximo para fazer a comparação quando a recursividade chegasse no nó mais distante.

    }

    public int totalNos(No atual) {
        if(atual == null) {
            return 0;
        }

        // Pecorre todas á esquerda e direita somando os nós que encontra
        return 1 + totalNos(atual.getEsq()) + totalNos(atual.getDir());
    }

    public int totalFolhas(No atual) {
        if(atual == null) {
            return 0;
        }
        
        // Se não tiver folhas retorna 1 que seŕa somado com o resultado do nó do lado oposto
        if(atual.getEsq() == null && atual.getDir() == null) {
            return 1;
        } 

        return totalFolhas(atual.getEsq()) + totalFolhas(atual.getDir());
    }

    public void identificarFolhas(No atual) {
        
        if(atual != null)
        {
            // Se não tiver filhos printa o valor do nó
            if(atual.getEsq() == null && atual.getDir() == null) {
                System.out.print(atual.getValor() + " ");
            } else {
                // Procura na direita e esquerda
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
        
        // Procura primeiramente na direita o alvo e aumenta em 1 o nível 
        int n = nivelNo(atual.getEsq() , target , nivel +1);

        if(n != -1){
            return n;
        }

        // Caso não obtenha resultado na esquerda procura na direita , aumentando em 1 o nível
        return nivelNo(atual.getDir() , target , nivel +1);
    }

    public int altura(No atual) {
          
        if(atual == null) {
            return -1;
        }

        // calcula altura da sub arvore da esquerda
        int alturaEsq = altura(atual.getEsq());
        
        /// calcula altura da sub arvore da direita
        int alturaDir = altura(atual.getDir());

        // compara as duas com o propósito de pegar o maior e soma 1 de altura;
        if(alturaEsq > alturaDir) {
            return 1 + alturaEsq;
        } else {
            return 1 + alturaDir;
        }
         
    }

    public int alturaNo(No atual , int valor) {
        // Procura o no para achar altura
        No target = search(atual , valor);
        if(target == null){
            return -1;
        } else {
            //calcula altura do nó
            return altura(target);
        }
    
    }

    public No deleteNo(No atual , int valor) {
        if(atual == null) {
            return atual;
        }

        // Se o valor do nó for menor que o do root vai pra esquerda
        else if(valor < atual.getValor()){
            atual.setEsq(deleteNo(atual.getEsq(), valor));
        }
    
        // Se o valor do nó for maior que o do root vai pra direita
        else if(valor > atual.getValor()){
            atual.setDir(deleteNo(atual.getDir(), valor));
        }

        else {
            // Se não tem filhos deleta por completo
            if(atual.getEsq() == null && atual.getDir() == null) {
                atual = null;
            }

            
            else if(atual.getEsq() == null) {
            // Se a esquerda estiver vazia "sobe" o nó direito , cortando o de baixo
                No temp = atual;
                atual = atual.getDir();
                temp = null;
            }

            else if(atual.getDir() == null) {
                // Se a direita estiver vazia "sobe" o nó esquerdo , cortando o de baixo
                No temp = atual;
                atual = atual.getEsq();
                temp = null;
            }
            
            else {
                // Caso tenha dois filhos pega o minimo na sub arvore da direita , "sobe" o minimo e deleta o de baixo(duplicado) 
                No temp = NoMin(atual.getDir());
                atual.setValor(temp.getValor());
                atual.setDir(deleteNo(atual.getDir(), temp.getValor()));
            }
        }
    
        return atual;
    }

}

