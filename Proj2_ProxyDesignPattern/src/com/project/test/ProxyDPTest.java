package com.project.test;

import com.project.component.FlipkartService;
import com.project.factory.EcommerceFactory;

public class ProxyDPTest {

	public static void main(String[] args) {
		
		FlipkartService service = null;
		
		String couponCode = "";
		service = EcommerceFactory.getInstance(couponCode);
		
		System.out.println("Real or Proxy class:- "+ service.getClass());
		float bill = service.buyNow(new String[] {"TsShirts", "Shoes"}, new float[] {420.0f, 1200.0f});
		System.out.println(bill);	
	}
}