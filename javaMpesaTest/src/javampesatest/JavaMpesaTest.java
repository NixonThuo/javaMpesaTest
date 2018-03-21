/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

import java.io.IOException;
import org.json.JSONException;

/**
 *
 * @author DEVWK008
 */
public class JavaMpesaTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.json.JSONException
     */
    public static void main(String[] args) throws IOException, JSONException {
        // TODO code application logic here
        TestViewer v = new TestViewer();
        v.setVisible(true);
    }
    
}
