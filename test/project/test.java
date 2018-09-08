package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.rzpt.util.Base64;

public class test {
	public void ioTest() throws IOException {
		File f1 = new File("C:/Users/Administrator/Desktop/logo.png");
		File f2 = new File("C:/Users/Administrator/Desktop/logo2.png");
		InputStream is = null;
		OutputStream os = null;
		try {
			byte[] buffer = new byte[10000];
			is = new FileInputStream(f1);
			os = new FileOutputStream(f2);
			// �������������ļ��Ķ�����λȡ��byte[](����)������byte�����뻺�棬Ȼ�󽫶�ȡ�Ķ�����ת��Ϊʮ���ƣ�0~255�������ء�

			// һ��byte(�ֽ�)�ǰ˸�������λ�����Թ��ʱ�׼��

			// write(byte[] b, int off, int len)
			// ����˼�ǣ�b�Ǳ���д�����ݣ�off�Ǵ����￪ʼд��len�����д�ĳ���
			while ((is.read(buffer)) != -1) {
				os.write(buffer, 0, buffer.length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}

	public void cloneTest() throws CloneNotSupportedException {
		User u = new User("kty", 15);
		User u2 = (User) u.clone();
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u.equals(u2));
		u.setName("qq");
		System.out.println(u.equals(u2));
		System.out.println(u);
		System.out.println(u2);
		System.out.println(new NullPointerException() instanceof Exception);
	}

	public static void main(String[] args) throws InterruptedException {
		// new test().cloneTest();

		try{
			for (int i = 1; i <= 10; i++) {
				System.out.println("���ǵ�" +i+ "��ѭ��");
				if(i==7){
					throw new Exception("����һ���쳣");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(500L);
			System.out.println("�һ������ִ��");
		}

	}
}