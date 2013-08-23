package com.rhc.insurance;

import java.util.Collection;
import java.util.HashSet;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 27258dc1740a5b467c7076ecad18d71755f9e927
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

public class HealthSteps {

	// private CucumberMemberRepository memberRepository;

	private List<Map<String, String>> memberRepository;

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

	// @Before
	// public void init() {
	// memberRepository = new CucumberMemberRepository();
	//
	// }

	@Given("^Member with:$")
	public void Member_with(DataTable members) throws Throwable {
<<<<<<< HEAD
		memberRepository.createMembers(members.asMaps());
		/*
		 * 
		List<Map<String, String>> users = usersTable.asMaps();
        someUsers = new HashSet<User>();

        if ( users.size() != 0 ) {
            for ( Map<String, String> user : users ) {
                someUsers.add( UserStepFactory.fromDataTable( user ) ); // UserStepFactory is a helper class for parsing data tables
            }
        }
		 * 
		 */
=======
		// memberRepository.createMembers(members.asMaps());
		List<Map<String, String>> memberRepository = members.asMaps();
		someUsers = new HashSet<User>();

		if (users.size() != 0) {
			for (Map<String, String> member : memberRepository) {
				someUsers.add(UserStepFactory.fromDataTable(user));
			}
		}
>>>>>>> 27258dc1740a5b467c7076ecad18d71755f9e927
	}
	

	
	
	/*
	 * @Given( "^these users already exist:$" )
public void _Register_a_new_user_I_have_these_Users( DataTable usersTable ) throws Throwable {
        List<Map<String, String>> users = usersTable.asMaps();
        someUsers = new HashSet<User>();

        if ( users.size() != 0 ) {
            for ( Map<String, String> user : users ) {
                someUsers.add( UserStepFactory.fromDataTable( user ) ); // UserStepFactory is a helper class for parsing data tables
            }
        }
}


This method is an example of how to parse the table

public static User fromDataTable( Map<String, String> row ) {
        String username = row.get( "username" );
        String password = row.get( "password" );
        String uid = row.get( "uuid" );

        User user = new User( username, password );

        return user;
}
	 * 
	 */

	@When("^determining PH risk level$")
	public void determining_PH_risk_level() throws Throwable {
		Collection<Member> members = memberRepository.getMembers();
		MemberRequest request = new MemberRequest();
		request.addFacts(members);
		System.out.println(component);
		component.execute(request, null);
	}

	@Then("^PH risk level should be:$")
	public void PH_risk_level_should_be(DataTable arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		// For automatic conversion, change DataTable to List<YourType>
		throw new PendingException();
	}

}
