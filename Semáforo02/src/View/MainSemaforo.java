package View;

import java.util.concurrent.Semaphore;

import Controller.CarroController;

public class MainSemaforo {
	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 4; i++) { // Ativa 4 threads (pessoas)

			CarroController carro = new CarroController(i, semaforo);
			carro.start();

		}
	}
}