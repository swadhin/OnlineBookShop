package onlineBookShopApp;


/**
* onlineBookShopApp/bookShopPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

public abstract class bookShopPOA extends org.omg.PortableServer.Servant
 implements onlineBookShopApp.bookShopOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("search_By_isbnNo", new java.lang.Integer (0));
    _methods.put ("search_By_bookName", new java.lang.Integer (1));
    _methods.put ("search_By_authorName", new java.lang.Integer (2));
    _methods.put ("order_Books", new java.lang.Integer (3));
    _methods.put ("get_and_show_Invoice", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // onlineBookShopApp/bookShop/search_By_isbnNo
       {
         try {
           String isbn = in.read_string ();
           onlineBookShopApp.book $result = null;
           $result = this.search_By_isbnNo (isbn);
           out = $rh.createReply();
           onlineBookShopApp.bookHelper.write (out, $result);
         } catch (onlineBookShopApp.Unknown $ex) {
           out = $rh.createExceptionReply ();
           onlineBookShopApp.UnknownHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // onlineBookShopApp/bookShop/search_By_bookName
       {
         try {
           String bname = in.read_string ();
           onlineBookShopApp.book $result = null;
           $result = this.search_By_bookName (bname);
           out = $rh.createReply();
           onlineBookShopApp.bookHelper.write (out, $result);
         } catch (onlineBookShopApp.Unknown $ex) {
           out = $rh.createExceptionReply ();
           onlineBookShopApp.UnknownHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // onlineBookShopApp/bookShop/search_By_authorName
       {
         try {
           String aname = in.read_string ();
           onlineBookShopApp.book $result = null;
           $result = this.search_By_authorName (aname);
           out = $rh.createReply();
           onlineBookShopApp.bookHelper.write (out, $result);
         } catch (onlineBookShopApp.Unknown $ex) {
           out = $rh.createExceptionReply ();
           onlineBookShopApp.UnknownHelper.write (out, $ex);
         }
         break;
       }

       case 3:  // onlineBookShopApp/bookShop/order_Books
       {
         try {
           onlineBookShopApp.invoiceReturn ivR = onlineBookShopApp.invoiceReturnHelper.read (in);
           int $result = (int)0;
           $result = this.order_Books (ivR);
           out = $rh.createReply();
           out.write_long ($result);
         } catch (onlineBookShopApp.Unknown $ex) {
           out = $rh.createExceptionReply ();
           onlineBookShopApp.UnknownHelper.write (out, $ex);
         }
         break;
       }

       case 4:  // onlineBookShopApp/bookShop/get_and_show_Invoice
       {
         try {
           onlineBookShopApp.invoiceReturn $result = null;
           $result = this.get_and_show_Invoice ();
           out = $rh.createReply();
           onlineBookShopApp.invoiceReturnHelper.write (out, $result);
         } catch (onlineBookShopApp.Unknown $ex) {
           out = $rh.createExceptionReply ();
           onlineBookShopApp.UnknownHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:onlineBookShopApp/bookShop:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public bookShop _this() 
  {
    return bookShopHelper.narrow(
    super._this_object());
  }

  public bookShop _this(org.omg.CORBA.ORB orb) 
  {
    return bookShopHelper.narrow(
    super._this_object(orb));
  }


} // class bookShopPOA
