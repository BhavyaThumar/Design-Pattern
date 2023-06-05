interface State{
    public void handelState();

}

class State1 implements State{

    public void handelState() {
        System.out.println("Handling State 1  You may go to State2");
    }
    
}

class State2 implements State{

    public void handelState() {
        System.out.println("Handling State 2  You may go to State3");
    }
    
}

class State3 implements State{

    public void handelState() {
        System.out.println("Handling State 3  You may go to initial State");
    }
    
}

class Context {

    State st;

    public Context(State s){
        st = s;
    }

    public void setState(State s) {
        st = s;
    }

    public State getSt()
    {
        return st;
    }

    public void performAction() {
        st.handelState();
    }

}

public class State_Pattern1
{
    public static void main(String[] args) {
        
        State s1 = new State1();
        State s2 = new State2();
        State s3 = new State3();

        Context c1 = new Context(s2);
        c1.performAction();

        c1.setState(s3);

        c1.performAction();
    }
}