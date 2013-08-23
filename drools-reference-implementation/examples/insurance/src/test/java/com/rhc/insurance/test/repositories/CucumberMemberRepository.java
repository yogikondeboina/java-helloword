package com.rhc.insurance.test.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.math.BigDecimal;

import com.rhc.insurance.Member;
import com.rhc.insurance.repositories.MemberRepository;

public class CucumberMemberRepository implements MemberRepository
{
	public HashSet<Member> members;
	
	
	@Override
	public Collection<Member> getMembers()
	{
		//return new ArrayList<Member>();
		return members;
	}

	public void createMembers(List<Map<String, String>> maps)
	{
		members = new HashSet<Member>();
		
		 if ( maps.size() != 0 )
		 {
	         for ( Map<String, String> map : maps )
	            {
	            	members.add(fromDataTable(map)); // UserStepFactory is a helper class for parsing data tables
	            }
	        }
	}
	
	public static Member fromDataTable( Map<String, String> row )
	{
		Member member = new Member();
		if (row.get("asthmaRating") != null)
		{
			BigDecimal asthmaRating = new BigDecimal(row.get("asthmaRating"));
			member.setAsthmaRating(asthmaRating);
		}
        BigDecimal diabetesRating = new BigDecimal(row.get("diabetesRating"));
        BigDecimal cardiovascularRating = new BigDecimal(row.get("cardiovascularRating"));

        
        
        member.setDiabetesRating(diabetesRating);
        member.setCardiovascularRating(cardiovascularRating);

        return member;
	}

}
