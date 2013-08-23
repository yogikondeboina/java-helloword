package com.rhc.insurance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.drools.logger.KnowledgeRuntimeLogger;

import com.rhc.drools.reference.ClasspathKnowledgeBaseBuilder;
import com.rhc.drools.reference.CommandListBuilder;
import com.rhc.drools.reference.KnowledgeBaseBuilder;
import com.rhc.drools.reference.RuleFlowCommandListBuilder;
import com.rhc.drools.reference.StatelessDroolsComponent;
import com.rhc.insurance.test.repositories.CucumberMemberRepository;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuadrantSteps {

	private CucumberMemberRepository memberRepository;

	private StatelessDroolsComponent component;

	static KnowledgeRuntimeLogger logger;

	@Before
	public void setupComponent() {

		Set<String> resources = new HashSet<String>();
		// placeholder rules to be replaced by real rules soon
		resources.add("rules/lowPHlowBH.drl");
		resources.add("rules/lowPHhighBH.drl");
		resources.add("rules/highPHlowBH.drl");
		resources.add("rules/highPHhighBH.drl");

		KnowledgeBaseBuilder kBuilder = new ClasspathKnowledgeBaseBuilder(
				resources);
		CommandListBuilder commandListBuilder = new RuleFlowCommandListBuilder();

		component = new StatelessDroolsComponent();
		component.setKnowledgeBaseBuilder(kBuilder);
		component.setCommandListBuilder(commandListBuilder);

	}

	@Before
	public void init() {
		memberRepository = new CucumberMemberRepository();
	}

	@Given("^Member with:$")
	public void Member_with(DataTable members) throws Throwable {
		memberRepository.createMembers(members.asMaps());
	}

	@When("^determining quadrant$")
	public void determining_quadrant() throws Throwable {
		Collection<Member> members = memberRepository.getMembers();
		MemberRequest request = new MemberRequest();
		request.addFacts(members);
		System.out.println(component);
		component.execute(request, null);
	}

	@Then("^quadrant should be:$")
	public void quadrant_should_be(DataTable arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		// For automatic conversion, change DataTable to List<YourType>
		throw new PendingException();
	}

}
