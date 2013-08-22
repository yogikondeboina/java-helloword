package com.rhc.insurance.test.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.rhc.insurance.Member;
import com.rhc.insurance.repositories.MemberRepository;

public class CucumberMemberRepository implements MemberRepository {

	@Override
	public Collection<Member> getMembers() {
		return new ArrayList<Member>();
	}

	public void createMembers(List<Map<String, String>> maps) {

	}

}
