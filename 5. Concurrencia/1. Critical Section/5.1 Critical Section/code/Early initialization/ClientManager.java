public class ClientManager {

	public static void main(String[] args) {

		FileProcess proceso1 = new FileProcess("Thread 1 is wrtting");
		proceso1.start();
		FileProcess proceso2 = new FileProcess("Thread 2 is writting");
		proceso2.start();
	}
}

class FileProcess extends Thread {
	private String msgLog;

	public FileProcess(String msg) {
		this.msgLog = msg;
	}

	@Override
	public void run() {
		long t1,t2,t3,tObtener,tRegistrar;
		Logger fileLogger;
		for (int i = 0; i < 50; i++) {
			t1 = System.nanoTime();
			fileLogger = FileLogger.getFileLogger();
			t2 = System.nanoTime();
			fileLogger.log(msgLog);
			t3 = System.nanoTime();
			tObtener = t2-t1; // Tiempo que tardo en obtener el registrador de mensajes
			tRegistrar = t3-t2; // Tiempo que tardo en escribir el mensaje
			//System.out.println(tObtener + "\t" + tRegistrar);
			System.out.println(msgLog.charAt(7)+","+tObtener+" \t"+ "," + tRegistrar);
		}
	}

}
