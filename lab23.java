package myfirstjdbc;
import java.util.*;
public class lab23 
{
	public static void main(String []args)
	{
		bookservice bs=new bookservice();
		//verify user
		boolean valid=bs.verifyUser("sri", "jlcindia");
		if(valid)
			System.out.println("login successful redirecting to homepage");
		else
			System.out.println("login failed try again");
		//adding the book
		books b=new books("java","srinivas","jlc",250,4);
		boolean res=bs.addBook(b);
		if(res)
			System.out.println("book added succcesfully");
		else
			System.out.println("error while adding book info");
		//update books
		books bk=new books("jdbc","dande","sd",250,5);
		bk.setBid("B-02");
		int a=bs.updateBook(bk);
		System.out.println("book updated:"+a);
		//delete books
		int c=bs.deleteBook("B-01");
		System.out.println("book deleted:"+c);
		//accessing book by bid
		System.out.println("**book by bid");
		books bo=bs.getBookByBid("B-01");
		System.out.println(bo);
		//accessing book by Bname
		System.out.println("**book by bname");
		List<books> list=bs.getBookByname("java");
		for(books b1:list)
		{
			System.out.println(b1);
		}
		//accessing book by author
		System.out.println("** book by author");
		List<books> list1=bs.getBooksByAuthor("srinivas");
		for(books b1:list1)
		{
			System.out.println(b1);
		}
		//accessing book by cost
		System.out.println("** book by cost");
		List<books> list2=bs.getBooksByCost(250);
		for(books b1:list2)
		{
			System.out.println(b1);
		}
		//accessing all books
		System.out.println("** all books");
		List<books> list3=bs.getAllBooks();
		for(books b1:list1)
		{
			System.out.println(b1);
		}
		
		
		
		
	}

}
