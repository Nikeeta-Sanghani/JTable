package jtable;

import java.awt.EventQueue;

public abstract class jtable {

    public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable()
		{
	    	public void run()
	    	{
	    	  new myframe();
	    	    
	    	}
	});
	

    }

}
