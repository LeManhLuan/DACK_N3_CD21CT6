import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void main() {
        Search search = new Search();
        int epx = 150000;
        int result = search.GioHang("Bomber Jacket",1);
        assertEquals(epx,result);
    }
    @Test
    void main3() {
        Search search = new Search();
        int epx = 300000;
        int result = search.GioHang("Bomber Jacket",2);
        assertEquals(epx,result);
    }
    @Test
    void main2() {
        Search search = new Search();
        boolean result = search.main( "Jacket Thunder", 23907, 150000);
        assertFalse(result);
    }

}