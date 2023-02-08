package com.board.util;

import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public enum MemberEnum {
	REALTOR("realtor"), LESSOR("lessor"), LESSEE("lessee");

	final String account_type;

	MemberEnum(String account_type) {
		this.account_type = account_type;
	}

	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}

	public static Map<String, Object> getAccountId(String account_id) {
		Map<String, Object> list = new HashMap<String, Object>();
		String result = "";
		if (account_id != null) {
			String[] accountType = account_id.split(" ");
			for (String memberList : accountType) {
				MemberEnum member = stream(values())
						.filter(value -> value.account_type.equals(memberList.toLowerCase())).findAny().orElse(null);
				if (member == null) {
					list.put("id", memberList);
				} else {
					list.put("account_type", member.toString());
				}
			}
		} else {
			list.put("id", "외부사용자");
			list.put("account_type", "customer");
		}
		return list;
	}
}
