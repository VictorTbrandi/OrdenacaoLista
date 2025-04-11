public class NoPilhaInt {
    private int info;
    private NoPilhaInt prox;

    public NoPilhaInt(int info, NoPilhaInt prox) {
        this.info = info;
        this.prox = prox;
    }
    public int getInfo() {
        return info;
    }
    public NoPilhaInt getProx() {
        return prox;
    }
}
