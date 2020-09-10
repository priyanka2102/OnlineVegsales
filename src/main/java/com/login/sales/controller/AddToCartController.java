package com.login.sales.controller;

import java.util.HashMap;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.sales.api.ApiResponse;
import com.login.sales.jwtconfig.ShoppingConfiguration;
import com.login.sales.model.AddToCart;
import com.login.sales.service.AddToCartService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api/addToCart")
public class AddToCartController {

	@Autowired
	AddToCartService cartService;
	
	@RequestMapping("addProduct")
  	public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"productId","userId","qty","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
			}
			long productId = Long.parseLong(addCartRequest.get("productId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			List<AddToCart> obj = cartService.addCartbyUserIdAndProductId(productId,userId,qty,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	@RequestMapping("updateQtyForCart")
  	public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"cartId","userId","qty","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
			}
			long cartId = Long.parseLong(addCartRequest.get("cartId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			 cartService.updateQtyByCartId(cartId, qty, price);
			 List<AddToCart> obj = cartService.getCartByUserId(userId);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	
	@RequestMapping("removeProductFromCart")
  	public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String,String> removeCartRequest) {
		try {
			String keys[] = {"userId","cartId"};
			if(ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {
				
			}
			List<AddToCart> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}		
   }
}
