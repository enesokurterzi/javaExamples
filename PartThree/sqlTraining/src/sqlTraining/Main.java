package sqlTraining;

public class Main {

	public static void main(String[] args) {
		
		//ANSII standartları ile yazılır.
		//Case insensitive olduğu için büyük küçük harf farketmez.
		
		SELECT * FROM Customers; //Customers tablosunun tamamını gösterir.
		
		SELECT ContactName,CustomerName,City FROM Customers; //İstenilen sütunların bulunduğu bir tablo oluşturup gösterir.
		
		SELECT ContactName Adi,CustomerName Sirketadi,City Sehir FROM Customers; //Tabloda istenilen sütunların ismi değiştirilerek çağırılır.

		SELECT * from customers where City = 'London'; //where ile koşul yapılır.
				
		select * from products where categoryId=1 or categoryId=3;
		
		select * from products where categoryId=1 and Price >= 10;
		
		select * from products order by productname; //istenilen sütuna göre sıralama yapar.
		
		select * from products order by categoryid,productname; //ilk verilen parametreye göre sıralama yaparken ilk parametre değeri aynı olanları da içinde ikinci parametreye göre sıralar.
		
		select * from products order by price asc; //order by default olarak asc yani ascending olur yani yazılmasa da aynı sonucu verir.
		
		select * from products order by price desc; //azalan şekilde verir.
		
		select * from Products where CategoryID = 1 order by price desc;
		
		select count(*) from Products;// seçilen tablodaki eleman sayısını verir
		
		select CategoryID from Products group by CategoryID; // seçilen parametreyi tekrar etmiyecek şekilde sıralar
		
		select CategoryID,count(*) from Products group by CategoryID; // seçilen parametreye göre sıralarken bu parametreleri içeren kaç tane sıra olduğunu da yazar.

		select CategoryID,count(*) from Products group by CategoryID having count(*) < 10;// kümülatif değerler üzerinde işlem yapmak istediğimizde "having" kullanırız
		
		select CategoryID,count(*) from Products where Price > 20 group by CategoryID having count(*) < 10;
		
		select * from Products inner join Categories on Products.CategoryID = Categories.CategoryID; // verilen eşitlik doğru olduğunda istenilen parametreyi ekler
		
		select Products.ProductID, Products.ProductName, Products.Price, Categories.CategoryName
		from Products inner join Categories 
		on Products.CategoryID = Categories.CategoryID;
		
		select * from Products p inner join Orderdetails od on p.ProductID = od.ProductID; //Tablolar için kısaltma kullanılabilir, left join solda olup sağda olmayanları da yazdırır.

		select * from Customers c left join Orders o
		on c.CustomerID = o.CustomerID
		where o.CustomerID is null;
		
		select * from Products p inner join OrderDetails od
		on p.ProductID = od.ProductID
		inner join Orders o
		on o.OrderID = od.OrderID; // bu şekilde çoklu tablo eklemeleri de yapılabilir
		
		
	}

}
