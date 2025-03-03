package com.project.component;

//Concrete Class/ Real Class
public class FlipkartServiceRealImpl implements FlipkartService {

	@Override
	public float buyNow(String[] items, float[] prices) {
		float bill = 0;
		
//		Calculate bill
		for(float p:prices) {
			
			bill = bill+p;
		}
		
		
		return bill;
	}

}
