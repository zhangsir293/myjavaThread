package myThreadTest.myLockTest;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author zhang293
 *直接使用Lock接口，需要实现很多方法，ReentrantLock（可重入锁）是唯一实现了Lock的类
 */
public class MyLockTest {
	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	static Lock lock = new ReentrantLock(); // 注意这个地方
	public static <T> void main(String[] args) {
		new Thread() {
			public void run() {
				Thread thread = Thread.currentThread();
				
				lock.lock();
				try {
					System.out.println(thread.getName() + "得到了锁");
					for (int i = 0; i < 5; i++) {
						arrayList.add(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					System.out.println(arrayList);
					System.out.println(thread.getName() + "释放了锁");
					lock.unlock();
				}

			};
		}.start();
		
		new Thread() {
			public void run() {
				Thread thread = Thread.currentThread();
				lock.lock();
				try {
					System.out.println(thread.getName() + "得到了锁");
					for (int i = 0; i < 5; i++) {
						arrayList.add(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					System.out.println(arrayList);
					System.out.println(thread.getName() + "释放了锁");
					lock.unlock();
				}

			};
		}.start();
	}

}
