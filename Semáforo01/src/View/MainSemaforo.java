package View;

import java.util.concurrent.Semaphore;

import Controller.PessoaController;

public class MainSemaforo {
	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 4; i++) { 
			PessoaController corredor = new PessoaController(i, semaforo);
			corredor.start();
		}
	}
}