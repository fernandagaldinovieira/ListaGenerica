package model;

public class Lista<T> implements ILista<T>{

	No<T> primeiro;
	
	public Lista() {
		primeiro = null;
	}
	
	@Override
	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No <T> auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}

	@Override
	public void addFirst(T dado) {
		No<T> elemento = new No<>();
		elemento.dado = dado;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	@Override
	public void addLast(T dado) throws Exception {
		if (isEmpty()) {
//			throw new Exception ("Lista Vazia");
			addFirst(dado);
		}
		int tamanho = size();
		No<T> elemento = new No<>();
		elemento.dado = dado;
		elemento.proximo = null;
		No<T> ultimo = getNo(tamanho - 1);
		ultimo.proximo = elemento;
		
		
		}

	@Override
	public void add(T dado, int posicao) throws Exception {
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception ("Posição Inválida");
		}
		if (posicao == 0) {
			addFirst(dado);
		} else if (posicao == tamanho) {
			addLast(dado);
		} else {
			No<T> elemento = new No<>();
			elemento.dado = dado;
			No<T> anterior = getNo(posicao - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	@Override
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}

	@Override
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}

	@Override
	public void remove(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho - 1) {
			throw new Exception ("Posição Inválida");
		}
		if (posicao == 0) {
			removeFirst();
		} else if (posicao == tamanho - 1) {
			removeLast();
		} else {
			No<T> anterior = getNo(posicao - 1);
			No<T> atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
	}
		

	@Override
	public T get(int posicao) throws Exception {
		No<T> elemento = getNo(posicao);
		return elemento.dado;
	}
	
	@Override
	public void clean() {
		primeiro = null; // Esvazia a lista
	}
	
	private No<T> getNo(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho - 1) {
			throw new Exception ("Posição Inválida");
		}
		No<T> auxiliar = primeiro;
		int cont = 0;
		while (cont < posicao) {
			auxiliar = auxiliar.proximo;
			cont ++;
		}
		return auxiliar;
	}
	
	@Override
	public void set(int posicao, T dado) throws Exception {
		No<T> elemento = getNo(posicao);
		elemento.dado = dado;
	}
	
	public boolean contains(T dado) {
        No<T> auxiliar = primeiro;
        while (auxiliar != null) {
            if (auxiliar.dado.equals(dado)) { 
                return true;  
            }
            auxiliar = auxiliar.proximo;
        }
        return false;
    }
}

