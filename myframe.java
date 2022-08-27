/*THIS A TABLE BUILD WITH CHECKBOX WITH REFERENCE AS EXCEL
 * GIVES A POPUP BOX FOR DATA THAT IS GETTING SELECTED
 */

package jtable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class myframe extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    public JFrame myframe;
    public JTable mytable;
    public JButton btn=new JButton("Get Selected");
    //Constructor
    public myframe()
    {
	myframe=new JFrame("JTable with custom column Demo");
	myframe.setLayout(null);
	myframe.setBounds(100,100,400,300);
	myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// following method is to quickly add data to the table
// however following method of data and column headers will not work if you have custom column
	
	//Object[][] data= {{"Bhavin","Sanghani",true},{"Nandita","Sanghani",true}};
	//String[] columnheaders={"Name","SurName","Veg"};
	//mytable=new JTable(data,columnheaders);
	mytable=new JTable();
	mytable.setFont(new Font("Serg UI",Font.PLAIN,16));
	
	JScrollPane sp=new JScrollPane(mytable);
	sp.setBounds(0, 0, 400, 155);
	btn.setBounds(100, 201, 150, 30);
	btn.setVisible(true);
	myframe.add(sp);
	myframe.add(btn);
	myframe.setVisible(true);
	
	DefaultTableModel tbm= new DefaultTableModel()
	{
	    private static final long serialVersionUID = 1L;
		public  Class <?> getColumnClass(int column)
    		{
    		    switch (column)
    		    {
    		    case 0:
    			return String.class;
    		    case 1:
    			return String.class;
    		    case 2:
    			return Boolean.class;
		    default:
			return String.class;
    		}
	}
};
mytable.setModel(tbm);
tbm.addColumn("Name");
tbm.addColumn("SurName");
tbm.addColumn("Veg");
	//data for row one
    tbm.addRow(new Object[ 0]);
    tbm.setValueAt(false, 0, 2);
    tbm.setValueAt("Bhavin", 0, 0);
    tbm.setValueAt("Sanghani", 0, 1);
    // data for row 2
    tbm.addRow(new Object[1]);
    tbm.setValueAt(false, 1, 2);
    tbm.setValueAt("Nandita", 1, 0);
    tbm.setValueAt("Sanghani", 1, 1);
    //data for row3
    tbm.addRow(new Object[2]);
    tbm.setValueAt(false, 2, 2);
    tbm.setValueAt("Nikeeta", 2, 0);
    tbm.setValueAt("Sanghani", 2, 1);
    //data for row4
    tbm.addRow(new Object[3]);
    tbm.setValueAt(false, 3, 2);
    tbm.setValueAt("Dhairya", 3, 0);
    tbm.setValueAt("Sanghani", 3, 1);
    
    		btn.addActionListener(new ActionListener()
                	{
              	    @Override
                	    public void actionPerformed(ActionEvent e) {
                		// get the rows which have been selected
                		for (int xx=0;xx<mytable.getRowCount();xx++)
                			{
                		    Boolean checked = Boolean.valueOf(mytable.getValueAt(xx, 2).toString());
                		    String []col= {mytable.getValueAt(xx, 0).toString(),mytable.getValueAt(xx, 1).toString(), mytable.getValueAt(xx, 2).toString()};
                		    if (checked)
                		    JOptionPane.showMessageDialog(btn, col);
                			} // end of for loop
                	    } // end of action event
                	}); // end of button action listener
    	    	 // following is another way to do the same thing
    	    	// following is more useful for adding buttons to the columns
    	                  /*
                public Component getTableCellRendererComponent(JTable mytable, Object obj, boolean selected,boolean focused, int row, int col) {
                            		    	return this;
                            			}
                             */
      } // end of constructor
    } // end of class