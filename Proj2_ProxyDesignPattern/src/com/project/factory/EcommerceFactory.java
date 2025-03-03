package com.project.factory;

import com.project.component.FlipkartService;
import com.project.component.FlipkartServiceRealImpl;
import com.project.proxy.FlipkartServiceProxy;

public class EcommerceFactory {

//	getInstance method - it will give either proxy or real object
	public static FlipkartService getInstance(String couponCode) {
		
		if(couponCode.equals("") || couponCode.trim().length() ==0) {
			return new FlipkartServiceRealImpl();
		}
		else {
			if(couponCode.equalsIgnoreCase("Hritik20"))
				return new FlipkartServiceProxy(20);
			else if (couponCode.equalsIgnoreCase("Hritik10"))
				return new FlipkartServiceProxy(10);
			else
				return new FlipkartServiceRealImpl();		
		}
	}
}
 