import java.io.*;
import java.lang.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import onlineBookShopApp.*;

public class bookShopClient
{
	static bookShop bookShopImpl;
	static book mbook=null;

	 public static void main(String args[]) 
	{
	try
	{
	// create and initialize the ORB
        ORB orb = ORB.init(args, null);

        // get the root naming context
        org.omg.CORBA.Object objRef =
            orb.resolve_initial_references("NameService");

        // Use NamingContextExt instead of NamingContext. This is 
        // part of the Interoperable naming Service.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

	// resolve the Object Reference in Naming
        String name = "bookShop";
        bookShopImpl = bookShopHelper.narrow(ncRef.resolve_str(name));

	System.out.println("--------------------------------------------------------------------------------------------------");
	System.out.println("					GetYourBooks						      ");
	System.out.println("--------------------------------------------------------------------------------------------------");
	System.out.println("\nSEARCH OPTIONS : ");
	System.out.println("\t1.Search by ISBN no.");
	System.out.println("\t2.Search by Book name.");
	System.out.println("\t3.Search by Author name.");
	System.out.println("\nEnter  Your  Choice  :");
	BufferedReader br=null;
	int che=-1;
	String isbn=null,bkname=null,atname=null,s=null,addrs=null,ats=null;

	try
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		String choice = br.readLine();
		
		che = Integer.parseInt(choice);
	}catch(IOException e){
		e.printStackTrace();
	}    
	
	mbook = new book();

	switch(che)
	{
		case 1 :
			System.out.println("Enter the ISBN No. : ");
			 try
        		{
				br = new BufferedReader(new InputStreamReader(System.in));
	                	isbn = br.readLine();

			 }catch(IOException e){
                		e.printStackTrace();
        		}
			mbook=bookShopImpl.search_By_isbnNo(isbn);
			break;
		case 2 :
			System.out.println("Enter the Book Name. : ");
                         try
                        {
                                br = new BufferedReader(new InputStreamReader(System.in));
                                bkname = br.readLine();

                         }catch(IOException e){
                                e.printStackTrace();
                        }
			mbook=bookShopImpl.search_By_bookName(bkname);

			break;
		case 3 :
			System.out.println("Enter the Author Name : ");
                         try
                        {
                                br = new BufferedReader(new InputStreamReader(System.in));
                                atname = br.readLine();

                         }catch(IOException e){
                                e.printStackTrace();
                        }
			mbook=bookShopImpl.search_By_authorName(atname);

			break;
		default :
			System.out.println("Not a Valid Choice.\n");
	}

	System.out.println("\tSearch Result :");
	if(mbook != null)
	{
		System.out.println("\tISBN NO.\tBOOK NAME\tAUTHOR \tPUBLISHER\tPRICE\tAV. QTY\tTOTAL QTY.");
System.out.println("\t"+mbook.isbnNo+"\t"+mbook.bookName+"\t"+mbook.authorName+"\t"+mbook.publisherName+"\t"+mbook.bookPrice+"\t"+mbook.qtAvail+"\t"+mbook.qtTotal);  

		System.out.println("Do you want to order the book(Y/N) : ");
		  try
                        {
                                br = new BufferedReader(new InputStreamReader(System.in));
                                s = br.readLine();

                         }catch(IOException e){
                                e.printStackTrace();
                        }
		if(s.equals("Y"))
		{
			System.out.println("Enter your Shipping address (in one line ) :");
			try
                        {
                                br = new BufferedReader(new InputStreamReader(System.in));
                                addrs = br.readLine();

                         }catch(IOException e){
                                e.printStackTrace();
                        }

			System.out.println("Enter the number of quantity required : ");
			  try
                        {
                                br = new BufferedReader(new InputStreamReader(System.in));
                                ats = br.readLine();
			
				int qty = Integer.parseInt(ats);
				invoiceReturn ivcr = new invoiceReturn();
				ivcr.qtRequired=qty;
				ivcr.address=addrs;
				ivcr.bookName="def";
				ivcr.authorName="def";
				ivcr.publisherName="def";
				ivcr.bookPrice=0;
				ivcr.totalPrice=0;
				ivcr.isbnNo="def";
				int k = bookShopImpl.order_Books(ivcr);
				
				if(k==0)
					System.out.println("Available quantity is insufficient to process your request :( \n");

				else
					{
					invoiceReturn nivcr = new invoiceReturn();
					nivcr=bookShopImpl.get_and_show_Invoice();
					System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("                                    INVOICE                                                  ");
        System.out.println("--------------------------------------------------------------------------------------------------");
	System.out.println("SHIPPING ADDRESS :  "+nivcr.address); 
	System.out.println("BOOK NAME :  "+nivcr.bookName); 
	System.out.println("AUTHOR NAME :  "+nivcr.authorName); 
	System.out.println("PUBLISHER NAME :  "+nivcr.publisherName); 
	System.out.println("ISBN NO :  "+nivcr.isbnNo); 
	System.out.println("QUANTITY ORDERED :  "+nivcr.qtRequired); 
	System.out.println("BOOK PRICE :  "+nivcr.bookPrice); 
	System.out.println("TOTAL PRICE :  "+nivcr.totalPrice+"\n"); 
			
		System.out.println("Thank You.. Visit & Shop Again :)\n");
					}

                         }catch(IOException e){
                                e.printStackTrace();
                        }

		}
		else
			System.out.println("Thank You.. Visit & Shop Again :)\n");

	}
	else
		System.out.println("The book is not present or check your book name again !!");

	}catch (Exception e) {
          System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
          }

	}

}
