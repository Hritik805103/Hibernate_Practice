package com.project.proxy;

import com.project.component.FlipkartService;
import com.project.component.FlipkartServiceRealImpl;

//proxy class
public class FlipkartServiceProxy implements FlipkartService {

	private FlipkartService flipkartservice;
	float discount;
	
	public FlipkartServiceProxy(float discount) {
		flipkartservice = new FlipkartServiceRealImpl();
		this.discount = discount;
	}
	
	
	@Override
	public float buyNow(String[] items, float[] prices) {
		float billAmt = 0;
		float finalBillAfterDiscount = 0;
		
		for(float p:prices) {
			billAmt = billAmt + p;
		}
		
		finalBillAfterDiscount = (billAmt - (billAmt*discount/100));
		
		return finalBillAfterDiscount;
	}

}
