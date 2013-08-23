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
	
	public Member getMemberFromID(int id)
	{
		for (Member member : members)
		{
			if (member.getMemberID() == id)
			{
				return member;
			}
		}
		
		// we failed
		System.out.println("ERROR: could not find member with id "+id);
		return new Member();
		
	}
	
	public void print()
	{
		for (Member member : members)
		{
			//System.out.println();
			member.print();
		}
	}

	public void createMembers(List<Map<String, String>> maps)
	{
		members = new HashSet<Member>();
		System.out.println("members was null : "+(members==null));
		if ( maps.size() != 0 )
		{
			 for ( Map<String, String> map : maps )
			 {
				 System.out.println("map: "+map);
				 members.add(fromDataTable(map)); // UserStepFactory is a helper class for parsing data tables
			 }
		}
	}
	
	public static Member fromDataTable( Map<String, String> row )
	{
		Member member = new Member();
		if (row.get("memberID") != null)
		{
			member.setMemberID(Integer.valueOf(row.get("memberID")));
		}
		else
		{
			System.out.println("ERROR: No member ID found");
			System.out.println(row);
			//return;
		}
		
		if (row.get("asthmaRating") != null)
		{
			BigDecimal asthmaRating = new BigDecimal(row.get("asthmaRating"));
			member.setAsthmaRating(asthmaRating);
		}
		if (row.get("diabetesRating") != null)
		{
			BigDecimal diabetesRating = new BigDecimal(row.get("diabetesRating"));
			member.setDiabetesRating(diabetesRating);
		}
		if (row.get("cardiovascularRating") != null)
		{
			BigDecimal cardiovascularRating = new BigDecimal(row.get("cardiovascularRating"));
			member.setCardiovascularRating(cardiovascularRating);
		}
		
		
		
		if (row.get("depressionRating") != null)
		{
			BigDecimal depressionRating = new BigDecimal(row.get("depressionRating"));
			member.setDepressionRating(depressionRating);
		}
		if (row.get("anxietyRating") != null)
		{
			BigDecimal anxietyRating = new BigDecimal(row.get("anxietyRating"));
			member.setAnxietyRating(anxietyRating);
		}
		if (row.get("eatingDisorderRating") != null)
		{
			BigDecimal eatingDisorderRating = new BigDecimal(row.get("eatingDisorderRating"));
			member.setEatingDisorderRating(eatingDisorderRating);
		}
		
		// PH and BH
		if (row.get("physicalHealth") != null)
		{
			BigDecimal physicalHealth = new BigDecimal(row.get("physicalHealth"));
			member.setPhysicalHealth(physicalHealth);
		}
		if (row.get("behavioralHealth") != null)
		{
			BigDecimal behavioralHealth = new BigDecimal(row.get("behavioralHealth"));
			member.setBehavioralHealth(behavioralHealth);
		}
		
		// quadrant
				if (row.get("quadrant") != null)
				{
				//	int quadrant = new BigDecimal(row.get("physicalHealth"));
					member.setQuadrant(Integer.valueOf(row.get("quadrant")));
					//member.setPhysicalHealth(physicalHealth);
				}
		
		
        
        
        //member.setDiabetesRating(diabetesRating);
        //member.setCardiovascularRating(cardiovascularRating);

        return member;
	}

}
