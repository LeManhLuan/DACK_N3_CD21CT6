import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member {
    public boolean DangNhap(String email, String Password){
        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","154848121ádsa","asdk87412","asdasdasdsa"};
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        for (int i = 0; i < AllUser.length; i++) {
        if (matcher.matches() == true && !email.isEmpty() && !Password.isEmpty() && email.equals(AllUser[i]) &&  Password.equals(AllUserPw[i]) && AllUserPw[i].length() >= 4) {
            return true;
            }
        }
        return false;
    }
    public Boolean DangKy(String fname,String lname, String gender, String date, String email, String Password){
        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","154848121ádsa","asdk87412","asdasdasdsa"};
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        for (int i = 0; i < AllUser.length; i++) {
            if (matcher.matches() == true && email != AllUser[i] && !fname.isEmpty() && !gender.isEmpty() && !date.isEmpty()) {

                return true;
            }
        }
        return false;
    }
}
