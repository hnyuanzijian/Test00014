package com.yuanzijian01.itcast.thread;
/*
����: ���̾����������е�Ӧ�ó��� �����˸������ڴ�ռ仮�֡�

�̣߳� һ�������е� ���������߳�ȥִ�еģ��߳�Ҳ���ǽ�����һ��ִ��·����

���̣߳� һ���������ж���߳̿���ͬʱִ������


���߳� �ĺô���
	1. ���һ�������п���ͬʱִ�ж����������⡣
	2. �������Դ�����ʡ�

���̵߳ı׶ˣ�
	1. ������cpu�ĸ�����
	2. ������һ���������߳� ��ִ�и��ʡ�
	3. �������߳� ��ȫ���⡣
	4. ��������������
	

�Զ����߳� ��ʵ�ַ�ʽ��
	
	��ʽһ �� 
		1. �Զ���һ����̳�Thread�ࡣ
		2. ��дThread���run���������Զ����̵߳��������д��run�����ϡ�
		3. ����Thread��������󣬲��ҵ���start��������һ���̡߳� 
		
	ע�⣺ǧ��Ҫֱ�ӵ���run����������start������ʱ���߳̾ͻῪ�����߳�һ�������ͻ�ִ��run�����д��룬���ֱ�ӵ���
	run��������ô�� �൱�ڵ�����һ����ͨ�ķ������ѡ�
	
	
�̰߳�ȫ���⣺

�̰߳�ȫ���� �ĸ���ԭ��
	1. �������������������� ���̶߳�����ͬһ����Դ��
	2. ���̲߳���������Դ�Ĵ��� �ж�䡣
	


�̰߳�ȫ����Ľ��������
	
	��ʽһ�� ����ʹ��ͬ�������ȥ�����
	
	��ʽ��
		synchronized(������){
			��Ҫ��ͬ���Ĵ���
		}
	
ͬ�������Ҫע������
	1. ����������������һ������
	2. һ���߳���ͬ���������sleep�ˣ��������ͷ�������
	3. ������������̰߳�ȫ���⣬ǧ��Ҫʹ��ͬ������飬��Ϊ�ή��Ч�ʡ�
	4. ����������Ƕ��̹߳�����һ����Դ����������ס��
	
	
	��ʽ����ͬ������  ��  ͬ����������ʹ��synchronized����һ��������
	
	ͬ������Ҫע������� ��
		1. �����һ���Ǿ�̬��ͬ���������� ������this��������Ǿ�̬��ͬ���������� �����ǵ�ǰ��������������ֽ����ļ���class���󣩡�
		2. ͬ���������������ǹ̶��ģ�����������ָ�� �ġ�

	
	�Ƽ�ʹ�ã� ͬ������顣
		ԭ��
			1. ͬ���������������������������ָ����������ơ�ͬ���������������ǹ̶� �ģ�������������ָ����
			2. ͬ���������Ժܷ��������Ҫ��ͬ������ķ�Χ��ͬ�������������������� �����д��붼��ͬ���ˡ�
			


���� һ�������˻�5000�飬������һ������ ���ۣ�һ�����ſ�����ʼȡǮ������ÿ��ֻ��ȡһǧ�飬Ҫ��׼�����̰߳�ȫ���⡣
		
*/

class BankThread extends Thread{
	
	static	int count = 5000;
	
	public BankThread(String name){
		super(name);
	}
	
	@Override  //
	public synchronized  void run() {
		while(true){
			synchronized ("��") {				
				if(count>0){
					System.out.println(Thread.currentThread().getName()+"ȡ����1000��,��ʣ��"+(count-1000)+"Ԫ");
					count= count - 1000;
				}else{
					System.out.println("ȡ����...");
					break;
				}
			}
		}
	}	
	
	
	//��̬�ĺ���---->�������� ������ֽ����ļ�����--->BankThread.class  Ψһ�ġ�
	public static synchronized  void getMoney(){
		
	}
	
}


public class Demo1 {

	public static void main(String[] args) {
		//���������̶߳���
		BankThread thread1 = new BankThread("�Ϲ�");
		BankThread thread2 = new BankThread("����");
		//����start���������߳�ȡǮ
		thread1.start();
		thread2.start();
		
		
	}
	
}