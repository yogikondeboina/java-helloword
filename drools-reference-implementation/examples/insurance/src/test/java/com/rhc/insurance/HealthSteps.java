package com.rhc.insurance;

import com.rhc.insurance.test.repositories.CucumberMemberRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.logger.KnowledgeRuntimeLogger;

import com.rhc.drools.reference.ClasspathKnowledgeBaseBuilder;
import com.rhc.drools.reference.CommandListBuilder;
import com.rhc.drools.reference.KnowledgeBaseBuilder;
import com.rhc.drools.reference.RuleFlowCommandListBuilder;
import com.rhc.drools.reference.StatelessDroolsComponent;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class HealthSteps {

	 private CucumberMemberRepository memberRepository;
	 private CucumberMemberRepository memberRepositoryResults;

	//private List<Map<String, String>> memberRepository;

	private StatelessDroolsComponent component;

	static KnowledgeRuntimeLogger logger;

	@Before
	public void setupComponent() {

		Set<String> resources = new HashSet<String>();
		// placeholder rules to be replaced by real rules soon
		resources.add("rules/setPH.drl");
		resources.add("rules/setBH.drl");

		KnowledgeBaseBuilder kBuilder = new ClasspathKnowledgeBaseBuilder(
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
		memberRepositoryResults = new CucumberMemberRepository();
	}

	@Given("^Member with PH:$")
	public void Member_with_PH(DataTable members) throws Throwable
	{
		//memberRepository = new CucumberMemberRepository();
		
		
		memberRepository.createMembers(members.asMaps());
	}
	
	@Given("^Member with BH:$")
	public void Member_with_BH(DataTable members) throws Throwable
	{
		//memberRepository = new CucumberMemberRepository();

		memberRepository.createMembers(members.asMaps());
	}

	@When("^determining PH risk level$")
	public void determining_PH_risk_level() throws Throwable {
		determine_risk_level();
	}
	
	@When("^determining BH risk level$")
	public void determining_BH_risk_level() throws Throwable {
		determine_risk_level();
	}
	
	public void determine_risk_level() throws Throwable {
		Collection<Member> members = memberRepository.getMembers();
		//memberRepository.print();
		MemberRequest request = new MemberRequest();
		request.addFacts(members);
		System.out.println(component);
		component.execute(request, null);
	}

	@Then("^PH risk level should be:$")
	public void PH_risk_level_should_be(DataTable arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		// For automatic conversion, change DataTable to List<YourType>
		
		memberRepository.print();
		
		System.out.println("creating PH member result repo");
		memberRepositoryResults.createMembers(arg1.asMaps());
		
		
		// loop through 
		for (Member member : memberRepository.getMembers())
		{
			int id = member.getMemberID();
			
			// determine BH and PH score
			
			// find corresponding result member
			Member memberResult = memberRepositoryResults.getMemberFromID(id);
			
			// if their healths are the same
			if (member.getPhysicalHealth().equals(memberResult.getPhysicalHealth()))
			{
				// we succeeded
				System.out.println("SUCCESS: ph health was equal "+member.getPhysicalHealth());
			}
			else
			{
				System.out.println("FAILURE: ph health was equal "+member.getPhysicalHealth());
				
			}
			
			assertEquals(member.getPhysicalHealth(), memberResult.getPhysicalHealth());
		}
		
		//members.print
		
		//throw new PendingException();
	}
	
	@Then("^BH risk level should be:$")
	public void BH_risk_level_should_be(DataTable arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		// For automatic conversion, change DataTable to List<YourType>
		
		memberRepository.print();
		
		memberRepositoryResults.createMembers(arg1.asMaps());
		
		
		// loop through 
		for (Member member : memberRepository.getMembers())
		{
			int id = member.getMemberID();
			
			// determine BH and PH score
			
			// find corresponding result member
			Member memberResult = memberRepositoryResults.getMemberFromID(id);
			
			// if their healths are the same
			if (member.getBehavioralHealth().equals(memberResult.getBehavioralHealth()))
			{
				// we succeeded
				System.out.println("SUCCESS: ph health was equal "+member.getBehavioralHealth());
			}
			else
			{
				System.out.println("FAILURE: ph health was equal "+member.getBehavioralHealth());
				
			}
			
			assertEquals(member.getBehavioralHealth(), memberResult.getBehavioralHealth());
		}
		
		//members.print
		
		//throw new PendingException();
	}
}
