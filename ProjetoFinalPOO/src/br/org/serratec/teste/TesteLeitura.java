package br.org.serratec.teste;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Set;

import br.org.serratec.model.Funcionario;
import br.org.serratec.model.LeituraArquivo;

public class TesteLeitura {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);

		try {
			LeituraArquivo larquivo = new LeituraArquivo("c:\\TesteArquivo\\empregados.txt");
			Set<Funcionario> funcionarios = larquivo.LerArquivo();

			for (Funcionario funcionario2 : funcionarios) {

				System.out.println(
						"\n========================================================================================================\n"
								+ funcionario2);

				System.out.printf("INSS: %.2f\n", funcionario2.calculoInss());

				System.out.printf("Imposto de Renda: %.2f\n", funcionario2.calculoIr());

				System.out.printf("Salário Líquido: %.2f", funcionario2.calculoSalLiq());

				System.out.println("\n");
//				System.out.println(
//						"\n======================================================================================================\n\n");

				FileWriter arquivoGravar = new FileWriter("c:\\TesteArquivo\\testando-gravar.txt");
				PrintWriter gravacaoArquivo = new PrintWriter(arquivoGravar);
				for (Funcionario f : funcionarios) {
					String linha = f.getNome() + ";" + f.getCpf() + ";" + df.format(f.calculoInss()) + ";"
							+ df.format(f.calculoIr()) + ";" + df.format(f.calculoSalLiq()) + "\n";

					gravacaoArquivo.printf(linha);
				}
				gravacaoArquivo.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
