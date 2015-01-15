package progpro;
/*
 * Diese Datei ist für alle Globale Variabeln.
 * Bitte verwendet privates oder protected mit getter/setter struktur.
 */
public class Globals {
	private static boolean debugmode = true;
	private static int WindowsizeX = 0;
	private static int WindowsizeY = 0;
	
	
	public static boolean isDebugmode() {
		return debugmode;
	}
	public static void setDebugmode(boolean debugmode) {
		Globals.debugmode = debugmode;
	}
	public static int getWindowsizeX() {
		return WindowsizeX;
	}
	public static void setWindowsizeX(int windowsizeX) {
		WindowsizeX = windowsizeX;
	}
	public static int getWindowsizeY() {
		return WindowsizeY;
	}
	public static void setWindowsizeY(int windowsizeY) {
		WindowsizeY = windowsizeY;
	}
	
}
