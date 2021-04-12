public class NoSuchButtonException extends NullPointerException
{
//Thrown on no existing button pushed
	String errMessage;
	NoSuchButtonException(String s){
		super();
		errMessage="Button not found \""+s+"\"";
	}
}
