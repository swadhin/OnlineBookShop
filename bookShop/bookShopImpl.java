import onlineBookShopApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
import java.io.*;
import java.lang.*;

class bookShopImpl extends bookShopPOA {

  private ORB orb;
  book[] bookContainer = new book[50];
  private int numofItems;
  private int mutex =1 ;	//For atomic transactions
  private int found = 0;
  private int keyfield = -1;
  private invoiceReturn iv;

  public void setORB(ORB orb_val) 
	{
    		orb = orb_val;
  	}

  public bookShopImpl()
	{
		super();
  		for(int i=0;i<50;i++)
		{
			bookContainer[i] = new book();
		}
		try{
			FileInputStream fstream = new FileInputStream("bookDatabase.txt");
			java.io.DataInputStream in = new java.io.DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			while((strLine = br.readLine()) != null)
			{
				String[] parts = strLine.split("\t");
				//System.out.println(parts.length);

				//Populating the data from file
				bookContainer[i].isbnNo=parts[0];
				bookContainer[i].bookName=parts[1];
				bookContainer[i].authorName=parts[2];
				bookContainer[i].publisherName=parts[3];
				bookContainer[i].bookPrice=Float.parseFloat(parts[4]);
				bookContainer[i].qtAvail=Integer.parseInt(parts[5]);
				bookContainer[i].qtTotal=Integer.parseInt(parts[6]);
						
				i++;
			}

			numofItems = i;
			in.close();

		   }catch(Exception e)
		{
			System.err.println("Error : " + e.getMessage());
		} 
	
	}

   public book search_By_isbnNo(String isbn) throws Unknown
	{
	  
	  book b=null;

	  for(int j=0;j < numofItems ; j++)
		{
			if(isbn.equals(bookContainer[j].isbnNo))
				{
					b=new book();
					b=bookContainer[j];
					found=1;
					keyfield=j;
				}
		}
	  return b;
	}
  
   public book search_By_bookName(String bname) throws Unknown
	{
	  book b=null;

	  for(int j=0;j < numofItems ; j++)
                {
                        if(bname.equals(bookContainer[j].bookName))
                                {
                                        b=new book();
                                        b=bookContainer[j];
					found=1;
					keyfield=j;
                                }
                }

	  return b;

	}

   public book search_By_authorName(String aname) throws Unknown
	{
	  book b=null;

	 for(int j=0;j < numofItems ; j++)
                {
                        if(aname.equals(bookContainer[j].authorName))
                                {
                                        b=new book();
                                        b=bookContainer[j];
					found=1;
					keyfield=j;
                                }
                }

	  return b;
	
	}

   public int order_Books(invoiceReturn ivR) throws Unknown
	{
		iv = new invoiceReturn();
		found=0;
		
		if(ivR.qtRequired > bookContainer[keyfield].qtAvail)
			return 0;
		else
		{
		if(mutex == 1)
		{
		mutex=0;
		iv.isbnNo=bookContainer[keyfield].isbnNo;
		iv.bookName=bookContainer[keyfield].bookName;
		iv.authorName=bookContainer[keyfield].authorName;
		iv.publisherName=bookContainer[keyfield].publisherName;
		iv.bookPrice=bookContainer[keyfield].bookPrice;
		iv.qtRequired=ivR.qtRequired;
		iv.totalPrice=bookContainer[keyfield].bookPrice*iv.qtRequired;
		iv.address=ivR.address;
		
		//Updation of quantity
		bookContainer[keyfield].qtAvail=bookContainer[keyfield].qtAvail-ivR.qtRequired;
		
		//Writing to the file which contains the database
		try
		{
		FileWriter fstream = new FileWriter("bookDatabase.txt");
     	 	BufferedWriter out = new BufferedWriter(fstream);
		
		for(int l=0;l < numofItems ; l++)
		{
			String str =bookContainer[l].isbnNo+"\t"+bookContainer[l].bookName+"\t"+bookContainer[l].authorName+"\t"+bookContainer[l].publisherName+"\t"+bookContainer[l].bookPrice+"\t"+bookContainer[l].qtAvail+"\t"+bookContainer[l].qtTotal+"\n";

			out.write(str);
		}

      		out.close();
		}catch(IOException e)
		{
			System.out.println("Error : " + e.getMessage());
		}
		System.out.println("Database File updated successfully.\n");
		mutex=1;
		}

		return 1;
		}
		
	}

   public invoiceReturn get_and_show_Invoice() throws Unknown
	{
	  invoiceReturn b=iv;
	  return b;
	
	}


}



