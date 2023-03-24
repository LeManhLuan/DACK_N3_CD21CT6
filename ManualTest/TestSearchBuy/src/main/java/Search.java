public class Search {
    public Boolean main(String name, int pro_Id, double price)
    {
//create an array of product object
        Product[] obj = new Product[5] ;
//create & initialize actual product objects using constructor
        obj[0] = new Product(23907,150000,"Bomber Jacket");
        obj[1] = new Product(91240, 150000,"Jacket Thunder");
        obj[2] = new Product(29823, 150000,"Backpack CHILI SS4");
        obj[3] = new Product(11908, 150000,"Backpack Wave Ss5");
        obj[4] = new Product(43590,150000,"Jacket Korea Line");
        for (int i = 0; i< obj.length ; i++ ){
            if (obj[i].getPro_name() ==name && obj[i].getPro_Id() == pro_Id && obj[i].getPrice() == price){
                obj[i].display();
                return true;
            }
        }
        return false;

    }
    public int GioHang(String SanPham, int sl)
    {
//create an array of product object
        Product[] obj = new Product[5] ;
//create & initialize actual product objects using constructor
        obj[0] = new Product(23907,150000,"Bomber Jacket");
        obj[1] = new Product(91240, 150000,"Jacket Thunder");
        obj[2] = new Product(29823, 150000,"Backpack CHILI SS4");
        obj[3] = new Product(11908, 150000,"Backpack Wave Ss5");
        obj[4] = new Product(43590,150000,"Jacket Korea Line");
        for (int i = 0; i< obj.length ; i++ ){
            int Price = 0;
            if (obj[i].getPro_name() == SanPham ){
                Price = obj[i].getPrice() * sl;
                return Price;
            }
        }
        return 0;

    }

class Product
{
    int pro_Id;

    public Product(int pro_Id, int price, String pro_name) {
        this.pro_Id = pro_Id;
        this.price = price;
        this.pro_name = pro_name;
    }

    public int getPrice() {
        return price;
    }

    int price;
    public int getPro_Id() {
        return pro_Id;
    }

    public String getPro_name() {
        return pro_name;
    }

    String pro_name;
    //Product class constructor
    public void display()
    {
        System.out.print("Product Id = "+pro_Id + "  " + " Product Name = "+pro_name);

    }


}}
