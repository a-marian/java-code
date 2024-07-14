package daily.july;

import java.util.*;

public class ChemicalFormula {

    public static void main(String[] args) {
      System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
        public static String countOfAtoms(String formula) {
            //  Map<String, Integer> elements = new HashMap<>();
            List<Element> elements = new ArrayList<>();
            char[] string = formula.toCharArray();
            Stack<Element> stack = new Stack();
            Stack<Integer> multiplicadors = new Stack();
            int multi = 0;
            for(int i=1; i< string.length; i++){
                if(string[i] == '('){
                  multiplicadors.push(1);
                    continue;
                }
                if(string[i] == ')'){
                    if(i < string.length && Character.isDigit(string[i+1])){
                        multi = multiplicadors.peek() * Character.getNumericValue(string[i+1]);
                        multiplicadors.pop();
                        continue;
                    }
                }
                while(!stack.isEmpty() && multi > 1){
                    Element ele = stack.peek();
                    ele.value = ele.value * multi;
                    elements.add(ele);
                    stack.pop();

                }

                if(string[i] != '(' && string[i]!= ')' &&  multi == 0){
                    if(Character.isUpperCase(string[i-1]) && Character.isDigit(string[i])){
                        elements.add(new Element(Character.toString(string[i-1]), Character.getNumericValue(string[i])));
                    }
                    if(Character.isUpperCase(string[i-1])  && !Character.isDigit(string[i])){
                        elements.add(new Element(Character.toString(string[i-1]), 1));
                    }
                    if(Character.isUpperCase(string[i-1]) && Character.isLowerCase(string[i])){
                        String key = string[i-1]+""+string[i];
                        if( i < string.length-1 && Character.isDigit(string[i+1])){
                            elements.add(new Element(key, Character.getNumericValue(string[i+1])));
                        }else{
                            elements.add(new Element(key, 1));
                        }
                    }
                    if(Character.isUpperCase(string[i]) && i == string.length-1){
                        elements.add(new Element(Character.toString(string[i]), 1));
                    }
                }
                if(string[i] != '(' && string[i]!= ')' &&  multi == 1){
                    if(Character.isUpperCase(string[i-1]) && Character.isDigit(string[i])){
                        stack.push(new Element(Character.toString(string[i-1]), Character.getNumericValue(string[i])));
                    }
                    if(Character.isUpperCase(string[i]) && i < string.length && !Character.isDigit(string[i+1])){
                        stack.push(new Element(Character.toString(string[i]), 1));
                    }
                    if(Character.isUpperCase(string[i-1]) && Character.isLowerCase(string[i])){
                        String key = string[i-1]+""+string[i];
                        if( i < string.length-1 && Character.isDigit(string[i+1])){
                            stack.push(new Element(key, Character.getNumericValue(string[i+1])));
                        }else{
                            stack.push(new Element(key, 1));
                        }
                    }
                    if(Character.isUpperCase(string[i]) && i == string.length-1){
                        stack.push(new Element(Character.toString(string[i]), 1));
                    }
                }

            }
            StringBuilder result = new StringBuilder();
            for (var entry : elements) {
                result.append(entry.name);
                if (entry.value > 1){
                    result.append(entry.value);
                }

            }
            return result.toString();
        }

    }
class Element{
    String name;
    int value;
    Element(String name, int value){
        this.name = name;
        this.value = value;
    }
}