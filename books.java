package myfirstjdbc;
public class books 
{
	String bid,author,bname,publication;
	long cost;
	int edition;
	public books() 
	{
		 System.out.println("u r in default constructor which is of no use");
	}
	public books(String bname,String author,String publication,long cost,int edition)
	{
		this.bname=bname;
		this.author=author;
		this.publication=publication;
		this.cost=cost;
		this.edition=edition;
		
	}
	public String getBid()
	{
		return bid;
	}
	public void setBid(String bid)
	{
		this.bid=bid;
	}
	public String getBname()
	{
		return bname;
	}
	public void setBname(String bname)
	{
		this.bname=bname;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public String getPublication()
	{
		return publication;
	}
	public void setPublication(String publication)
	{
		this.publication=publication;
	}
	public  long getCost()
	{
		return cost;
	}
	public void setCost(long cost)
	{
		this.cost=cost;
	}
	public int getEdition()
	{
		return edition;
	}
	public void setEdition(int edition)
	{
		this.edition=edition;
	}
	public String toString()
	{
		return ""+bid+"  "+bname+"  "+author+"  "+publication+"  "+cost+"  "+edition;
	}
}
