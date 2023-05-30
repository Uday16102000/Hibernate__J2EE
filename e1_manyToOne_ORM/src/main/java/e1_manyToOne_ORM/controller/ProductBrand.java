package e1_manyToOne_ORM.controller;
import java.util.Scanner;
import e1_manyToOne_ORM.dto.*;
import e1_manyToOne_ORM.dao.*;
public class ProductBrand {

	public static void main(String[] args) {
		
	
	Scanner s= new Scanner(System.in);
    boolean check=true;
    BrandCrud crud= new BrandCrud();
    ProductCrud crud2= new ProductCrud();
	do {
		
		System.out.println("Choose the option \n 1.save Brand \n 2.save Product \n 3.savingProductWithBrand \n 4.deleteProductwithId \n 5.deleteBrand With Id \n 6.updateProduct \n 7.updateBrand \n 8.fetchBrandById \n 9.fetchPrdoductById");
		
		int choice=s.nextInt();
		switch(choice) {
		case 1:{
//			System.out.println("Enter brand id");
//			int id= s.nextInt();
			System.out.println("Enter brand name");
			String brandName=s.next();
			Brand b= new Brand(brandName);
			crud.saveBrand(b);
			
		}break;
		case 2:{
			System.out.println("Enter product name");
			String productName=s.next();
			System.out.println("Enter product cost");
			String productCost=s.next();
			System.out.println("Enter brand id");
			int id=s.nextInt();
			Products product= new Products(productName,productCost);
			crud2.saveProduct(product, id);
		}break;
		case 3:{
			System.out.println("Enter brand name");
			String bname=s.next();
			System.out.println("Enter Product Name");
			String pname=s.next();
			System.out.println("Enter Product Cost");
			String pcost=s.next();
			Brand b= new Brand(bname);
			Products p= new Products(pname,pcost,b);
			
			crud2.saveproductWithBrand(p);
			
			Products product= new Products();
		}break;
		case 4:{
			System.out.println("Enter id of product to be deleted");
			int pid=s.nextInt();
			
			crud2.deleteProduct(pid);
		}break;
		case 5:{
			System.out.println("Enter id of brand to be deletd");
			
			int bid=s.nextInt();
			
			
			System.out.println("WARNING"+ "Without unmapping products with brand of  " + bid + "this brand cant be deleted");

			crud.deleetBrand(bid);
		}break;
		case 6:{
			System.out.println("Enter id of product to be updated");
		int id= s.nextInt();
		System.out.println("Enter the edited cost");
		String cost=s.next();
		
		
		Products p= new Products();
		p.setProductCost("5000");
		
		crud2.updateProduct(p, id);
		
		}
		case 7:{
			System.out.println("Enter id of brand to be edited");
			int bid=s.nextInt();
			System.out.println("Enter the new Brand name");
			String bname=s.next();
			
			Brand b= new Brand();
			b.setBrandName(bname);
			crud.updateBrand(b, bid);
		}break;
		case 8:{
			System.out.println("Ënter the id of brand to be fetched");
			int id=s.nextInt();
			
			crud.fetchBrandById(id);
		}break;
		case 9:{
			System.out.println("Ënter the id of product to be fetched");
			int id=s.nextInt();
			crud2.fetchProductById(id);
			
		}break;
		default:{
			System.out.println("Enter the number from above list");
		}break;
		}
		
	}while(check);
	
}}
