package gtr;

import java.util.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Parser {
	static HashMap<Integer, Double> koordinaten = new HashMap<Integer, Double>();

	public static void parse(List<String> args) throws ScriptException {
		validieren(args);
		berechnen(args);
	}

	public static void validieren(List<String> args) {
		for (int i = 0; i < args.size(); i++) {
			System.out.println(args.get(i));
			args.set(i, args.get(i).replace("cos", "Math.cos"));
			args.set(i, args.get(i).replace("sin", "Math.sin"));
			args.set(i, args.get(i).replace("tan", "Math.tan"));
			args.set(i, args.get(i).replace("arcmath.sin", "Math.asin"));
			args.set(i, args.get(i).replace("arcmath.cos", "Math.acos"));
			args.set(i, args.get(i).replace("arcmath.tan", "Math.atan"));
			args.set(i, args.get(i).replace("pi", "Math.pi"));
			args.set(i, args.get(i).replace("ln", "Math.log"));
			args.set(i, args.get(i).replace("sqrt", "Math.sqrt"));
			args.set(i, args.get(i).replace("e", "Math.e"));
			System.out.println(args.get(i));
		}
	}

	public static void berechnen(List<String> args) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		for (int i = 0; i < args.size(); i++) {
			for (int i2 = 0; i2 < 100; i2++) {
				String temp = args.get(i);
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
}