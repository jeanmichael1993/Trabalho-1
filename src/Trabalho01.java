import java.util.Scanner;
import java.util.Locale;

public class Trabalho01 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int qtdClientes;

		System.out.println("Informe a quantidade e clientes:");
		qtdClientes = sc.nextInt();
		qtdClientes = qtdClientes + 1;
		int[] tipo = new int[qtdClientes];
		int[] minutos = new int[qtdClientes];
		String[] nome = new String[qtdClientes];
		String[] telefone = new String[qtdClientes];

		for (int i = 1; i < qtdClientes; i++) {

			System.out.printf("Dados do %dº Cliente:%n", i);
			System.out.println("Nome:");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.println("Telefone:(exemplo: xxxx-xxxx)");
			telefone[i] = sc.nextLine();
			System.out.println("Tipo:");
			tipo[i] = sc.nextInt();
			while (tipo[i] > 2) {
				System.out.println("Tipo Invalido, por gentileza digitar novamente:");
				tipo[i] = sc.nextInt();
			}
			System.out.println("Minutos:");
			minutos[i] = sc.nextInt();
		}

		System.out.println("Informe o preço basico e excedente de cada tipo de conta:");
		double[][] tipoConta = new double[3][2];

		for (int i = 0; i < 3; i++) {
			System.out.printf("Tipo %d%n", i);
			for (int j = 0; j < 2; j++) {

				tipoConta[i][j] = sc.nextDouble();
			}

		}

		double[] valorDaConta = new double[qtdClientes];

		for (int i = 1; i < qtdClientes; i++) {

			if (minutos[i] <= 90) {
				valorDaConta[i] = tipoConta[tipo[i]][0];

			} else {
				valorDaConta[i] = ((minutos[i] - 90) * tipoConta[tipo[i]][1]);
				valorDaConta[i] = tipoConta[tipo[i]][0] + valorDaConta[i];
			}

		}

		int opcao = 0;
		double receitaTotal = 0.0, valorMenor = valorDaConta[1], valorMedio = 0.0, pctTipo2 = 0.0;
		int cont = 0, qtd = 0, cont2 = 0;
		while (opcao != 7) {

			System.out.println("MENU DE OPÇÕES:");
			System.out.println("1) Relatorios de clientes.");
			System.out.println("2) A receita total.");
			System.out.println("3) Conta foi mais barata.");
			System.out.println("4) Consumo medio de clientes tipo 1.");
			System.out.println("5) Clientes que consumiram acima de 120 pulsos.");
			System.out.println("6) A porcentagem de clientes tipo 2.");
			System.out.println("7) Sair.");
			System.out.println("Informe a opção: ");
			opcao = sc.nextInt();

			if (opcao == 1) {

				for (int i = 1; i < qtdClientes; i++) {

					System.out.printf(nome[i] + ", " + telefone[i] + ",Tipo " + tipo[i] + ", Minutos: " + minutos[i]
							+ ", Conta = R$ " + ("%.2f"), valorDaConta[i]);
					System.out.println();
				}

			} else if (opcao == 2) {

				for (int i = 1; i < qtdClientes; i++) {

					receitaTotal = valorDaConta[i] + receitaTotal;
				}

				System.out.printf("Receita Total: %.2f", receitaTotal);
			}

			else if (opcao == 3) {

				for (int i = 1; i < qtdClientes; i++) {

					if (valorMenor > valorDaConta[i]) {

						valorMenor = valorDaConta[i];

					}

				}

				System.out.printf("Conta que foi mais barata: %.2f", valorMenor);
			}

			else if (opcao == 4) {

				for (int i = 1; i < qtdClientes; i++) {

					if (tipo[i] == 1) {

						valorMedio = valorDaConta[i] + valorMedio;
						cont++;
					}

				}

				valorMedio = valorMedio / cont;
				System.out.printf("Consumo medio de clientes tipo 1: %.2f", valorMedio);
			}

			else if (opcao == 5) {

				for (int i = 1; i < qtdClientes; i++) {

					if (minutos[i] > 120) {
						qtd++;
					}

				}
				System.out.println("Clientes que consumiram acima de 120 pulsos: " + qtd);

			}

			else if (opcao == 6) {

				for (int i = 1; i < qtdClientes; i++) {

					if (tipo[i] == 2) {
						cont2++;
					}

				}

				pctTipo2 = (double) cont2 / ((double) qtdClientes - 1);
				System.out.printf("Porcentagem de clientes tipo 2: %.1f%", pctTipo2 * 100.0);
			}

			System.out.println();
			System.out.println();

		}

		System.out.println("FIM DO PROGRAMA!");

		sc.close();

	}

}
