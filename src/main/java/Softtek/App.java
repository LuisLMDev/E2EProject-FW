package Softtek;

import resources.Base;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App extends Base {

    public static void main( String[] args ) throws IOException {

        Base base = new Base();
        base.InitializeDriver();
        System.out.println( "Hello World!" );

    }

}
