package GUI.Frames;

import javax.swing.JOptionPane;

import Types.Product;

public class mouseclicked {
	
	public void clicksignOut(){
		
	}
	public void clickgoBack(){
		
	}
	public void clickaddToCart(){
		if (selectedProduct == null){
            System.out.println("no Product selected");
            JOptionPane.showMessageDialog(null, "Please select a Product");
            return;
        }

        boolean found = false;

        for (Product item : Cart.keySet()){
            System.out.println(item.productID + " | " + selectedProduct.productID);
            if (item.productID.equals(selectedProduct.productID)){
                found = true;
                break;
            }
        }

        if (found){

            System.out.println("Product already in cart");

            JOptionPane.showMessageDialog(null, "Product is already in cart");
            return;
        }

        //adds Product to cart
        System.out.println("Product added to cart:\n"+ selectedProduct.productName);//fuad step1: select a Product step 2 : click on add to cart button step3: cart.txt Product is added with quantity 1
        //addedProducts.add(new Product(selected, 1));
        Cart.put(selectedProduct, true);
	}
	public void clickSearch(){
		
	}
	public void clickgoToCart(){
		
	}

}
