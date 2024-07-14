package abcde.sealed.intefaces;

public class TestExpressions {

    public static void main(String[] whatever) {
        System.out.println(
                new TimesExpr(
                        new PlusExpr(
                                new ConstantExpr(6), new ConstantExpr(7)),
                        new NegExpr(new ConstantExpr(8))
                        ).eval());
    }
}

sealed interface Expression permits ConstantExpr, PlusExpr, TimesExpr, NegExpr{
    public int eval();
}

final class ConstantExpr implements Expression {
    int number;
    ConstantExpr(int number) {
        this.number = number;
    }
    public int eval(){ return number;}
}

final class PlusExpr implements Expression {
    Expression a, b;
    PlusExpr(Expression a, Expression b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int eval() {
        return a.eval() + b.eval();
    }
}

final class TimesExpr implements Expression {
    Expression a, b;
    TimesExpr(Expression a, Expression b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int eval() {
        return a.eval() * b.eval();
    }
}

final class NegExpr implements Expression {
    Expression exp;
    NegExpr(Expression exp){
        this.exp = exp;
    }

    @Override
    public int eval() {
        return -exp.eval();
    }
}
