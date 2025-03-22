public class NoLista {
    NoLista ant,prox;
    int info;

    public NoLista(NoLista ant, NoLista prox, int info) {
        this.ant = ant;
        this.prox = prox;
        this.info = info;
    }
    public NoLista(int info) {
        this.ant = null;
        this.prox = null;
        this.info = info;
    }
    public NoLista(NoLista ant, int info) {
        this.ant = ant;
        this.prox = null;
        this.info = info;
    }
    public NoLista(){}

    public NoLista getAnt() {
        return ant;
    }
    public void setAnt(NoLista ant) {
        this.ant = ant;
    }
    public NoLista getProx() {
        return prox;
    }
    public void setProx(NoLista prox) {
        this.prox = prox;
    }
    public int getInfo() {
        return info;
    }
    public void setInfo(int info) {
        this.info = info;
    }
}
