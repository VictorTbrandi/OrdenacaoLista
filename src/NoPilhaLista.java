public class NoPilhaLista {
    private NoLista info;
    private NoPilhaLista prox;

    public NoPilhaLista(NoLista info, NoPilhaLista prox) {
        this.info = info;
        this.prox = prox;
    }

    public NoLista getInfo() {
        return info;
    }

    public NoPilhaLista getProx() {
        return prox;
    }
}
