package myThreadTest.pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskCallable implements Callable<String>{
	
	private int s;
	Random r = new Random();
	public TaskCallable(int s){
		this.s = s;
	}

	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(name+" 启动时间：" + currentTimeMillis/1000);
		
		int rint = r.nextInt(3);
		try {
			Thread.sleep(rint*1000);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
		System.out.println(name + " is working..."+s);
		return s+"";
	}
//	public static void main(String[] args) {
//		
//		TaskCallable pool = new TaskCallable(10);
//		try {
//			pool.call();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
