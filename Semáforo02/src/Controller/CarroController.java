package Controller;

import java.util.concurrent.Semaphore;

public class CarroController extends Thread {
	static String DCarro;
	private int idCarro;
	private Semaphore semaforo;

	public CarroController(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {

		try {

			semaforo.acquire();
			DirecaoCarro();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			semaforo.release();

		}

	}

	private void DirecaoCarro() {

		if (idCarro == 1) {
			DCarro = "Esquerda para direita\n";
		}
		if (idCarro == 2) {
			DCarro = "Direita para esquerda\n";
		}
		if (idCarro == 3) {
			DCarro = "Cima para baixo\n";
		}
		if (idCarro == 4) {
			DCarro = "Baixo para cima\n";
		}
		System.out.println("🚗 Carro #" + idCarro + " está indo sentido: " + DCarro);
		try {
			sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println("*** 🚗 Carro #" + idCarro + " Passou ***\n");

	}
}
