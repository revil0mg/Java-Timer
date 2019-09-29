

public class TimerModel {
	private static long startTime;
	private static long curTime;
    
    static void start() {
    	//startTime = System.currentTimeMillis() - curTime;
    	startTime = System.currentTimeMillis();
    }
    
//    static void stop() {
//    	stopTime = System.currentTimeMillis();
//    }
    
//    static boolean isRunning() {
//		
//    	return false;
//    }
    

	public static long elapsedTime() {
		curTime = System.currentTimeMillis() - startTime;
		return curTime;
	}
    

}
