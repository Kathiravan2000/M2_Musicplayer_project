package kathiravan;

public class User {
	
	int userid;
    String username;
    String emailid;
    String passcode;

    public User(int userid,String username,String emailid,String passcode)
    {
        this.userid=userid;
        this.username=username;
        this.emailid=emailid;
        this.passcode=passcode;
    }

    public int getUserid()
    {
        return userid;
    }
    public String getUsername()
    {
        return  username;
    }
    public String getEmailid()
    {
        return emailid;
    }
    public String getPasscode()
    {
        return passcode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + emailid + '\'' +
                ", passcode='" + passcode + '\'' +
                '}';
    }
}

