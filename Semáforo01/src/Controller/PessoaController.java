package Controller;

import java.util.concurrent.Semaphore;

public class PessoaController extends Thread {
	static int Mcorredor = 200;
	private int idP;
	private Semaphore semaforo;

	public PessoaController(int idPessoa, Semaphore semaforo) {
		this.idP = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {

		aCorredor();

		try {

			semaforo.acquire();
			PPorta();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			semaforo.release();

		}

	}

	private void aCorredor() {

		int vPessoa = (int) (Math.random() * 2) + 4;
		int lPessoa = 0;

		while (lPessoa < Mcorredor) {

			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			lPessoa += vPessoa;

			if (lPessoa > 200)
				lPessoa = 200;

			System.out.println("Pessoa #" + idP + " andou " + lPessoa + " metros 🦶\n(" + lPessoa + "/"
					+ Mcorredor + ")\n");

		}

		System.out.println("*** Pessoa " + idP + " chegou na porta ***\n");

	}

	private void PPorta() {

		System.out.println("Pessoa #" + idP + " está passando pela porta 😁\n");

		int tPassar = (int) (Math.random() * 1001) + 1000;

		try {
			sleep(tPassar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("*** Pessoa #" + idP + " passou pela porta ***\n" + "(Tempo: " + tPassar + "ms)\n");
	}
}