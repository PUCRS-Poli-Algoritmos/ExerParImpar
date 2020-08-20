package br.pucrs.exercontagem;

public class ParImpar {
	private long iteracoes = 0;
	private long instrucoes = 0;
	
	public long getIteracoes() {
		return iteracoes;
	}

	public void setIteracoes(long iteracoes) {
		this.iteracoes = iteracoes;
	}
	
	public void incrIteracoes(long incr) {
		setIteracoes(getIteracoes() + incr);
	}

	public long getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(long instrucoes) {
		this.instrucoes = instrucoes;
	}

	public void incrInstrucoes(long incr) {
		setInstrucoes(getInstrucoes() + incr);
	}
	
	private void resetCounters() {
		setIteracoes(0);
		setInstrucoes(0);
	}
	
	public int[] sepParImparAux1(int [] vet) {
		resetCounters();
		
		int [] vetAux = new int[vet.length];
		incrInstrucoes(3);
		
		int pos = 0;	
		incrInstrucoes(1);
		
		incrInstrucoes(1);
		for (int i = 0; i < vet.length; i++){
			incrInstrucoes(4);
			incrIteracoes(1);
			
			incrInstrucoes(3);
			if (vet[i] % 2 == 0){
				incrInstrucoes(5);
				vetAux[pos] = vet[i];
				pos++;
			}
		}
		
		incrInstrucoes(1);
		for (int i = 0; i < vet.length; i++){	
			incrInstrucoes(4);
			incrIteracoes(1);
			
			incrInstrucoes(3);
			if (vet[i] % 2 == 1){
				incrInstrucoes(5);
				vetAux[pos] = vet[i];
				pos++;
			}
		}
		
		incrInstrucoes(1);
		return vetAux;
	}
	
	public int[] sepParImparInPlace1(int [] vet) {
		resetCounters();
		
		incrInstrucoes(7);
//		int [] vetAux = vet.clone();
//		incrIteracoes(vetAux.length);
		
		int [] vetAux = vet;
		int aux;
		int ini = 0, fim = vetAux.length-1;
		while (ini < fim) {
			incrInstrucoes(1);
			while ((ini < fim) && (vet[ini] % 2 == 0)){
				incrIteracoes(1);  incrInstrucoes(5); incrInstrucoes(2);
				ini++;		
				}
			while ((ini < fim)  && (vet[fim] % 2 == 1)){
				incrIteracoes(1);    incrInstrucoes(5);  incrInstrucoes(2);
				fim--;  	
				}
			incrInstrucoes(1);
			if (ini < fim){              incrInstrucoes(11);
				aux = vetAux[ini];
				vetAux[ini] = vetAux[fim];
				vetAux[fim] = aux;
				ini++;
				fim--;	                 incrIteracoes(1);  
				}
			}
		incrInstrucoes(1);
		return vetAux;}
	
	public String toString(int [] vet) {
		StringBuilder res = new StringBuilder("");
		int cont = 0;
		
		for (int i:vet) {
			res.append(i + " ");
			cont++;
			if (cont == 30){
				res.append("\n");
				cont = 0;
			}
		}

		return res.toString();
	}
}
