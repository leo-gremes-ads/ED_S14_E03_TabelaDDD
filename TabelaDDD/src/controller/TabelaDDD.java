package controller;

import lib.model.Lista;

public class TabelaDDD
{
	Lista<String>[] ListaDDD;

	public TabelaDDD()
	{
		ListaDDD = new Lista[89];
		inicializaLista();
	}

	private void inicializaLista()
	{
		int tamanho = ListaDDD.length;
		for (int i = 0; i < tamanho; i++) {
			ListaDDD[i] = new Lista<>();
		}
	}

	public int hashCode(String telefone)
	{
		return ((telefone.charAt(0) - 48) * 10 + (telefone.charAt(1) - 48)) - 11;
	}

	public void adicionaNumero(String telefone)
	{
		try {
			int hash = hashCode(telefone);
			if (ListaDDD[hash].isEmpty())
				ListaDDD[hash].addFirst(telefone);
			else
				ListaDDD[hash].addLast(telefone);
		} catch (Exception e) {
			System.err.println("Erro!");
		}
	}

	public void consultaTabela()
	{
		try {
			int tamanho = ListaDDD.length;
			for (int i = 0; i < tamanho; i++) {
				System.out.print("DDD " + (i + 11) + ": ");
				consultaLista(ListaDDD[i]);
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void consultaLista(Lista<String> ddd) throws Exception
	{
		int tamanho = ddd.size();
		if (tamanho == 1) {
			System.out.println(ddd.get(0) + " -> FIM!");
		}
		else if (tamanho > 1) {
			for (int i = 0; i < tamanho; i++) {
				String atual = ddd.get(0);
				System.out.print(atual + " -> ");
				ddd.removeFirst();
				ddd.addLast(atual);
			}
			System.out.print("FIM!");
		}
	}
}