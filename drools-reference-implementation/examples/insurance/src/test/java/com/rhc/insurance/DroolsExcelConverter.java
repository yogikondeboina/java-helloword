package com.rhc.insurance;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.drools.definition.KnowledgePackage;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * This class will create a drl file from excel sheet
 * and then execute the rules.
 */
public class DroolsExcelConverter {
	
	public static void run()
	{
		// Create knowledge builder
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		// Create drl file from excel sheet
		InputStream is =null;
		try {
			is = new FileInputStream("/home/sklenkar/apps/BRMS_DEMO/bmeisele/java-helloword/drools-reference-implementation/examples/insurance/src/main/resources/rules/HealthQuadrantRules.xls");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Create compiler class instance
		SpreadsheetCompiler sc = new SpreadsheetCompiler();

		// Compile the excel to generate the (.drl) file
		StringBuffer drl=new StringBuffer(sc.compile(is, InputType.XLS));

		// Insert dialect value into drl file
		drl.insert(drl.indexOf("DROOLS")+40,"dialect \"mvel\""+"\n");

				// Check the generated drl file
				System.out.println("Generate DRL file is showing below–: ");
		System.out.println(drl);

		// writing string into a drl file
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("/home/sklenkar/apps/BRMS_DEMO/bmeisele/java-helloword/drools-reference-implementation/examples/insurance/src/main/resources/rules/HealthQuadrantRules.drl"));
			out.write(drl.toString());
			out.close();
		}
		catch (IOException e){
			System.out.println("Exception ");
		}
		// Wait before using the drl file in the next section.
		/*
		try {
			//Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// End creation of drl file from excel sheet

		// Using DRL file
		kbuilder.add(ResourceFactory.newClassPathResource("RuleFile.drl", DroolMessage.class ), ResourceType.DRL );

		// Check the builder for errors
		if ( kbuilder.hasErrors() ) {
			System.out.println("kbuilder has errors");
			System.out.println( kbuilder.getErrors().toString());
		}
		// get the compiled packages (which are serializable)
		final Collection pkgs = kbuilder.getKnowledgePackages();

		// add the packages to a knowledgebase (deploy the knowledge packages).
		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(pkgs);

		// Create stateful session
		final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		// Set event listeners
		ksession.addEventListener(new DebugAgendaEventListener());
		ksession.addEventListener(new DebugWorkingMemoryEventListener());

		// Create message text
		DroolMessage messagetxt = new DroolMessage();
		messagetxt.setMessage(“FlightNumber”);

		DroolMessage messagetxt1 = new DroolMessage();
		messagetxt1.setMessage(“FlightCode”);

		// Insert into session and fire rules
		System.out.println(“insert into session”);
		ksession.insert(messagetxt);
		ksession.insert(messagetxt1);
		System.out.println(“before firing rules”);
		ksession.fireAllRules();
		System.out.println(“after firing rules”);
		ksession.dispose();
		System.out.println(“after dispose”);
		*/
	}
}