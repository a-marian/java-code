package abcde.comparing;

public class Product implements Comparable<Product>{

    private int id;
    private String name;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Product)) return false;
        var other = (Product) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Product p) {
      return this.name.compareTo(p.name);
    }
}
