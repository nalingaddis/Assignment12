package main;

import gradingTools.comp401f17.assignment12.testcases.Assignment12Suite;
import util.trace.Tracer;

public class RunTests {
	public static void main(String[] args) {
		Tracer.showInfo(true);
		Assignment12Suite.main(args);
	}
}
