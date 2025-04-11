public class Lista {
    NoLista inicio, fim;

    public Lista() {}

    public void insereListaInicio(int info) {
        if(inicio == null)
            inicio = fim = new NoLista(info);
        else{
            NoLista nc = new NoLista(null, inicio, info);
            inicio.setAnt(nc);
            inicio = nc;
        }
    }

    public void insereListaFim(int info) {
        if (fim == null)
            inicio = fim = new NoLista(info);
        else{
            NoLista nc = new NoLista(fim, null, info);
            fim.setProx(nc);
            fim = nc;
        }
    }

    public void exibirLista(){
        NoLista aux = inicio;
        while(aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }

    private int length(){
        NoLista ini;
        int i;
        for(ini = inicio,i = 0; ini != null; ini = ini.getProx(),i++);
        return i;
    }

    public void clonaLista(Lista lista){
        if(inicio != null)
            inicio = fim = null;
        for (NoLista aux = lista.inicio; aux != null; aux = aux.getProx())
            insereListaFim(aux.getInfo());
    }

    public void validaOrdenacao(String msg){
        NoLista aux = inicio;
        boolean erro = false;
        for(int i = 1; i <= 6; i++, aux = aux.getProx())
            if (aux.getInfo() != i){
                System.out.println(msg + " erro");
                erro = true;
                i=65;
            }
        if(!erro)
            System.out.println(msg + " ok");
    }

    private NoLista posiciona(NoLista pos, int posAtu, int posDist){
        if (posDist > posAtu){
            while(posAtu != posDist){
                pos = pos.getProx();
                posAtu++;
            }
            return pos;
        }
        while(posAtu != posDist){
            pos = pos.getAnt();
            posAtu--;
        }
        return pos;
    }

    private NoLista posicionaDps(NoLista pos, int posAtu, int posDist){
        while(posAtu != posDist){
            pos = pos.getProx();
            posAtu++;
        }
        return pos;
    }

    private NoLista posicionaAnt(NoLista pos, int posAtu, int posDist){
        while(posAtu != posDist){
            pos = pos.getAnt();
            posAtu--;
        }
        return pos;
    }

    public int max(){
        int M = inicio.getInfo();
        NoLista aux = inicio.getProx();
        while (aux != null){
            if(aux.getInfo() > M)
                M = aux.getInfo();
            aux = aux.getProx();
        }
        return M;
    }

    public int min(){
        int m = inicio.getInfo();
        NoLista aux = inicio.getProx();
        while (aux != null){
            if(aux.getInfo() < m)
                m = aux.getInfo();
            aux = aux.getProx();
        }
        return m;
    }

    public void insercaoDireta(){
        NoLista pi, ppos;
        int aux;

        if(length() > 1)
            for(pi = inicio.getProx(); pi != null; pi = pi.getProx()) {
                ppos = pi;
                aux = pi.getInfo();
                while(ppos != inicio && aux < ppos.getAnt().getInfo()){
                    ppos.setInfo(ppos.getAnt().getInfo());
                    ppos = ppos.getAnt();
                }
                ppos.setInfo(aux);
            }
    }

    private NoLista buscaBinaria(int tl, int info, NoLista aux){
        int ini = 0, fim = tl, meio = fim/2;

        aux = posicionaAnt(aux, tl, meio);
        while(ini < fim && info != aux.getInfo()){
            if(info > aux.getInfo())
                ini = meio + 1;
            else fim = meio - 1;
            int pos = meio;
            meio = (ini + fim)/2;
            aux = posiciona(aux, pos, meio);
        }
        if(info > aux.getInfo())
            return aux.getProx();
        return aux;
    }
    public void insercaoBinaria(){
        NoLista pa, pos, aux;
        int info,i;

        for(pa = inicio.getProx(), i= 1; pa != null; pa = pa.getProx(), i++) {
            info = pa.getInfo();
            pos = buscaBinaria(i, info, pa);
            for (aux = pa;aux != pos;aux = aux.getAnt())
                aux.setInfo(aux.getAnt().getInfo());
            pos.setInfo(info);
        }
    }

    public void selecaoDireta(){
        NoLista i, j, pos_m;
        for(i = inicio; i.getProx() != null; i = i.getProx()){
            pos_m = i;
            for (j = i.getProx(); j != null; j = j.getProx())
                if(pos_m.getInfo() > j.getInfo())
                    pos_m = j;
            int info = i.getInfo();
            i.setInfo(pos_m.getInfo());
            pos_m.setInfo(info);
        }
    }

    public void bubleSort(){
        NoLista aux;
        int i, info, tl = length();
        boolean flag = true;

        while (tl > 1 && flag){
            flag = false;
            for(i = 0, aux = inicio; i < tl - 1; aux = aux.getProx(), i++)
                if(aux.getInfo() > aux.getProx().getInfo()){
                    info = aux.getInfo();
                    aux.setInfo(aux.getProx().getInfo());
                    aux.getProx().setInfo(info);
                    flag = true;
                }
            tl--;
        }
    }

    public void shakeSort(){
        NoLista ini = inicio, fim = this.fim, aux;
        int info;
        boolean flag = true;

        while (ini != fim && flag){
            flag = false;
            for(aux = ini; aux != fim; aux = aux.getProx())
                if(aux.getInfo() > aux.getProx().getInfo()){
                    info = aux.getInfo();
                    aux.setInfo(aux.getProx().getInfo());
                    aux.getProx().setInfo(info);
                    flag = true;
                }
            fim = fim.getAnt();
            if (flag){
                flag = false;
                for (aux = fim; aux != ini; aux = aux.getAnt())
                    if(aux.getInfo() < aux.getAnt().getInfo()){
                        info = aux.getInfo();
                        aux.setInfo(aux.getAnt().getInfo());
                        aux.getAnt().setInfo(info);
                        flag = true;
                    }
                ini = ini.getProx();
            }
        }
    }

    public void shellSort(){
        int dist, i, aux, pos, tl = length();
        NoLista no, no_ant, no_atu;

        for(dist = 1; dist < tl; dist = dist * 3 + 1);
        for(dist /= 3; dist > 0; dist /= 3)
            for (no = posiciona(inicio, 0, dist),i = dist; i < tl; i++, no = no.getProx()){
                aux = no.getInfo();
                pos = i;
                no_atu = no;
                no_ant = posicionaAnt(no, pos, pos - dist);
                while (pos >= dist && aux < no_ant.getInfo()){
                    no_atu.setInfo(no_ant.getInfo());
                    pos -= dist;
                    no_atu = no_ant;
                    if(pos >= dist)
                        no_ant = posicionaAnt(no_ant, pos, pos - dist);
                }
                no_atu.setInfo(aux);
            }
    }

    public void heapSort(){
        int posPai, posFE= 0, posFD, aux;
        NoLista pai, FE = null, FD, maiorF;

        for(int tl = length(); tl > 1; tl--){
            for (posPai = tl / 2 - 1, pai = posicionaDps(inicio, 0, posPai); posPai >= 0; posPai--, pai = pai.getAnt()){
                posFE = posPai * 2 + 1;
                posFD = posFE + 1;
                maiorF = FE = posicionaDps(pai, posPai, posFE);
                if(posFD < tl){
                    FD = FE.getProx();
                    if(FD.getInfo() > FE.getInfo())
                        maiorF = FD;
                }
                if(pai.getInfo() < maiorF.getInfo()){
                    aux = pai.getInfo();
                    pai.setInfo(maiorF.getInfo());
                    maiorF.setInfo(aux);
                }
            }
            aux = inicio.getInfo();
            pai = posicionaDps(FE, posFE, tl-1);
            inicio.setInfo(pai.getInfo());
            pai.setInfo(aux);
        }
    }

    public void quickSortSemPivo(){
        quickSortSP(inicio, fim, 0, length() - 1);
    }
    private void quickSortSP(NoLista ini, NoLista fim, int posi, int posj) {
        NoLista i = ini, j = fim;
        boolean flag = true;
        int aux, posIni = posi, posFim = posj;

        while(posi < posj) {
            if(flag)
                while (posi < posj && i.getInfo() <= j.getInfo()) {
                    posi++;
                    i = i.getProx();
                }
            else
                while (posi < posj && j.getInfo() >= i.getInfo()) {
                    posj--;
                    j = j.getAnt();
                }
            aux = i.getInfo();
            i.setInfo(j.getInfo());
            j.setInfo(aux);
            flag = !flag;
        }
        if(posIni < posi - 1)
            quickSortSP(ini,i.getAnt(), posIni, posi-1);
        if(posj + 1 < posFim)
            quickSortSP(j.getProx(),fim,posj+1,posFim);
    }

    public void quickSemPivoIterativo(){
        PilhaInt pi = new PilhaInt();
        PilhaLista pl = new PilhaLista();
        int posIni, posFim, posi, posj, aux;
        NoLista noi, noj, i, j;
        boolean flag;

        pi.push(0);
        pi.push(length()-1);
        pl.push(inicio);
        pl.push(fim);

        while(!pi.isEmpty()){
            posFim = posj = pi.pop();
            posIni = posi = pi.pop();
            noj = j = pl.pop();
            noi = i = pl.pop();
            flag = true;
            while(posi < posj){
                if(flag)
                    while (posi < posj && i.getInfo() <= j.getInfo()) {
                        posi++;
                        i = i.getProx();
                    }
                else
                    while(posi < posj && j.getInfo() >= i.getInfo()) {
                        posj--;
                        j = j.getAnt();
                    }
                aux = i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
                flag = !flag;
            }
            if(posj + 1 < posFim){
                pi.push(posj + 1);
                pi.push(posFim);
                pl.push(j.getProx());
                pl.push(noj);
            }
            if(posIni < posi - 1){
                pi.push(posIni);
                pi.push(posi - 1);
                pl.push(noi);
                pl.push(i.getAnt());
            }
        }
    }

    public void quickComPivo(){
        quickCP(inicio, fim, 0, length()-1);
    }
    private void quickCP(NoLista ini, NoLista fim, int posInicio, int posFim) {
        int posi= posInicio, posj= posFim, pivo = posicionaDps(ini,posi, (posi+posj)/2).getInfo();
        NoLista i = ini, j = fim;

        while(posi < posj){
            while (i.getInfo() < pivo) {
                i = i.getProx();
                posi++;
            }
            while (j.getInfo() > pivo) {
                j = j.getAnt();
                posj--;
            }
            if(posi <= posj) {
                int aux = i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
                i = i.getProx();
                j = j.getAnt();
                posi++;
                posj--;
            }
        }
        if(posInicio < posj)
            quickCP(ini, j, posInicio, posj);
        if(posi < posFim)
            quickCP(i, fim, posi, posFim);
    }

    public void quickComPivoIterativo(){
        PilhaInt pi = new PilhaInt();
        PilhaLista pl = new PilhaLista();
        int posIni, posFim, posi, posj, aux, pivo;
        NoLista noi, noj, i, j;

        pi.push(0); pl.push(inicio);
        pi.push(length()-1); pl.push(fim);
        while(!pi.isEmpty()){
            posFim = posj = pi.pop();
            posIni = posi = pi.pop();
            noj = j = pl.pop();
            noi = i = pl.pop();
            pivo = posicionaDps(i,posi, (posi+posj)/2).getInfo();
            while(posi < posj){
                while(pivo > i.getInfo()){
                    i = i.getProx();
                    posi++;
                }
                while(pivo < j.getInfo()){
                    j = j.getAnt();
                    posj--;
                }
                if(posi <= posj){
                    aux = i.getInfo();
                    i.setInfo(j.getInfo());
                    j.setInfo(aux);
                    i = i.getProx(); posi++;
                    j = j.getAnt(); posj--;
                }
            }
            if(posFim > posi){
                pi.push(posi); pl.push(i);
                pi.push(posFim); pl.push(noj);
            }
            if(posIni < posj){
                pi.push(posIni); pl.push(noi);
                pi.push(posj); pl.push(j);
            }
        }
    }

    private void particao(Lista lista1, Lista lista2, int tl, int meio) {
        NoLista aux = inicio;
        int i;

        NoLista l1 = lista1.inicio;
        for (i = 0; i < meio; i++) {
            l1.setInfo(aux.getInfo());
            l1 = l1.getProx();
            aux = aux.getProx();
        }

        NoLista l2 = lista2.inicio;
        for (i = meio; i < tl; i++) {
            l2.setInfo(aux.getInfo());
            l2 = l2.getProx();
            aux = aux.getProx();
        }
    }
    private void fusao_1(Lista lista1, Lista lista2, int seq) {
        NoLista aux = inicio;
        NoLista l1 = lista1.inicio;
        NoLista l2 = lista2.inicio;
        int i,j, sum = seq;

        for(i = j = 0; aux != null; ) {
            while(i < seq && j < seq) {
                if (l1.getInfo() < l2.getInfo()) {
                    aux.setInfo(l1.getInfo());
                    l1 = l1.getProx();
                    i++;
                } else {
                    aux.setInfo(l2.getInfo());
                    l2 = l2.getProx();
                    j++;
                }
                aux = aux.getProx();
            }
            while (i < seq){
                aux.setInfo(l1.getInfo());
                l1 = l1.getProx();
                i++;
                aux = aux.getProx();
            }
            while (j < seq) {
                aux.setInfo(l2.getInfo());
                l2 = l2.getProx();
                j++;
                aux = aux.getProx();
            }
            seq += sum;
        }
    }
    public void mergeSort_1() {
        int seq = 1,  tl = length(), meio = tl/2;
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        for (int i = 0; i < meio; i++) {
            lista1.insereListaInicio(0);
            lista2.insereListaInicio(0);
        }
        while (seq < tl) {
            particao(lista1,lista2,tl,meio);
            fusao_1(lista1,lista2, seq);
            seq *= 2;
        }
    }

    private void fusao_2(NoLista lista, NoLista ini1, NoLista fim1, int pos_ini1, int pos_fim1, NoLista ini2, NoLista fim2, int pos_ini2, int pos_fim2) {
        int i = pos_ini1, j = pos_ini2, k = 0;
        NoLista aux = lista, noi = ini1, noj = ini2;
        while (i <= pos_fim1 && j <= pos_fim2) {
            if (noi.getInfo() < noj.getInfo()) {
                aux.setInfo(noi.getInfo());
                noi = noi.getProx();
                i++;
            } else {
                aux.setInfo(noj.getInfo());
                noj = noj.getProx();
                j++;
            }
            aux = aux.getProx();
            k++;
        }
        while (i <= pos_fim1){
            aux.setInfo(noi.getInfo());
            noi = noi.getProx();
            aux = aux.getProx();
            i++;
            k++;
        }
        while (j <= pos_fim2){
            aux.setInfo(noj.getInfo());
            noj = noj.getProx();
            aux = aux.getProx();
            j++;
            k++;
        }
        NoLista no = posicionaDps(inicio, 0, pos_ini1);
        aux = lista;
        for (i = 0; i < k; i++) {
            no.setInfo(aux.getInfo());
            no = no.getProx();
            aux = aux.getProx();
        }
    }
    private void merge(NoLista lista, NoLista esq, NoLista dir, int pos_esq, int pos_dir){
        if(pos_esq < pos_dir){
            int meio = (pos_esq + pos_dir)/2;
            NoLista no_meio = posicionaDps(esq,pos_esq,meio);
            merge(lista,esq,no_meio,pos_esq,meio);
            merge(lista,no_meio.getProx(),dir,meio + 1, pos_dir);
            fusao_2(lista, esq, no_meio, pos_esq, meio, no_meio.getProx(), dir, meio + 1, pos_dir);
        }
    }
    public void mergeSort_2(){
        int tl = length();
        NoLista lista = new NoLista(), aux = lista;
        for (int i = 1; i < tl; i++) {
            aux.setProx(new NoLista());
            aux.getProx().setAnt(aux);
            aux = aux.getProx();
        }
        merge(lista, inicio,fim, 0 , tl-1);
    }

    private void fusao_mergeIterativo(Lista l, NoLista no1, int ini1, int fim1, NoLista no2, int ini2, int fim2) {
        int auxIni1 = ini1, k = 0;
        NoLista aux = l.inicio;
        while (ini1 <= fim1 && ini2 <= fim2)
            if (no1.getInfo() < no2.getInfo()) {
                aux.setInfo(no1.getInfo());
                aux = aux.getProx(); k++;
                no1 = no1.getProx(); ini1++;
            } else {
                aux.setInfo(no2.getInfo());
                aux = aux.getProx(); k++;
                no2 = no2.getProx(); ini2++;
            }
        while (ini1 <= fim1){
            aux.setInfo(no1.getInfo());
            aux = aux.getProx(); k++;
            no1 = no1.getProx(); ini1++;
        }
        while (ini2 <= fim2){
            aux.setInfo(no2.getInfo());
            aux = aux.getProx(); k++;
            no2 = no2.getProx(); ini2++;
        }
        NoLista no = posicionaDps(inicio, 0, auxIni1);
        aux = l.inicio;
        for (int i = 0; i < k; i++) {
            no.setInfo(aux.getInfo());
            no = no.getProx();
            aux = aux.getProx();
        }
    }
    public void mergeSort2_Iterativo(){
        PilhaInt pi1 = new PilhaInt();
        PilhaLista pl1 = new PilhaLista();
        PilhaInt pi2 = new PilhaInt();
        PilhaLista pl2 = new PilhaLista();
        Lista l = new Lista();
        int tl = length();

        for(int i = 0; i < tl; i++)
            l.insereListaInicio(0);

        NoLista noe, nom, nod;
        int esq, meio, dir;
        pi1.push(0);pl1.push(inicio);pi1.push(tl-1);pl1.push(fim);
        while (!pi1.isEmpty()) {
            nod = pl1.pop(); dir = pi1.pop();
            noe = pl1.pop(); esq = pi1.pop();
            if(esq < dir){
                meio = (esq + dir)/2;
                nom = posicionaDps(noe, esq, meio);
                pi1.push(meio+1);pl1.push(nom.getProx());pi1.push(dir);pl1.push(nod);
                pi1.push(esq);pl1.push(noe);pi1.push(meio);pl1.push(nom);

                pi2.push(meio+1);pl2.push(nom.getProx());pi2.push(dir);pl2.push(nod);
                pi2.push(esq);pl2.push(noe);pi2.push(meio);pl2.push(nom);
            }
        }
        NoLista ini1, ini2;
        int posIni1, posIni2, posFim1, posFim2;
        while(!pi2.isEmpty()){
            pl2.pop(); posFim1 = pi2.pop();
            ini1 = pl2.pop(); posIni1 = pi2.pop();
            pl2.pop(); posFim2 = pi2.pop();
            ini2 = pl2.pop(); posIni2 = pi2.pop();
            fusao_mergeIterativo(l,ini1, posIni1, posFim1, ini2, posIni2, posFim2);
        }
    }

    public void countingSort() {
        int M = max(), i;
        NoLista aux;

        int[] vet = new int[M + 1];
        for(aux = inicio; aux != null; aux = aux.getProx())
            vet[aux.getInfo()]++;

        for(i = 1; i < vet.length; i++)
            vet[i] += vet[i - 1];

        NoLista ordenado = new NoLista();
        int tam = length();
        NoLista lista = ordenado;
        for (i = 1; i < tam; i++) {
            lista.setProx(new NoLista());
            lista.getProx().setAnt(lista);
            lista = lista.getProx();
        }

        aux = fim;
        fim = lista;
        inicio = ordenado;
        for(; aux != null; aux = aux.getAnt()){
            lista = posiciona(lista,i,vet[aux.getInfo()]);
            i = vet[aux.getInfo()];
            lista.setInfo(aux.getInfo());
            vet[aux.getInfo()]--;
        }
    }

    public void bucketSort(){
        int max = max();
        int min = min();
        int baldes = (int) Math.sqrt(max - min + 1);
        int intervalo = (max - min + 1) / baldes;
        int i, pos;
        Lista[] bucket = new Lista[baldes + 1];
        NoLista aux;

        for (i = 0; i < bucket.length; i++)
            bucket[i] = new Lista();

        for (aux = inicio; aux != null; aux = aux.getProx()) {
            pos = (aux.getInfo() - min) / intervalo;
            bucket[pos].insereListaInicio(aux.getInfo());
        }

        for (i = 0; i < bucket.length; i++)
            bucket[i].insercaoDireta();

        NoLista lista = inicio;
        for (i = 0; i < bucket.length; i++)
            for (aux = bucket[i].inicio; aux != null; aux = aux.getProx()){
                lista.setInfo(aux.getInfo());
                lista = lista.getProx();
            }
    }

    public void radixSort() {
        int max = max();
        int i, tl = length();
        Lista lista = new Lista();
        NoLista noLista, aux;

        for (i = 0; i < tl; i++)
            lista.insereListaInicio(0);
        for(int dgt = 1; dgt <= max; dgt *= 10) {
            int[] couting = new int[10];

            for (aux = inicio; aux != null; aux = aux.getProx())
                couting[(aux.getInfo()/dgt) % 10]++;

            for (i = 1; i < 10; i++)
                couting[i] += couting[i - 1];

            noLista = lista.inicio; i = 0;
            for(aux = fim; aux != null; aux = aux.getAnt()){
                int pos = (aux.getInfo()/dgt) % 10;
                noLista = posiciona(noLista,i,--couting[pos]);
                i = couting[pos];
                noLista.setInfo(aux.getInfo());
            }
            noLista = inicio;
            inicio = lista.inicio;
            lista.inicio = noLista;

            noLista = fim;
            fim = lista.fim;
            lista.fim = noLista;
        }
    }

    public void combSort(){
        int tam = length(), intervalo = (int) (tam/1.3), i, info;
        NoLista aux,aux2;
        boolean flag = true;

        while(intervalo > 1 || flag){
            flag = false;
            i = 0;
            aux = inicio;
            aux2 = posicionaDps(aux, 0, intervalo);
            while (i + intervalo < tam){
                if (aux.getInfo() > aux2.getInfo()){
                    info = aux.getInfo();
                    aux.setInfo(aux2.getInfo());
                    aux2.setInfo(info);
                    flag = true;
                }
                i++;
                aux = aux.getProx();
                aux2 = aux2.getProx();
            }
            if(intervalo > 1) {
                flag = true;
                intervalo = (int) (intervalo / 1.3);
            }
        }
    }

    public void gnomeSort(){
        NoLista aux = inicio;

        while (aux != null) {
            if(aux == inicio)
                aux = aux.getProx();
            if (aux.getInfo() >= aux.getAnt().getInfo())
                aux = aux.getProx();
            else{
                int info = aux.getInfo();
                aux.setInfo(aux.getAnt().getInfo());
                aux.getAnt().setInfo(info);
                aux = aux.getAnt();
            }
        }
    }

    private void insercaoDireta_ForTim(NoLista inicio, NoLista fim){
        NoLista pi, ppos;
        int aux;

        for(pi = inicio.getProx(); pi != fim.getProx(); pi = pi.getProx()) {
            ppos = pi;
            aux = pi.getInfo();
            while(ppos != inicio && aux < ppos.getAnt().getInfo()){
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos = ppos.getAnt();
            }
            ppos.setInfo(aux);
        }
    }
    private void fusao(NoLista lista, NoLista ini1, int pos_ini1, int pos_fim1, NoLista ini2, int pos_ini2, int pos_fim2) {
        int i = pos_ini1, j = pos_ini2, k = 0;
        NoLista aux = lista, noi = ini1, noj = ini2;
        while (i <= pos_fim1 && j <= pos_fim2) {
            if (noi.getInfo() < noj.getInfo()) {
                aux.setInfo(noi.getInfo());
                noi = noi.getProx();
                i++;
            } else {
                aux.setInfo(noj.getInfo());
                noj = noj.getProx();
                j++;
            }
            aux = aux.getProx();
            k++;
        }
        while (i <= pos_fim1){
            aux.setInfo(noi.getInfo());
            noi = noi.getProx();
            aux = aux.getProx();
            i++;
            k++;
        }
        while (j <= pos_fim2){
            aux.setInfo(noj.getInfo());
            noj = noj.getProx();
            aux = aux.getProx();
            j++;
            k++;
        }
        NoLista no = posicionaDps(inicio, 0, pos_ini1);
        aux = lista;
        for (i = 0; i < k; i++) {
            no.setInfo(aux.getInfo());
            no = no.getProx();
            aux = aux.getProx();
        }
    }
    public void timSort(){
        int tl = length(), run = 32, i, esq, meio, dir;
        NoLista ini = inicio, no_esq, no_meio;
        NoLista fim = posicionaDps(inicio, 0, Math.min(run,tl-1));

        for (i = 0; i < tl; ){
            insercaoDireta_ForTim(ini, fim);
            i += run;
            if(i < tl){
                ini = fim;
                fim = posicionaDps(ini, i, Math.min(i+run,tl-1));
            }
        }

        NoLista lista = new NoLista(), aux = lista;
        for (i = 1; i < tl; i++) {
            aux.setProx(new NoLista());
            aux.getProx().setAnt(aux);
            aux = aux.getProx();
        }

        for (int tam = run; tam < tl; tam *= 2) {
            for (esq = 0; esq < tl; esq += 2 * tam) {
                meio = esq + tam - 1;
                dir = Math.min((esq + 2 * tam - 1), (tl - 1));
                if (meio < dir){
                    no_esq = posicionaDps(inicio,0,esq);
                    no_meio = posicionaDps(no_esq,esq,meio);
                    fusao(lista, no_esq, esq, meio, no_meio.getProx(), meio + 1, dir);
                }
            }
        }
    }
}
