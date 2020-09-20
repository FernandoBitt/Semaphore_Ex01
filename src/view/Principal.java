package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		
		for(int idPessoa = 0; idPessoa<4; idPessoa++) {
			Thread tPessoa = new ThreadPessoa(idPessoa, semaforo);
			tPessoa.start();
		}
	}

}
