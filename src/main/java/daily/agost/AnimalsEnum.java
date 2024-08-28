package daily.agost;

public enum AnimalsEnum {

    MAMAL(true), INVERTEBRE(false), BIRD(Boolean.FALSE),
    REPTILE(true), AMPHIBIAN(false), FISH( true){
        public int swim(){ return 3;}
    };
    final boolean hasHair;
     private AnimalsEnum(boolean hasHair){
         // by default the modifier is private for the constructor in an enum class
        this.hasHair = hasHair;
    }
     public boolean hasHair(){
        return hasHair;
     }
     public int swim(){return 0;}
}
