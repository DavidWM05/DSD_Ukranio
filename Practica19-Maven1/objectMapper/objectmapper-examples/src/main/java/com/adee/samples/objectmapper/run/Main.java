package com.adee.samples.objectmapper.run;

import static com.adee.samples.objectmapper.run.ObjectMapperUtils.*;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//System.out.println("\n====================| 1 |====================\n");
		objectToJsonString();

		//System.out.println("\n====================| 2 |====================\n");
		objectToJsonInFile();

		//System.out.println("\n====================| 3 |====================\n");
		objectToBytes();

		//System.out.println("\n====================| 4 |====================\n");
		jsonStrToObject();

		//System.out.println("\n====================| 5 |====================\n");
		jsonInFileToObject();

		//System.out.println("\n====================| 6 |====================\n");
		readJsonStringAsMap();

		//System.out.println("\n====================| 7 |====================\n");
		readJsonArrayStringAsList();

		//System.out.println("\n====================| 8 |====================\n");
		parseJsonStringAsJsonNode();

		//System.out.println("\n====================| 9 |====================\n");
		createJsonNodeStr();

		//System.out.println("\n====================| 10 |====================\n");
		demoUnknownField();

		//System.out.println("\n====================| 11 |====================\n");
		demoNullPrimitiveValues();

		//System.out.println("\n====================| 12 |====================\n");
		objectWithDateToJsonString();

		//System.out.println("\n====================| 13 |====================\n");
		jsonStringWithDateToObject();

		//System.out.println("\n====================| 14 |====================\n");
		demoCustomSerializer();

		//System.out.println("\n====================| 15 |====================\n");
		demoCustomDeSerializer();
	}
}