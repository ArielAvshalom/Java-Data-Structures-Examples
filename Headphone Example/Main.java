public class Main {

    //public class headphone { //if name of file is headphone add this line and remove main line. Also change Main in the 
        public String name;
        public String size;
        public int cost;
        public String color;
        public String type;
  
        //public headphone(String name, String size, int cost, String color, String type) {
          public Main(String name, String size, int cost, String color, String type) {
          this.name = name;
          this.size = size;
          this.cost = cost;
          this.color = color;
          this.type = type;
  
        }
  
        public String getName(){
          return name;
        }
        public String getSize(){
          return size;
        }
        public int getCost(){
          return cost;
        }
        public String getColor(){
          return color;
        }
        public String getType(){
          return type;
        }
  
        public String infomercial() {
            return ("\n\nThe name of your headphone model is "  + this.getName() + ", the size is " + this.getSize() + " the cost is $" + this.getCost() + ", the color is " + this.getColor() + " and the type is " + this.getType() + ".");
        }
  
    //}
  
  
    public static void main (String[] args) {
            Main XM4 = new Main("Sony XM4", "Swallow your Ears", 350, "Space Gray", "Over Ear");
            //XM4.name = "Sony XM4";
            //XM4.size = "Enough to swallow your head";
            //XM4.cost = 350;
            //XM4.color = "Space Gray";
            //XM4.type = "Over Ear";
  
            System.out.println(XM4.infomercial());
          }
  }
  