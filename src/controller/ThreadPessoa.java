package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{
	
	private int idPessoa;
	private Semaphore semaforo;
	
	
	public ThreadPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa=idPessoa;
		this.semaforo=semaforo;
	}

	@Override
	public void run() {
		andar();
		try {
			semaforo.acquire();
			cruzarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}



	private void andar() {
		int percorrido=0;
		int distancia=200;
		while (percorrido < distancia) {
			int anda = (int) ((Math.random() * 2) + 4);
			percorrido+=anda;
		}
		System.out.println(idPessoa + " chegou");
	}
	
	private void cruzarPorta() {
		int tempo = (int) ((Math.random()*1001)+1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(idPessoa + " cruzou a porta");
	}
	
}
