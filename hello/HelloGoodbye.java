// javac hello/HelloGoodbye.java
// java hello.HelloGoodbye

package hello;

public class HelloGoodbye {

    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + " and " + args[1] + ".\nGoodbye " + args[1] + " and " + args[0] + ".");
    }
}
