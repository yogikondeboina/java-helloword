package com.rhc.insurance;

import com.rhc.insurance.test.repositories.CucumberMemberRepository;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.logger.KnowledgeRuntimeLogger;

import com.rhc.drools.reference.ClasspathKnowledgeBaseBuilder;
import com.rhc.drools.reference.CommandListBuilder;
import com.rhc.drools.reference.KnowledgeBaseBuilder;
import com.rhc.drools.reference.ReaderKnowledgeBaseBuilder;
import com.rhc.drools.reference.RuleFlowCommandListBuilder;
import com.rhc.drools.reference.StatelessDroolsComponent;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class HealthQuadrantSteps
{

	 private CucumberMemberRepository memberRepository;
	// private CucumberMemberRepository memberRepositoryResults;
	 
	 private Member member;
	 //private Member memberResult;

	//private List<Map<String, String>> memberRepository;

	private StatelessDroolsComponent component;

	static KnowledgeRuntimeLogger logger;

	@Before
	public void setupComponent()
	{

		Set<BufferedReader> resources = new HashSet<BufferedReader>();

		DroolsExcelConverter dec = new DroolsExcelConverter();
		
		
		resources.add(dec.buildReader("rules/HealthQuadrantRules.xls"));
		
		//buildKnowledgeBaseFromBufferedReader(dec.run());
		
		// placeholder rules to be replaced by real rules soon
	//	resources.add("rules/HealthQuadrantRules.xls");
		//resources.add("rules/HealthQuadrantRules.drl");
		//resources.add("rules/setBH.drl");

		KnowledgeBaseBuilder kBuilder = new ReaderKnowledgeBaseBuilder(
				resources);
		CommandListBuilder commandListBuilder = new RuleFlowCommandListBuilder();

		component = new StatelessDroolsComponent();
		component.setKnowledgeBaseBuilder(kBuilder);
		component.setCommandListBuilder(commandListBuilder);

	}

	@Before
	public void init()
	{
		memberRepository = new CucumberMemberRepository();
	//	memberRepositoryResults = new CucumberMemberRepository();
		
		// calculate mapping between 
		
		//member = new Member();
		//memberRepository.createSingleMember(m)
		
	}
	
	@Given("^a member Joe$")
	public void a_member_Joe() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		member = new Member();
		memberRepository.createSingleMember(member);
	    //throw new PendingException();
	}
	
	@Given("^Joe has condition \"([^\"]*)\" of degree \"([^\"]*)\"$")
	public void Joe_has_condition_of_degree(String conditionArg, String degreeArg) throws Throwable
	{
		member = new Member();
		//ValueEnum conditionEnumVal = ValueEnum.fromString(myString);
		CONDITIONS condition = CONDITIONS.valueOf(conditionArg);
		switch (condition)
		{
			case depression:
				
				member.setDepressionDegree(degreeArg);
				break;
				
			case anxiety:
				
				member.setAnxietyDegree(degreeArg);
				break;
				
			case asthma:
				
				member.setAsthmaDegree(degreeArg);
				break;
		}
		
	    // Express the Regexp above with the code you wish you had
	 //   throw new PendingException();
	}
	
	public enum CONDITIONS
	{
		asthma,
		depression,
		anxiety
	}

	/*
	@Given("^Joe has severe depression$")
	public void Joe_has_severe_depression() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	*/

	@When("^determining the health quadrant for Joe$")
	public void determining_the_health_quadrant_for_Joe() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
		
		Collection<Member> members = memberRepository.getMembers();
		//System.out.println("MEMBERS: "+members);
		//members.print();
		MemberRequest request = new MemberRequest();
		request.addFacts(members);
		System.out.println(component);
		component.execute(request, null);
	}

	@Then("^Joe should be placed in Quadrant (\\d+)$")
	public void Joe_should_be_placed_in_Quadrant(int quadrantArg) throws Throwable
	{
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
		System.out.println("OUTPUT TEST XLS");
		memberRepository.print();
		
		assertEquals(member.getQuadrant(), quadrantArg);
	}

	@Then("^a call should be scheduled for (\\d+) days later$")
	public void a_call_should_be_scheduled_for_days_later(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
		
		// true
	}
}
