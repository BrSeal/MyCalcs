public class NoSuchButtonException extends NullPointerException
{
	String errMessage;
	NoSuchButtonException(String s){
		super();
		errMessage="Button not found \""+s+"\"";
	}
}
