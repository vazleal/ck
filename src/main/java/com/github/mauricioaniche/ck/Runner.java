package com.github.mauricioaniche.ck;

import com.github.mauricioaniche.ck.util.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {

	private static final Logger logger = Logger.getLogger(Runner.class.getName());

	private void validateArgs(String[] args) {
		if (args == null || args.length < 1) {
			logger.severe(
					"Usage: java -jar ck.jar <path to project> <use Jars=true|false> <max files per partition, 0=automatic selection> <print variables and fields metrics? True|False> <path to save the output files>");
			System.exit(1);
		}
	}

	private boolean shouldUseJars(String[] args) {
		if (args.length >= 2)
			return Boolean.parseBoolean(args[1]);
		return false;
	}

	private int getMaxAtOnce(String[] args) {
		if (args.length >= 3)
			return Integer.parseInt(args[2]);
		return 0;
	}

	private boolean getVariablesAndFields(String[] args) {
		if (args.length >= 4)
			return Boolean.parseBoolean(args[3]);
		return true;
	}

	private ResultWriter instantiateResultWriter(String[] args) throws IOException {
		String outputDir = "";
		if (args.length >= 5)
			outputDir = args[4];

		return new ResultWriter(outputDir + "class.csv", outputDir + "method.csv",
		outputDir + "variable.csv", outputDir + "field.csv", getVariablesAndFields(args));
	}

	private String getPath(String[] args) {
		return args[0];
	}

	private void setIgnoredDirectories(String[] args) {
		for (int i = 5; i < args.length; i++) {
			FileUtils.IGNORED_DIRECTORIES.add(args[i]);
		}
	}

	private void calculateAndWriteResults(String[] args) throws IOException {
		ResultWriter writer = instantiateResultWriter(args);

		Map<String, CKClassResult> results = new HashMap<>();

		new CK(shouldUseJars(args), getMaxAtOnce(args), getVariablesAndFields(args)).calculate(getPath(args), new CKNotifier() {
			@Override
			public void notify(CKClassResult result) {
				results.put(result.getClassName(), result);
			}

			@Override
			public void notifyError(String sourceFilePath, Exception e) {
				logger.log(Level.SEVERE, String.format("Error in %s ", sourceFilePath), e);
			}
		});

		for (Map.Entry<String, CKClassResult> entry : results.entrySet()) {
			writer.printResult(entry.getValue());
		}

		writer.flushAndClose();
	}

	public static void main(String[] args) throws IOException {
		Runner runner = new Runner();
		runner.validateArgs(args);
		runner.setIgnoredDirectories(args);
		runner.calculateAndWriteResults(args);
		
		logger.info("Metrics extracted!!!");
	}
}
