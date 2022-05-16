public class No {
    
private String nome = "";
private int valor;
private No dir;
private No esq;

public No(String nome) {
    this.nome = nome;
    this.esq = null;
    this.dir = null; 
}

public No(int valor) {
    this.valor = valor;
    this.esq = null;
    this.dir = null; 
}

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the dir
     */
    public No getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(No dir) {
        this.dir = dir;
    }

    /**
     * @return the esq
     */
    public No getEsq() {
        return esq;
    }

    /**
     * @param esq the esq to set
     */
    public void setEsq(No esq) {
        this.esq = esq;
    }

}