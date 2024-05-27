package view;

import controller.TabelaDDD;
import javax.swing.JOptionPane;

public class Principal
{
	public static void main(String[] args)
	{
		TabelaDDD tab = new TabelaDDD();

		while (true) {
			int opt = menu();
			if (opt == 0) adicionarNumero(tab);
			else if (opt == 1) tab.consultaTabela();
			else break;
		}
		JOptionPane.showMessageDialog(null, "Fim do Programa");
	}

	private static int menu()
	{
		String[] opcs = {"Adicionar Número", "Consultar Números", "Sair"};
		return JOptionPane.showOptionDialog(
			null, "Selecione a opção desejada", "TabelaDDD",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
			opcs, opcs[2]);
	}

	private static void adicionarNumero(TabelaDDD ddd)
	{
		String num = JOptionPane.showInputDialog("Insira um número de telefone:");
		if (num.length() != 11)
			JOptionPane.showMessageDialog(null, "Número inválido!");
		else {
			ddd.adicionaNumero(num);
			JOptionPane.showMessageDialog(null, "Número adicionado!");
		}
	}
}
