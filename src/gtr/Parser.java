package gtr;

import java.util.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Parser {
	static HashMap<Integer, Double> koordinaten = new HashMap<Integer, Double>();

	public static HashMap<Integer, Double> parse(String args)
			throws ScriptException {
		if (!(args.length() == 0)) {
			validieren(args);
			return koordinaten;
		}
		koordinaten.put(0, 0.0);
		return koordinaten;
	}

	public static void validieren(String args) throws ScriptException {
			System.out.println(args);
			args.replaceAll("cos", "Math.cos");
			args.replaceAll("sin", "Math.sin");
			args.replaceAll("tan", "Math.tan");
			args.replaceAll("arcmath.sin", "Math.asin");
			args.replaceAll("arcmath.cos", "Math.acos");
			args.replaceAll("arcmath.tan", "Math.atan");
			args.replaceAll("pi", "Math.pi");
			args.replaceAll("ln", "Math.log");
			args.replaceAll("sqrt", "Math.sqrt");
			args.replaceAll("e", "Math.e");
			System.out.println(args);
			berechnen(args);	
	}

	public static void berechnen(String args) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		for (int i2 = -160; i2 < 2620; i2++) {
			String temp = args;
			temp = temp.replace("x", i2 + "");
			Object x = engine.eval(temp);
			try {
				Double y = (Double) x;
				koordinaten.put(i2, y);
			} catch (Exception e) {
				int z = (Integer) x;
				Double a = z + 0.0;
				koordinaten.put(i2, a);
			}
			System.out.println(koordinaten.get(i2));
			if (Double.isInfinite(koordinaten.get(i2))) {
				System.out.println("check");
			}
		}
	}
}
