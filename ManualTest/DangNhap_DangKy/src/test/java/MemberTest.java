import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @org.junit.jupiter.api.Test
    void dangNhap() {
        Member mb = new Member();
        boolean result = mb.DangNhap("javaTpoint@domain.co.in","123456");
//        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","asdk87412","asdasdasdsa"};
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void dangNhapEmailEmpty() {
        Member mb = new Member();
        boolean result = mb.DangNhap("","123456");
//        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","asdk87412","asdasdasdsa"};
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void dangNhapPwEmpty() {
        Member mb = new Member();
        boolean result = mb.DangNhap("javaTpoint@domain.co.in","");
//        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","asdk87412","asdasdasdsa"};
        assertFalse(result);
    }
    @org.junit.jupiter.api.Test
    void DangKy() {
        Member mb = new Member();
        boolean result = mb.DangKy("Luân","Nguyễn","Name","1-6-2003","javaTpoint@domain.co.in","123456");
//        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","asdk87412","asdasdasdsa"};
        assertTrue(result);

    }
    @org.junit.jupiter.api.Test
    void DangKy2() {
        Member mb = new Member();
        boolean result = mb.DangKy("Kang","Huỳnh","Name","19-8-2003","javaTpoint@domain.com","1234567");
//        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","asdk87412","asdasdasdsa"};
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void DangKyFEmpty() {
        Member mb = new Member();
        boolean result = mb.DangKy("","Nguyễn","Name","1-6-2003","javaTpoint@domain.co.in","123456");
//        String[] AllUser = {"javaTpoint@domain.co.in","javaTpoint@domain.com","javaTpoint.name@domain.com","javaTpoint#@domain.co.in","javaTpoint@domain.com","javaTpoint@domaincom"};
        String[] AllUserPw ={"123456","1234567","12345","546844","asdk87412","asdasdasdsa"};
        assertFalse(result);

    }


}