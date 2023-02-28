package chapter03.item17.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * item17. 변경 가능성을 최소화 하라.
 * 완벽 공략 - CountDownLatch
 * 다른 여러 스레드로 실행하는 여러 오퍼레이션이 마칠 때까지 기다릴 때 사용할 수 있는 유틸리티
 */
public class ConcurrentExample
{
	public static void main(String[] args) throws InterruptedException
	{
		int N = 10;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);
		
		for (int i = 0; i< N; i++) // create and start threads
		{
			new Thread(new Worker(startSignal, doneSignal)).start();
		}
		
		ready(); // don't let run yet
		startSignal.countDown(); // let all threads proceed
		doneSignal.await(); // wait for all to finish
		done();
		
	}
	
	private static void ready()
	{
		System.out.println("ready~~~");
	}
	
	private static void done()
	{
		System.out.println("done~~~");
	}
	
	private static class Worker implements Runnable
	{
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;
		
		public Worker(CountDownLatch startSignal, CountDownLatch doneSignal)
		{
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}
		
		@Override
		public void run()
		{
			try
			{
				startSignal.await();
				doWork();
				doneSignal.countDown();
			}
			catch (InterruptedException e) {
			
			}
		}
		
		 void doWork()
		{
			System.out.println("working thread : " + Thread.currentThread().getName());
		}
	}
}
