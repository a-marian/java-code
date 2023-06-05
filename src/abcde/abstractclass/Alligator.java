package abcde.abstractclass;

 abstract class Alligator {

     final static int number = 0;
     final String name;
     Alligator(String name){
         this.name = name;
     }

     abstract void createAlligator();

      abstract void updateAlligator();

      private void initializeAlligator(){
       System.out.println(name);
      }


    public static void main(String[] args) {
      //  var all = new Alligator();
    }
}
