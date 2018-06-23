
public class MobilePhone {
	public Boolean status;
	public Exchange basestation;
	int number;
	MobilePhone(int n){
		number = n;
	}
	public  int Number(){return number;}
	//spublic Boolean IsMobile(){if 
	public Boolean status(){return status;}
	public void switchOn(){status = true;}
	public void switchOff(){status = false;}
	public Exchange location(){return basestation;}
}
