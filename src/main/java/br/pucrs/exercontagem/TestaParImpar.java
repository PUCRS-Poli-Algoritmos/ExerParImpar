package br.pucrs.exercontagem;

import java.util.Formatter;
import java.util.Locale;
import java.util.Random;

public class TestaParImpar {

	private static void testInicial() {
		ParImpar pi = new ParImpar();

		int [] aux = {5, 2, 4, 7, 13, 27, 10, 12, 27, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
		int [] aux1 = {1, 2, 3, 4, 5, 6};
		int [] aux2 = {1, 3, 5, 2, 4, 6};

		System.out.println("Nro Elementos: 20 - com vetor aux");
		System.out.println(pi.toString(pi.sepParImparAux1(aux)));
		System.out.println("Nro Iteracoes:" + pi.getIteracoes());
		System.out.println("Nro Instrucoes:" + pi.getInstrucoes() + "\n\n");

		System.out.println("Nro Elementos: 20 - in place");
		System.out.println(pi.toString(pi.sepParImparInPlace1(aux)));
		System.out.println("Nro Iteracoes:" + pi.getIteracoes());
		System.out.println("Nro Instrucoes:" + pi.getInstrucoes() + "\n\n");

		System.out.println("Nro Elementos: 6 - com vetor aux");
		System.out.println(pi.toString(pi.sepParImparAux1(aux1)));
		System.out.println("Nro Iteracoes:" + pi.getIteracoes());
		System.out.println("Nro Instrucoes:" + pi.getInstrucoes() + "\n\n");

		System.out.println("Nro Elementos: 6 - in place");
		System.out.println(pi.toString(pi.sepParImparInPlace1(aux1)));
		System.out.println("Nro Iteracoes:" + pi.getIteracoes());
		System.out.println("Nro Instrucoes:" + pi.getInstrucoes() + "\n\n");

		System.out.println("Nro Elementos: 6 - com vetor aux");
		System.out.println(pi.toString(pi.sepParImparAux1(aux2)));
		System.out.println("Nro Iteracoes:" + pi.getIteracoes());
		System.out.println("Nro Instrucoes:" + pi.getInstrucoes() + "\n\n");

		System.out.println("Nro Elementos: 6 - in place");
		System.out.println(pi.toString(pi.sepParImparInPlace1(aux2)));
		System.out.println("Nro Iteracoes:" + pi.getIteracoes());
		System.out.println("Nro Instrucoes:" + pi.getInstrucoes() + "\n\n");
	}

	private static int[] geraVetor(int nroPares, int nroImpares){
		int [] res = null;
		int contPar = 0, contImpar = 0, novoNum;
		Random rnd = new Random();

		if ((nroPares >= 0) || 
				(nroImpares >= 0) && 
				(nroPares + nroImpares > 0)) {

			res = new int[nroPares + nroImpares];

			while ((contPar < nroPares) || (contImpar < nroImpares)) {
				novoNum = rnd.nextInt(98)+1;

				if ((novoNum % 2 == 0) && (contPar < nroPares)) {
					res[contPar+contImpar] = novoNum;
					contPar++;
				}
				else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
					res[contPar+contImpar] = novoNum;
					contImpar++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] vet, vetRes;
		StringBuilder sb = new StringBuilder();
		ParImpar pi = new ParImpar();
		Formatter fmt = new Formatter(sb, Locale.US);
		Long nanoIni, nanoFim;
		double sec;

		System.out.println("*****Testes Iniciais*****");
		testInicial();

		System.out.println("\n\n*****Testes Solicitados*****");

		//***********************************************************		
		vet = geraVetor(50, 50);

		System.out.println("Nro Elementos: 100 (50 pares, 50 impares) - aux");
		nanoIni = System.nanoTime();
		vetRes = pi.sepParImparAux1(vet);
		nanoFim = System.nanoTime();
		sec = (nanoFim - nanoIni)/1_000_000_000.0;

		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb);
		System.out.printf("Tempo: %3.10f segundos \n\n", sec);

		System.out.println("Nro Elementos: 100 (50 pares, 50 impares) - in place");
		nanoIni = System.nanoTime();
		vetRes = pi.sepParImparInPlace1(vet);
		nanoFim = System.nanoTime();
		sec = (nanoFim - nanoIni)/1_000_000_000.0;

		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb);
		System.out.printf("Tempo: %3.10f segundos \n\n", sec);

		vet = geraVetor(20, 80);

		System.out.println("Nro Elementos: 100 (20 pares, 80 impares) - aux");
		nanoIni = System.nanoTime();
		vetRes = pi.sepParImparAux1(vet);
		nanoFim = System.nanoTime();
		sec = (nanoFim - nanoIni)/1_000_000_000.0;

		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb);
		System.out.printf("Tempo: %3.10f segundos \n\n", sec);

		System.out.println("Nro Elementos: 100 (20 pares, 80 impares) - in place");
		nanoIni = System.nanoTime();
		vetRes = pi.sepParImparInPlace1(vet);
		nanoFim = System.nanoTime();
		sec = (nanoFim - nanoIni)/1_000_000_000.0;

		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb);
		System.out.printf("Tempo: %3.10f segundos \n\n", sec);

		vet = geraVetor(80, 20);

		System.out.println("Nro Elementos: 100 (80 pares, 20 impares) - aux");
		nanoIni = System.nanoTime();
		vetRes = pi.sepParImparAux1(vet);
		nanoFim = System.nanoTime();
		sec = (nanoFim - nanoIni)/1_000_000_000.0;

		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb);
		System.out.printf("Tempo: %3.10f segundos \n\n", sec);

		System.out.println("Nro Elementos: 100 (80 pares, 20 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		//*************************************************************
		vet = geraVetor(500, 500);

		System.out.println("Nro Elementos: 1.000 (500 pares, 500 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 1.000 (500 pares, 500 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(200, 800);

		System.out.println("Nro Elementos: 1.000 (200 pares, 800 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 1.000 (200 pares, 800 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(800, 200);

		System.out.println("Nro Elementos: 1.000 (800 pares, 200 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 1.000 (800 pares, 200 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		//*************************************************************
		vet = geraVetor(5_000, 5_000);

		System.out.println("Nro Elementos: 10.000 (5.000 pares, 5.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: (\"Nro Elementos: 10.000 (5.000 pares, 5.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(2_000, 8_000);

		System.out.println("Nro Elementos: 10.000 (2.000 pares, 8.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 10.000 (2.000 pares, 8.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(8_000, 2_000);

		System.out.println("Nro Elementos: 10.000 (8.000 pares, 2.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 10.000 (8.000 pares, 2.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		//*************************************************************
		vet = geraVetor(50_000, 50_000);

		System.out.println("Nro Elementos: 100.000 (50.000 pares, 50.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: (\"Nro Elementos: 100.000 (50.000 pares, 50.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(20_000, 80_000);

		System.out.println("Nro Elementos: 100.000 (20.000 pares, 80.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 100.000 (20.000 pares, 80.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(80_000, 20_000);

		System.out.println("Nro Elementos: 100.000 (80.000 pares, 20.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 100.000 (80.000 pares, 20.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");



		//*************************************************************		
		vet = geraVetor(250_000, 250_000);

		System.out.println("Nro Elementos: 500.000 (250.000 pares, 250.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 500.000 (250.000 pares, 250.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(100_000, 400_000);

		System.out.println("Nro Elementos: 500.000 (100.000 pares, 400.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 500.000 (100.000 pares, 400.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(400_000, 100_000);

		System.out.println("Nro Elementos: 500.000 (400.000 pares, 100.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 500.000 (400.000 pares, 100.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		//*************************************************************
		System.out.println("\n\n*****Testes Extras*****");		
		vet = geraVetor(500_000, 500_000);

		System.out.println("Nro Elementos: 1.000.000 (500.000 pares, 500.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 1.000.000 (500.000 pares, 500.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		
		vet = geraVetor(200_000, 800_000);

		System.out.println("Nro Elementos: 1.000.000 (200.000 pares, 800.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 1.000.000 (200.000 pares, 800.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(800_000, 200_000);

		System.out.println("Nro Elementos: 1.000.000 (800.000 pares, 200.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 1.000.000 (800.000 pares, 200.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");
		
		//*************************************************************		
		vet = geraVetor(5_000_000, 5_000_000);

		System.out.println("Nro Elementos: 10.000.000 (5.000.000 pares, 5.000.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 10.000.000 (5.000.000 pares, 5.000.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(2_000_000, 8_000_000);

		System.out.println("Nro Elementos: 10.000.000 (2.000.000 pares, 8.000.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 10.000.000 (2.000.000 pares, 8.000.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(8_000_000, 2_000_000);

		System.out.println("Nro Elementos: 10.000.000 (8.000.000 pares, 2.000.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 10.000.000 (8.000.000 pares, 2.000.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		//*************************************************************
		vet = geraVetor(50_000_000, 50_000_000);

		System.out.println("Nro Elementos: 100.000.000 (50.000.000 pares, 50.000.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 100.000.000 (50.000.000 pares, 50.000.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(20_000_000, 80_000_000);
		
		System.out.println("Nro Elementos: 100.000.000 (20.000.000 pares, 80.000.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 100.000.000 (20.000.000 pares, 80.000.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		vet = geraVetor(80_000_000, 20_000_000);
		
		System.out.println("Nro Elementos: 100.000.000 (80.000.000 pares, 20.000.000 impares) - aux");
		vetRes = pi.sepParImparAux1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");

		System.out.println("Nro Elementos: 100.000.000 (80.000.000 pares, 20.000.000 impares) - in place");
		vetRes = pi.sepParImparInPlace1(vet);
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getIteracoes());
		System.out.println("Nro Iteracoes:" + sb );
		sb.delete(0, sb.length());
		fmt.format("%,d", pi.getInstrucoes());
		System.out.println("Nro Instrucoes:" + sb + "\n\n");
	}
}
